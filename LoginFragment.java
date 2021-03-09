package cat.itb.karaokeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginFragment extends AppCompatActivity {

    TextInputLayout username;
    TextInputLayout psswd;
    Button loginButton;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login_test);

        username = findViewById(R.id.usernameInput);
        psswd = findViewById(R.id.passwordInput);

        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(username.getEditText().getText().toString().isEmpty()) {

                    username.setErrorEnabled(true);
                    username.setError(getString(R.string.required_field));

                }
                if(psswd.getEditText().getText().toString().isEmpty()){

                    psswd.setErrorEnabled(true);
                    psswd.setError(getString(R.string.required_field));

                }

                if(!username.getEditText().getText().toString().isEmpty() || psswd.getEditText().getText().toString().isEmpty()){

                    username.setErrorEnabled(false);
                    psswd.setErrorEnabled(false);
                    changeFragment(new BlankFragment());

                }
            }
        });

    }

    public void changeFragment(Fragment currentFragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, currentFragment).commit();
    }
}