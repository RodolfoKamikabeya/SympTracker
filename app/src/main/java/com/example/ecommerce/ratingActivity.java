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

    Button rateButton;
    RatingBar ratingStars;

    int myRating =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        rateButton = findViewById(R.id.ratebutton);
        ratingStars = findViewById(R.id.ratingBar);

        // Intent to identify which question will be stored in the database
        int rate = 0;

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null){
            rate = extras.getInt("rate"); }
        String rateQuestion = null;
        switch  (rate) {

            case 1 :
                rateQuestion = "Question 1";
                break;
            case 2:
                rateQuestion = "Question 2";
                break;
            case 3 :
                rateQuestion = "Question 3";
                break;
            case 4:
                rateQuestion = "Question 4";
                break;
            case 5 :
                rateQuestion = "Question 5";
                break;

        }

        // Changing rate class, toast a message according to the rate description
        final String finalRateQuestion = rateQuestion;

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
                rating(finalRateQuestion, myRating);
            }
        });

    }

    private void rating(final String rateQuestion, final int myRating) {

        // Access the database and store user rating system
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    HashMap<String,Object> userdataMap = new HashMap<>();
                    userdataMap.put("question",rateQuestion);
                    userdataMap.put("rating",myRating);

                    RootRef.child("Users").child(rateQuestion).updateChildren(userdataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task)
                                {
                                    if (task.isSuccessful())
                                    {
                                        Toast.makeText(ratingActivity.this, "Your rate was recorded", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(ratingActivity.this, HomeActivity.class);
                                        startActivity(intent);
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