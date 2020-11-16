package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;


public class HomeActivity extends AppCompatActivity {

    private ImageView heartIcon, CardiovascularButton;
    private ImageView neuroIcon, NeurologicalButton;
    private ImageView respIcon, RespiratoryButton;
    private ImageView digestIcon, DigestoryButton;
    private ImageView integumIcon, IntegumentaryButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        heartIcon = (ImageView) findViewById(R.id.heart);
        CardiovascularButton = (ImageView) findViewById(R.id.CardiovascularImg);

        neuroIcon = (ImageView) findViewById(R.id.neuro);
        NeurologicalButton = (ImageView) findViewById(R.id.NeurologicalImg);

        respIcon = (ImageView) findViewById(R.id.resp);
        RespiratoryButton = (ImageView) findViewById(R.id.RespiratoryImg);

        digestIcon = (ImageView) findViewById(R.id.digest);
        DigestoryButton = (ImageView) findViewById(R.id.DigestiveImg);

        integumIcon = (ImageView) findViewById(R.id.Integum);
        IntegumentaryButton = (ImageView) findViewById(R.id.IntegumentaryImg);

        // Icons - On Click initiate the Home Activity (Display the categories details)
        heartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DetailsActivity.class);
                intent.putExtra("position",1);
                startActivity(intent);

            }
        });

        neuroIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DetailsActivity.class);
                intent.putExtra("position",2);
                startActivity(intent);

            }
        });

        respIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DetailsActivity.class);
                intent.putExtra("position",3);
                startActivity(intent);

            }
        });

        digestIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DetailsActivity.class);
                intent.putExtra("position",4);
                startActivity(intent);

            }
        });

        integumIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DetailsActivity.class);
                intent.putExtra("position",5);
                startActivity(intent);

            }
        });

        // Category Buttons - On Click initiate the Home Activity (Display the categories symptoms)
        CardiovascularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, QuestionsActivity.class);
                intent.putExtra("position",1);
                startActivity(intent);
            }
        });

        NeurologicalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, QuestionsActivity.class);
                intent.putExtra("position",2);
                startActivity(intent);
            }
        });

        RespiratoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, QuestionsActivity.class);
                intent.putExtra("position",3);
                startActivity(intent);
            }
        });

        DigestoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, QuestionsActivity.class);
                intent.putExtra("position",4);
                startActivity(intent);
            }
        });

        IntegumentaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, QuestionsActivity.class);
                intent.putExtra("position",5);
                startActivity(intent);
            }
        });



    }


}