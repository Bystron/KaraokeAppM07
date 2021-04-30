package cat.itb.karaokeapp.fragments;

import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cat.itb.karaokeapp.R;
import cat.itb.karaokeapp.adapter.TrackAdapter;
import cat.itb.karaokeapp.apiPOJOS.Track;


public class UserScreenFragment extends Fragment {

    private List<Track> popSongs;
    private List<Track> recSongs;
    private RecyclerView recyclerPopular;
    private RecyclerView recyclerRec;
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapterRec;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.LayoutManager layoutManagerRec;

    public UserScreenFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        popSongs = this.getAllPopSongs();
        recSongs = this.getAllRecSongs();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_user_screen, container, false);

        recyclerPopular = v.findViewById(R.id.recylcerViewPop);
        recyclerRec = v.findViewById(R.id.recylcerViewRec);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManagerRec = new LinearLayoutManager(getActivity());
        adapter = new TrackAdapter(popSongs, R.layout.item_view, new TrackAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Track name, int position) {
                changeFragment(new LyricsFragment());
            }
        });
        adapterRec = new TrackAdapter(recSongs, R.layout.item_view, new TrackAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Track name, int position) {
                changeFragment(new LyricsFragment());
            }
        });

        recyclerPopular.setLayoutManager(layoutManager);
        recyclerPopular.setAdapter(adapter);
        recyclerRec.setLayoutManager(layoutManagerRec);
        recyclerRec.setAdapter(adapterRec);

        return v;

    }

    private void changeFragment(Fragment currentFragment) {
        getFragmentManager().beginTransaction().replace(R.id.content, currentFragment).commit();
    }

    private List<Track> getAllPopSongs(){

        return new ArrayList<Track>(){{
            add(new Track("Test", "Test"));
            add(new Track("Test", "Test"));
            add(new Track("Test", "Test"));
            add(new Track("Test", "Test"));
            add(new Track("Test", "Test"));
            add(new Track("Test", "Test"));
            add(new Track("Test", "Test"));
            add(new Track("Test", "Test"));
        }};

    }

    private List<Track> getAllRecSongs(){

        return new ArrayList<Track>(){{
            add(new Track("Test", "Test"));
            add(new Track("Test", "Test"));
            add(new Track("Test", "Test"));
            add(new Track("Test", "Test"));
            add(new Track("Test", "Test"));
            add(new Track("Test", "Test"));
            add(new Track("Test", "Test"));
            add(new Track("Test", "Test"));
            add(new Track("Test", "Test"));
            add(new Track("Test", "Test"));
            add(new Track("Test", "Test"));
            add(new Track("Test", "Test"));
            add(new Track("Test", "Test"));
            add(new Track("Test", "Test"));
            add(new Track("Test", "Test"));
            add(new Track("Test", "Test"));

        }};

    }

}