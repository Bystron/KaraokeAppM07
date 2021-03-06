package cat.itb.karaokeapp.fragments;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cat.itb.karaokeapp.R;
import cat.itb.karaokeapp.adapter.TrackAdapter;
import cat.itb.karaokeapp.apiPOJOS.Track;
import cat.itb.karaokeapp.apiPOJOS.TrackInfo;

//Clase que guarda los datos de las canciones guardadas por el usuario
public class SavedSongsFragment extends Fragment {

    private List<Track> savedSongs;

    private RecyclerView recyclerSaved;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public SavedSongsFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }

        savedSongs = this.getAllSavedSongs();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_saved_songs, container, false);

        recyclerSaved = v.findViewById(R.id.recyclerSaved);
        layoutManager = new LinearLayoutManager(getActivity());
        adapter = new TrackAdapter(savedSongs, R.layout.item_view, new TrackAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Track name, int position) {
                changeFragment(new LyricsFragment());
            }
        });

        recyclerSaved.setLayoutManager(layoutManager);
        recyclerSaved.setAdapter(adapter);

        return v;
    }

    //Método para obtener todas las canciones guardadas si la API funcionara.
    private List<Track> getAllSavedSongs(){

        return new ArrayList<Track>(){{
            add(new Track(new TrackInfo("Test", "Test")));
            add(new Track(new TrackInfo("Test", "Test")));
            add(new Track(new TrackInfo("Test", "Test")));
            add(new Track(new TrackInfo("Test", "Test")));
            add(new Track(new TrackInfo("Test", "Test")));
            add(new Track(new TrackInfo("Test", "Test")));
            add(new Track(new TrackInfo("Test", "Test")));
            add(new Track(new TrackInfo("Test", "Test")));

        }};

    }

    private void changeFragment(android.app.Fragment currentFragment) {
        getFragmentManager().beginTransaction().replace(R.id.content, currentFragment).commit();
    }
}