package cat.itb.karaokeapp.fragments;

import android.os.Bundle;

import android.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

//Fragment que muestra las lyrics de la cancion, se rige por el valor track_id, que comparten tracks y lyrics
public class LyricsOnClickFragment extends Fragment {

    private Retrofit retrofit;
    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient.Builder httpClientBuilder;

    private TextView lyricstext;


    final String BASEURL = "https://api.musixmatch.com/ws/1.1/";

    private String songName;
    private String lyricsId;

    public LyricsOnClickFragment() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = this.getArguments();
        songName = bundle.getString("songName");
        lyricsId = bundle.getString("lyricsID");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_lyricsonclick, container, false);

        lyricstext = v.findViewById(R.id.lyricsOnClick);

        lanzarPeticion();



        return v;
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
                lyricstext.setText(lyricspeticion);
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d("TAG1", "Error: " + t.getMessage());
            }
        });
    }
}