package cat.itb.karaokeapp.fragments;

import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import cat.itb.karaokeapp.R;

public class RegisterFragment extends Fragment {

    TextInputLayout usernameText;
    TextInputLayout passwordText;
    TextInputLayout repeatPassword;
    TextInputLayout emailText;
    TextInputLayout nameText;
    TextInputLayout surnameText;
    TextInputLayout birthdateText;
    TextInputLayout gender;
    CheckBox termsBox;
    Button login;
    Button register;
    ProgressBar progressBar;
    FirebaseAuth fAuth;


    public RegisterFragment() {
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

        View v = inflater.inflate(R.layout.fragment_register, container, false);


        usernameText = v.findViewById(R.id.loginText);
        passwordText = v.findViewById(R.id.passwordText);
        repeatPassword = v.findViewById(R.id.repeatPasswordText);
        emailText = v.findViewById(R.id.emailText);
        nameText = v.findViewById(R.id.nameText);
        surnameText = v.findViewById(R.id.surnameText);
        birthdateText = v.findViewById(R.id.birthDate);
        gender = v.findViewById(R.id.menu);
        termsBox = v.findViewById(R.id.acceptBox);
        login = v.findViewById(R.id.loginButton);
        register = v.findViewById(R.id.registerButton);

        progressBar = v.findViewById(R.id.progressBar2);
        fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null){
            changeFragment(new UserContentFragment());
        }


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean pass = checkData();

                if(pass){
                    String email = emailText.getEditText().getText().toString();
                    String password = passwordText.getEditText().getText().toString();
                    progressBar.setVisibility(View.VISIBLE);
                    fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getActivity(), "Registered and logged in successfully.", Toast.LENGTH_SHORT).show();
                                changeFragment(new UserContentFragment());
                            }else{
                                Toast.makeText(getActivity(), "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.INVISIBLE);
                            }
                        }
                    });

                }else{

                    Toast.makeText(getActivity(), "All fields must be filled.", Toast.LENGTH_SHORT).show();

                }

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeFragment(new LoginFragment());

            }
        });



        return v;
    }

    private boolean checkData(){

        if(!usernameText.getEditText().getText().toString().isEmpty()){
            if(!passwordText.getEditText().getText().toString().isEmpty()){
                if(!repeatPassword.getEditText().getText().toString().isEmpty()){
                    if(!emailText.getEditText().getText().toString().isEmpty()){
                        if(!nameText.getEditText().getText().toString().isEmpty()){
                            if(!surnameText.getEditText().getText().toString().isEmpty()){
                                if(!birthdateText.getEditText().toString().isEmpty()){
                                    if(!gender.getEditText().getText().toString().isEmpty()){
                                        if(termsBox.isChecked()){
                                            return true;
                                        }else{
                                            termsBox.setError(getString(R.string.required_field));
                                            gender.setErrorEnabled(false);
                                        }
                                    }else{
                                        gender.setErrorEnabled(true);
                                        gender.setError(getString(R.string.required_field));
                                        birthdateText.setErrorEnabled(false);
                                    }
                                }else{
                                    birthdateText.setErrorEnabled(true);
                                    birthdateText.setError(getString(R.string.required_field));
                                    surnameText.setErrorEnabled(false);
                                }
                            }else{
                                surnameText.setErrorEnabled(true);
                                surnameText.setError(getString(R.string.required_field));
                                nameText.setErrorEnabled(false);
                            }
                        }else{
                            nameText.setErrorEnabled(true);
                            nameText.setError(getString(R.string.required_field));
                            emailText.setErrorEnabled(false);
                        }
                    }else{
                        emailText.setErrorEnabled(true);
                        emailText.setError(getString(R.string.required_field));
                        repeatPassword.setErrorEnabled(false);
                    }
                }else{
                    repeatPassword.setErrorEnabled(true);
                    repeatPassword.setError(getString(R.string.required_field));
                    passwordText.setErrorEnabled(false);
                }
            }else{
                passwordText.setErrorEnabled(true);
                passwordText.setError(getString(R.string.required_field));
                nameText.setErrorEnabled(false);
            }
        }else{
            usernameText.setErrorEnabled(true);
            usernameText.setError(getString(R.string.required_field));
        }

        return false;
    }

    private void changeFragment(Fragment currentFragment) {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, currentFragment).commit();
    }
}