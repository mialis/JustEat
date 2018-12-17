package org.elis.jp4application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;


public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    TextView welcomeTW;
    String email;
    String openedEmail;

    RecyclerView recyclerView;

    LinearLayoutManager layoutManager;
    FoodListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_welcome);

        welcomeTW= findViewById(R.id.welcome_tv);
        welcomeTW.setOnClickListener(this);

        recyclerView = findViewById(R.id.food_rv);

        layoutManager = new LinearLayoutManager(this);

        ArrayList<Food> foodList = new ArrayList<>();
        foodList.add(new Food("pizza", 2.00f));
        foodList.add(new Food("carbonara", 2.00f));
        foodList.add(new Food("casatiello", 2.00f));

        adapter = new FoodListAdapter(this, foodList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        if(getIntent().getStringExtra("EMAIL") != null){
            email= getIntent().getStringExtra(MainActivity.EMAIL);
            welcomeTW.setText(email);
        } else {
            openedEmail = Objects.requireNonNull(getIntent().getData().toString().substring(7));
            openedEmail = Uri.decode(openedEmail);
            welcomeTW.setText(openedEmail);
        }




    }

    public void sendEmail(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", getIntent().getStringExtra("EMAIL"), null));
        startActivity(Intent.createChooser(intent, "Choose an Email client: "));
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.welcome_tv){
            sendEmail(this.welcomeTW);
        }
    }
}
