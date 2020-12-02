package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class PersonalQuestion extends AppCompatActivity {

    private EditText SymptomTreNo, FamilyHis,yes_no, lastname;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_question);

        String category = null;


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null){
            category=extras.getString("category");}

        SymptomTreNo = (EditText) findViewById(R.id.treat_answer);
        FamilyHis = (EditText) findViewById(R.id.family_answer);
        yes_no = (EditText) findViewById(R.id.yes_no);
        lastname = (EditText) findViewById(R.id.LastName);
        button = findViewById(R.id.button);


        final String finalCategory = category;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreatePersonalData(finalCategory);
            }
        });
    }

    //receive and populate the users personal questions answers
    private void CreatePersonalData(String category) {
        String Symptom = SymptomTreNo.getText().toString();
        String FamilyAnswer = FamilyHis.getText().toString();
        String before_y_n = yes_no.getText().toString();
        String LastN = lastname.getText().toString();

        // check if the requested fields was answered
        if (TextUtils.isEmpty(LastN)){
            Toast.makeText(this, "Please write your answer ", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(before_y_n)){
            Toast.makeText(this, "Please write your answer ", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(FamilyAnswer)){
            Toast.makeText(this, "Please write your answer ", Toast.LENGTH_SHORT).show();
        }
        else {
            PersonalData(Symptom, before_y_n, FamilyAnswer,LastN,category);
        }
    }

    // Access the database and store user personal question system
    private void PersonalData(final String Symptom, final String before_y_n, final String FamilyAnswer, final String LastName, final String category) {


      // Access the database and store user personal question system
        final DatabaseReference RootRef ;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //Check the user answer for question
                HashMap<String,Object> userdataMap = new HashMap<>();
                userdataMap.put("How are symptoms treated now",Symptom);
                userdataMap.put("Have you experience symptoms?",before_y_n);
                userdataMap.put("FamilyHistory",FamilyAnswer);

                //Create a Node called SystemTreated on Firebase and Store the user answers
                RootRef.child("SystemTreated").child(LastName).updateChildren(userdataMap)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task)
                            {
                                if (task.isSuccessful())
                                {
                                    Toast.makeText(PersonalQuestion.this, "Your personal question was recorded", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(PersonalQuestion.this, Diagnosis.class);
                                    intent.putExtra("category",category);
                                    Log.d("tag","category PQ " + category);
                                   startActivity(intent);
                                }
                                else
                                {
                                    Toast.makeText(PersonalQuestion.this, "Please try again", Toast.LENGTH_SHORT).show();
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


