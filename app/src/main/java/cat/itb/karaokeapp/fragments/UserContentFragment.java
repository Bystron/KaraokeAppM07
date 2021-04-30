package cat.itb.karaokeapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import cat.itb.karaokeapp.R;


public class UserContentFragment extends Fragment {

    BottomNavigationView bottomNavigationView;

    Button logout;
    Toolbar toolbar;

    public UserContentFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null) {
            changeFragment(R.id.content, new UserScreenFragment());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_user_content, container, false);

        bottomNavigationView = v.findViewById(R.id.bottom_navigation);
        logout = v.findViewById(R.id.logout);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.inicio:
                        changeFragment(R.id.content, new UserScreenFragment());
                        return true;
                    case R.id.playlist:
                        changeFragment(R.id.content, new SavedSongsFragment());
                        return true;
                    case R.id.buscar:
                        changeFragment(R.id.content, new SearchFragment());
                        return true;
                }
                return false;
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeFragment(R.id.fragment_container, new IntroFragment());

            }
        });

        return v;
    }

    private void changeFragment(int layout ,Fragment currentFragment) {
        getFragmentManager().beginTransaction().replace(layout, currentFragment).commit();
    }
}