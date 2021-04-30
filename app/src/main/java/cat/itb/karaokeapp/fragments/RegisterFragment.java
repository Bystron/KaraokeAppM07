package cat.itb.karaokeapp.fragments;

import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

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


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean pass = checkData();

                if(pass){

                    changeFragment(new UserContentFragment());

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