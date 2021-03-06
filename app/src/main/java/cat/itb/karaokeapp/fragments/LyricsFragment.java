package cat.itb.karaokeapp.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import android.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

import cat.itb.karaokeapp.R;
import cat.itb.karaokeapp.apiPOJOS.Data;
import cat.itb.karaokeapp.webservice.WebServiceClient;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Clase que se encarga de enseñar y mostrar las letras y la canción.
public class LyricsFragment extends Fragment {


    private Retrofit retrofit;
    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient.Builder httpClientBuilder;

    final String BASEURL = "https://api.musixmatch.com/ws/1.1/";
    private String lyricsId;

    TextView mTextStatus;
    ScrollView mScrollView;
    ImageButton button;
    SeekBar sBar;
    int cont;


    public LyricsFragment() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        lyricsId = bundle.getString("lyricsID");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_lyrics, container, false);

        cont = 0;

        mTextStatus = v.findViewById(R.id.lyrics);
        mScrollView = v.findViewById(R.id.scrollView2);
        button = v.findViewById(R.id.btnPlay);
        sBar = v.findViewById(R.id.sBar);

        lanzarPeticion();

        MediaPlayer player = MediaPlayer.create(getActivity(), R.raw.samba);

        scrollToBottom();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!player.isPlaying()){

                    player.start();

                    button.setImageResource(R.drawable.outline_pause_black_24dp);
                }else{
                    player.pause();

                    button.setImageResource(R.drawable.playbtn);
                }

            }
        });

        return v;
    }

    //Método para bajar la letra de la canción automáticamente.
    private void scrollToBottom()
    {
        mScrollView.post(new Runnable()
        {
            public void run()
            {
                mScrollView.smoothScrollTo(0, mTextStatus.getBottom());
            }
        });
    }
    private void lanzarPeticion() {
        loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

        retrofit = new Retrofit.Builder().baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        WebServiceClient client = retrofit.create(WebServiceClient.class);
        Call<Data> call = client.getLyrics("https://api.musixmatch.com/ws/1.1/track.lyrics.get?track_id=+"+ lyricsId +"+&apikey=dbeb843956759fd467bb823266c749a6");
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                String lyricspeticion = response.body().getMessage().getBody().getLyrics().toString();
                mTextStatus.setText(lyricspeticion);
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d("TAG1", "Error: " + t.getMessage());
            }
        });
    }


}