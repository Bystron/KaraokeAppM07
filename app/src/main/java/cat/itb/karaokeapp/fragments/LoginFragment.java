package cat.itb.karaokeapp.fragments;

import android.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import cat.itb.karaokeapp.R;

public class LoginFragment extends Fragment {

    TextInputLayout username;
    TextInputLayout psswd;
    Button loginButton;
    Button registerButton;

    ProgressBar progressBar;
    FirebaseAuth auth;

    public LoginFragment() {
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

        View v = inflater.inflate(R.layout.fragment_login, container, false);


        username = v.findViewById(R.id.loginText);
        psswd = v.findViewById(R.id.passwordText);
        loginButton = v.findViewById(R.id.loginButton);
        registerButton = v.findViewById(R.id.registerButton);

        progressBar = v.findViewById(R.id.progressBar);
        auth = FirebaseAuth.getInstance();


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean pass = checkData();

                if(pass){
                    String email = username.getEditText().getText().toString();
                    String password = psswd.getEditText().getText().toString();
                    progressBar.setVisibility(View.VISIBLE);

                    auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getActivity(), "Logged in successfully", Toast.LENGTH_SHORT).show();
                                changeFragment(new UserContentFragment());
                            }else{
                                Toast.makeText(getActivity(), "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                }else{
                    Toast.makeText(getActivity(), "All fields must be filled", Toast.LENGTH_SHORT).show();
                }

            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new RegisterFragment());
            }
        });

        return v;
    }

    private boolean checkData(){
        if(!username.getEditText().getText().toString().isEmpty()){
            if(!psswd.getEditText().getText().toString().isEmpty()){
                return true;
            }else{
                psswd.setErrorEnabled(true);
                psswd.setError(getString(R.string.required_field));
            }
        }else{
            username.setErrorEnabled(true);
            username.setError(getString(R.string.required_field));
        }
        return false;
    }

    private void changeFragment(Fragment currentFragment) {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, currentFragment).commit();
    }
}