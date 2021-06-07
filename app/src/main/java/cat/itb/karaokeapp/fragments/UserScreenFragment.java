package cat.itb.karaokeapp.fragments;

import android.os.Bundle;

import android.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cat.itb.karaokeapp.R;
import cat.itb.karaokeapp.adapter.TrackAdapter;
import cat.itb.karaokeapp.apiPOJOS.Data;
import cat.itb.karaokeapp.apiPOJOS.Message;
import cat.itb.karaokeapp.apiPOJOS.Track;
import cat.itb.karaokeapp.apiPOJOS.TrackInfo;
import cat.itb.karaokeapp.webservice.WebServiceClient;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
Esta clase es la que muestra las canciones populares y las canciones cantadas recientemente.
 */
public class UserScreenFragment extends Fragment {

    private List<Track> popSongs;
    private List<Track> recSongs;
    private RecyclerView recyclerPopular;
    private RecyclerView recyclerRec;
    private TrackAdapter adapter;
    private RecyclerView.Adapter adapterRec;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.LayoutManager layoutManagerRec;


    private Retrofit retrofit;
    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient.Builder httpClientBuilder;

    final String BASEURL = "https://api.musixmatch.com/ws/1.1/";


    public UserScreenFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        popSongs = this.getAllPopSongs();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_user_screen, container, false);

        recyclerPopular = v.findViewById(R.id.recylcerViewPop);
        recyclerRec = v.findViewById(R.id.recylcerViewRec);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManagerRec = new LinearLayoutManager(getActivity());
        adapter = new TrackAdapter(popSongs, R.layout.item_view, new TrackAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Track name, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("lyricsID", name.getTrackInfo().getTrack_id());

                LyricsFragment lyricsFragment = new LyricsFragment();
                lyricsFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, lyricsFragment).commit();
            }
        });


        recyclerPopular.setLayoutManager(layoutManager);
        recyclerPopular.setAdapter(adapter);


        lanzarPeticion();

        return v;

    }


    //Método para obtener todas las canciones populares
    private List<Track> getAllPopSongs(){

        return new ArrayList<Track>(){{
            add(new Track(new TrackInfo("test", "test")));
            add(new Track(new TrackInfo("test", "test")));
            add(new Track(new TrackInfo("test", "test")));
            add(new Track(new TrackInfo("test", "test")));
            add(new Track(new TrackInfo("test", "test")));
            add(new Track(new TrackInfo("test", "test")));
            add(new Track(new TrackInfo("test", "test")));
            add(new Track(new TrackInfo("test", "test")));
        }};

    }


    //Método que lanza una petición a la API y enseñar las canciones populares en su recycler view.
    private void lanzarPeticion(){
        loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

        retrofit = new Retrofit.Builder().baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        WebServiceClient client = retrofit.create(WebServiceClient.class);
        Call<Data> call = client.getTopTracks();
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                adapter.setTracks(response.body().getMessage().getBody().getTracks());
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d("TAG1", "Error: " + t.getMessage());
            }
        });
    }

}