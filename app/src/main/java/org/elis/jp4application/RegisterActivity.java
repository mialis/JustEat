package org.elis.jp4application;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity  {

    EditText emailET;
    EditText passwordET;
    EditText phoneET;

    Button registerBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        emailET = findViewById(R.id.email_et);
        passwordET = findViewById(R.id.password_et);
        phoneET = findViewById(R.id.phone_et);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (isValidEmail() && isValidPassword() && isValidPhone()){
                    registerBtn.setEnabled(true);
                } else {
                    registerBtn.setEnabled(false);
                }
            }
        };

        emailET.addTextChangedListener(textWatcher);
        passwordET.addTextChangedListener(textWatcher);
        phoneET.addTextChangedListener(textWatcher);



        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Register successfully", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(RegisterActivity.this,
                        MainActivity.class);
                startActivity(i);
            }
        });

    }



    private boolean isValidEmail(){
        String email = emailET.getText().toString();
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();

    }


    private boolean isValidPassword(){
        String password = passwordET.getText().toString();
        return (password.length() > 6);
    }

    private boolean isValidPhone(){
        String phoneNumber = phoneET.getText().toString();
        return (phoneNumber.length() == 10);
    }

}


