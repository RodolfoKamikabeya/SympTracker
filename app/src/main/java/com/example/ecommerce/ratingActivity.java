package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class ratingActivity extends AppCompatActivity {

    Button rateButton;
    RatingBar ratingStars;

    int myRating =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        rateButton = findViewById(R.id.ratebutton);
        ratingStars = findViewById(R.id.ratingBar);

        ratingStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float ratingV, boolean fromUser) {

                int rating = (int) ratingV;
                String message = null;
                myRating = (int) ratingBar.getRating();

                switch (rating) {
                    case 1 :
                        message ="No Symptoms ";
                        break;
                    case 2:
                        message ="Not sure if I am feeling the Symptoms ";
                        break;
                    case 3 :
                        message ="Start feeling the Symptoms";
                        break;
                    case 4 :
                        message ="Feeling the Symptoms ";
                        break;
                    case 5 :
                        message ="Strongly feeling the Symptoms ";
                        break;

                    default:
                }
                Toast.makeText(ratingActivity.this,message,Toast.LENGTH_SHORT).show();
            }
        });

        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ratingActivity.this,String.valueOf(myRating),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ratingActivity.this, QuestionsActivity.class);
                startActivity(intent);
            }
        });

    }
}