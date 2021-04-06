package cat.itb.karaokeapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SearchFragment extends Fragment {

    BottomNavigationView bottomNavigationView;

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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search, container, false);

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

        return v;
    }

    private void changeFragment(android.app.Fragment currentFragment) {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, currentFragment).commit();
    }
}