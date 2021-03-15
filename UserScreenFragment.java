package cat.itb.karaokeapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textfield.TextInputLayout;

public class UserScreenFragment extends Fragment {

    RecyclerView popularSongs;
    RecyclerView recentSongs;
    //PopularAdapter;
    //RecentAdapter;

    public UserScreenFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_user_screen, container, false);

        /*
        popularSongs = v.findViewById(R.id.popuRecyclerView);
        recentSongs = v.findViewById(R.id.recentRecyclerView);

        popularSongs.setAdapter(popularAdapter);
        recentSongs.setAdapter(recentAdapter);
         */

        return v;

    }
}