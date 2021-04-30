package cat.itb.karaokeapp.activities;

import android.app.Fragment;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import cat.itb.karaokeapp.fragments.IntroFragment;
import cat.itb.karaokeapp.R;
import cat.itb.karaokeapp.fragments.UserContentFragment;


public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        if(savedInstanceState == null){
            if(auth.getCurrentUser() != null){
                changeFragment(new UserContentFragment());
            }else {
                IntroFragment intro = new IntroFragment();
                changeFragment(intro);
            }
        }

    }

    private void changeFragment(Fragment currentFragment) {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, currentFragment).commit();
    }

}