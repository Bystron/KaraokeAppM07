package cat.itb.karaokeapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class RegisterFragment extends Fragment {

    TextInputLayout usernameText;
    TextInputLayout passwordText;
    TextInputLayout repeatPassword;
    TextInputLayout emailText;
    TextInputLayout nameText;
    TextInputLayout surnameText;
    Button birthdateButton;
    TextInputLayout gender;
    CheckBox termsBox;
    Button login;
    Button register;


    public RegisterFragment() {
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

        View v = inflater.inflate(R.layout.fragment_register, container, false);

        /*
        usernameText = v.findViewById(R.id.registerUserName);
        passwordText = v.findViewById(R.id.registerPasswordInput);
        repeatPassword = v.findViewById(R.id.registerRepPsswd);
        emailText = v.findViewById(R.id.emailInput);
        nameText = v.findViewById(R.id.nameInput);
        surnameText = v.findViewById(R.id.surnameInput);
        birthdateButton = v.findViewById(R.id.birthdateButton);
        gender = v.findViewById(R.id.genderInput);
        termsBox = v.findViewById(R.id.termsCheckBox);
        login = v.findViewById(R.id.regLoginButton);
        register = v.findViewById(R.id.regRegisterButton);
        */

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean pass = checkData();

                if(pass){

                    changeFragment(new UserScreenFragment());

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
                                if(!birthdateButton.getText().toString().isEmpty()){
                                    if(!gender.getEditText().getText().toString().isEmpty()){
                                        if(termsBox.isChecked()){
                                            return true;
                                        }else{
                                            termsBox.setError(getString(R.string.required_field));
                                        }
                                    }else{
                                        gender.setErrorEnabled(true);
                                        gender.setError(getString(R.string.required_field));
                                    }
                                }else{
                                    birthdateButton.setError(getString(R.string.required_field));
                                }
                            }else{
                                surnameText.setErrorEnabled(true);
                                surnameText.setError(getString(R.string.required_field));
                            }
                        }else{
                            nameText.setErrorEnabled(true);
                            nameText.setError(getString(R.string.required_field));
                        }
                    }else{
                        emailText.setErrorEnabled(true);
                        emailText.setError(getString(R.string.required_field));
                    }
                }else{
                    repeatPassword.setErrorEnabled(true);
                    repeatPassword.setError(getString(R.string.required_field));
                }
            }else{
                passwordText.setErrorEnabled(true);
                passwordText.setError(getString(R.string.required_field));
            }
        }else{
            nameText.setErrorEnabled(true);
            nameText.setError(getString(R.string.required_field));
        }

        return false;
    }

    private void changeFragment(Fragment currentFragment) {
        getFragmentManager().beginTransaction().replace(R.id.fragment_register, currentFragment).commit();
    }
}