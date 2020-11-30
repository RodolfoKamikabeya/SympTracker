package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class QuestionsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView question;
    private Button option1, option2, option3,option4;
    private List<Question> questionList;
    DatabaseReference reff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        question = findViewById(R.id.Question);

        option1 = findViewById(R.id.Option1);
        option2 = findViewById(R.id.Option2);
        option3 = findViewById(R.id.Option3);
        option4 = findViewById(R.id.Option4);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);

        // Intent to idenfity which category was selected
        int position = 0;
        int categoryNum =0;

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            position = extras.getInt("position");
        }
        switch (position) {

            case 1:
                categoryNum =1;
                getQuestionsList(categoryNum);
                break;
            case 2:
                categoryNum =2;
                getQuestionsList(categoryNum);
                break;
            case 3:
                categoryNum =3;
                getQuestionsList(categoryNum);
                break;
            case 4:
                categoryNum =4;
                getQuestionsList(categoryNum);
                break;
            case 5:
                categoryNum =5;
                getQuestionsList(categoryNum);
                break;
            }

        }

    // Select the options according to selected category
    private void getQuestionsList(int categoryNum)
        {
            //create a new empty array to store the data
            questionList = new ArrayList<>();

            // Access the database system in the Symptoms Node
            reff = FirebaseDatabase.getInstance().getReference().child("Symptoms");
        switch (categoryNum) {

            case 1:
                // retrieve the data from Cardiovascular node
               reff = reff.child("Cardiovascular");
               reff.addValueEventListener(new ValueEventListener() {
                    @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String category = "Cardiovascular";
                        String symptoms1=dataSnapshot.child("symptoms1").getValue().toString();
                        String symptoms2=dataSnapshot.child("symptoms2").getValue().toString();
                        String symptoms3=dataSnapshot.child("symptoms3").getValue().toString();
                        String symptoms4=dataSnapshot.child("symptoms4").getValue().toString();
                        setQuestion(category,symptoms1,symptoms2,symptoms3,symptoms4);

                    }
                   @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) { }
               });

                break;
            case 2:
                // retrieve the data from Neurological node
                reff = reff.child("Neurological");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String category = "Neurological";
                        String symptoms1=dataSnapshot.child("symptoms1").getValue().toString();
                        String symptoms2=dataSnapshot.child("symptoms2").getValue().toString();
                        String symptoms3=dataSnapshot.child("symptoms3").getValue().toString();
                        String symptoms4=dataSnapshot.child("symptoms4").getValue().toString();
                        setQuestion(category,symptoms1,symptoms2,symptoms3,symptoms4);

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) { }
                });
                break;
            case 3:
                // retrieve the data from Respiratory node
                reff = reff.child("Respiratory");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String category = "Respiratory";
                        String symptoms1=dataSnapshot.child("symptoms1").getValue().toString();
                        String symptoms2=dataSnapshot.child("symptoms2").getValue().toString();
                        String symptoms3=dataSnapshot.child("symptoms3").getValue().toString();
                        String symptoms4=dataSnapshot.child("symptoms4").getValue().toString();
                        setQuestion(category,symptoms1,symptoms2,symptoms3,symptoms4);

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) { }
                });
                break;
            case 4:
                // retrieve the data from Digestive node
                reff = reff.child("Digestive");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String category = "Digestive";
                        String symptoms1=dataSnapshot.child("symptoms1").getValue().toString();
                        String symptoms2=dataSnapshot.child("symptoms2").getValue().toString();
                        String symptoms3=dataSnapshot.child("symptoms3").getValue().toString();
                        String symptoms4=dataSnapshot.child("symptoms4").getValue().toString();
                        setQuestion(category,symptoms1,symptoms2,symptoms3,symptoms4);

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) { }
                });
                break;
            case 5:
                // retrieve the data from Intergumentary node
                reff = reff.child("Intergumentary");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String category = "Intergumentary";
                        String symptoms1=dataSnapshot.child("symptoms1").getValue().toString();
                        String symptoms2=dataSnapshot.child("symptoms2").getValue().toString();
                        String symptoms3=dataSnapshot.child("symptoms3").getValue().toString();
                        String symptoms4=dataSnapshot.child("symptoms4").getValue().toString();
                        setQuestion(category,symptoms1,symptoms2,symptoms3,symptoms4);

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) { }
                });
                break;

            }


        }

    // Return the question data and populate our layout
    private void setQuestion(String category, String symptoms1,String symptoms2,String symptoms3,String symptoms4)
        {
                        question.setText(category);
                        option1.setText(symptoms1);
                        option2.setText(symptoms2);
                        option3.setText(symptoms3);
                        option4.setText(symptoms4);
        }

     // Used to identify which symptoms was selected
    @Override
    public void onClick(View v) {

        int selectedOption =0;

        switch (v.getId()) {
            case R.id.Option1 :
                selectedOption =1;
                break;
            case R.id.Option2 :
                selectedOption =2;
                break;
            case R.id.Option3 :
                selectedOption =3;
                break;
            case R.id.Option4 :
                selectedOption=4;
                break;
        }
        rateSymptoms(selectedOption);
    }

    // Call and Populate the rating Activity
    private void rateSymptoms(int selectedOption) {


        Intent intent = new Intent(QuestionsActivity.this, ratingActivity.class);
        intent.putExtra("rate",selectedOption);
        startActivity(intent);
        QuestionsActivity.this.finish();
    }
}