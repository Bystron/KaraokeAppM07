package cat.itb.karaokeapp;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import cat.itb.karaokeapp.adapter.TrackAdapter;
import cat.itb.karaokeapp.apiPOJOS.Track;
import cat.itb.karaokeapp.apiPOJOS.TrackData;
import cat.itb.karaokeapp.webservice.WebServiceClient;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SearchFragment extends Fragment {

    BottomNavigationView bottomNavigationView;

    private RecyclerView recycler;
    private TrackAdapter adapter;
    private List<Track> tracks;

    private Retrofit retrofit;
    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient.Builder httpClientBuilder;

    final String BASEURL = "https://api.musixmatch.com/ws/1.1/";

    EditText buscadorText;
    ImageButton botonBuscador;

    String trackBuscada;


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        recycler = v.findViewById(R.id.recyclerView);
        tracks = new ArrayList<Track>();

        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        buscadorText = v.findViewById(R.id.searchBar);
        botonBuscador = v.findViewById(R.id.searchButton);
        bottomNavigationView = v.findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.inicio:
                        changeFragment(new UserScreenFragment());
                        return true;
                    case R.id.playlist:
                        changeFragment(new SavedSongsFragment());
                        return true;
                    case R.id.buscar:
                        changeFragment(new SearchFragment());
                        return true;
                }
                return false;
            }
        });

  //      lanzarPeticion();

        buscadorText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 66 && event.getAction() == android.view.KeyEvent.ACTION_UP) {
                    searchTracks();
                }
                return false;
            }
        });
        botonBuscador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchTracks();
            }
        });
        return v;

    }


/*    private void lanzarPeticion() {
        loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

        retrofit = new Retrofit.Builder().baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        WebServiceClient client = retrofit.create(WebServiceClient.class);
        Call<TrackData> call = client.getTracks();
        call.enqueue(new Callback<TrackData>() {
            @Override
            public void onResponse(Call<TrackData> call, Response<TrackData> response) {
                adapter.setTracks(response.body().getResults());

            }

            @Override
            public void onFailure(Call<TrackData> call, Throwable t) {
                Log.d("TAG1", "Error: " + t.getMessage());
            }
        });
    }*/

    public void searchTracks() {
        trackBuscada = buscadorText.getText().toString();
        WebServiceClient client = retrofit.create(WebServiceClient.class);
        Call<TrackData> call = client.getTracks("http://api.musixmatch.com/ws/1.1/track.search?q_track=" + trackBuscada + "&apikey=05ab4180ffe070543821f5ceec8cceb8");
        call.enqueue(new Callback<TrackData>() {
            @Override
            public void onResponse(Call<TrackData> call, Response<TrackData> response) {
                adapter.setTracks(response.body().getResults());
            }

            @Override
            public void onFailure(Call<TrackData> call, Throwable t) {
                Log.d("TAG1", "Error: " + t.getMessage());
            }
        });
    }


    private void changeFragment(android.app.Fragment currentFragment) {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, currentFragment).commit();
    }
}