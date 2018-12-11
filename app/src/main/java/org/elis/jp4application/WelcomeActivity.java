package org.elis.jp4application;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class WelcomeActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_welcome);

        TextView welcomeTW= findViewById(R.id.welcome_tv);

        String mail= getIntent().getStringExtra(MainActivity.WELCOME);

        welcomeTW.setText(getString(R.string.welcome)+" "+mail);
    }
}
