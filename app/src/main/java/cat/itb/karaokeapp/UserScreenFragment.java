package cat.itb.karaokeapp;

import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class UserScreenFragment extends Fragment {

    Button logout;
    Button singPop;
    Button singRec;
    BottomNavigationView bottomNavigationView;

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

        logout = v.findViewById(R.id.logout);
        singPop = v.findViewById(R.id.singButtonPop);
        singRec = v.findViewById(R.id.singButtonRec);
        bottomNavigationView = v.findViewById(R.id.bottom_navigation);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeFragment(new IntroFragment());

            }
        });

        singPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeFragment(new LyricsFragment());

            }
        });

        singRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeFragment(new LyricsFragment());

            }
        });

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

    private void changeFragment(Fragment currentFragment) {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, currentFragment).commit();
    }
}