package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class ratingActivity extends AppCompatActivity {

    Button rateButton, submitButton;
    RatingBar ratingStars;

    int myRating =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        rateButton = findViewById(R.id.ratebutton);
        ratingStars = findViewById(R.id.ratingBar);
        submitButton = findViewById(R.id.submitRating);

        // Intent to identify which question will be stored in the database
        int rate = 0;
        String symptoms1 = null,symptoms2 = null, symptoms3 = null, symptoms4 = null;
        String answer=null;

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null){
            rate = extras.getInt("rate");
            symptoms1=extras.getString("symptoms1");
            symptoms2=extras.getString("symptoms2");
            symptoms3=extras.getString("symptoms3");
            symptoms4=extras.getString("symptoms4");}
        String rateQuestion = null;
        switch  (rate) {

            case 1 :
                rateQuestion = symptoms1;
                answer = "Symptom 1";
                break;
            case 2:
                rateQuestion = symptoms2;
                answer = "Symptom 2";
                break;
            case 3 :
                rateQuestion = symptoms3;
                answer = "Symptom 3";
                break;
            case 4:
                rateQuestion = symptoms4;
                answer = "Symptom 4";
                break;

        }

        // Changing rate class, toast a message according to the rate description
        final String finalRateQuestion = rateQuestion;
        final String finalAnswer = answer;

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

        //After click on rate button, populate the rating function
        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ratingActivity.this,String.valueOf(myRating),Toast.LENGTH_SHORT).show();
                rating(finalRateQuestion, myRating, finalAnswer);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ratingActivity.this, PersonalQuestion.class);
                startActivity(intent);
                ratingActivity.this.finish();
            }
        });
    }

    private void rating(final String rateQuestion, final int myRating, final String answer) {

        // Access the database and store user rating system
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    //Check the user answer for question (symptoms) and rate
                    HashMap<String,Object> userdataMap = new HashMap<>();
                    userdataMap.put("Symptoms",rateQuestion);
                    userdataMap.put("rating",myRating);

                    //Create a Node called HistorySymptoms on Firebase and Store the user question and rating
                    RootRef.child("HistorySymptoms").child(answer).updateChildren(userdataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task)
                                {
                                    if (task.isSuccessful())
                                    {
                                        Toast.makeText(ratingActivity.this, "Your rate was recorded", Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                    {
                                        Toast.makeText(ratingActivity.this, "Please try again", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }


}