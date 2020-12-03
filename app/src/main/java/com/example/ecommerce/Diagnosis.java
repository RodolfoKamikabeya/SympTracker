package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class Diagnosis extends AppCompatActivity {


    private TextView txtTitle16;
    private TextView txtTypeSymptom14;
    private TextView txtOverview16;
    private TextView txtHcommon10;
    private TextView txtSymptoms16;
    private TextView txtTreatment15;


    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis);

        String category =null;
        int diagnosiscat=0;
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null){
            category=extras.getString("category");}
        if(category.equals("Cardiovascular")){
            diagnosiscat =1;
        }
        else if(category.equals("Neurological")){
            diagnosiscat=2;
        }
        else if(category.equals("Respiratory")){
            diagnosiscat=3;
        }
        else if(category.equals("Digestive")){
            diagnosiscat=4;
        }
        else {
            diagnosiscat=5;
        }


        //as = Acute Sinusitis
        txtTitle16 = (TextView) findViewById(R.id.txtTitle16);
        txtTypeSymptom14  = (TextView) findViewById(R.id.txtTypeSymptom14);
        TextView tOverview = (TextView) findViewById(R.id.tvOverview);
        txtOverview16 = (TextView) findViewById(R.id.txtOverview16);
        TextView hCommon = (TextView) findViewById(R.id.tvCommon);
         txtHcommon10 = (TextView) findViewById(R.id.txtHcommon10);
        TextView symptomView = (TextView) findViewById(R.id.txtSymptomView);
        txtSymptoms16 = (TextView) findViewById(R.id.txtSymptoms16);
        TextView tTreatments = (TextView) findViewById(R.id.txtTreatment);
        txtTreatment15 = (TextView) findViewById(R.id.txtTreatment15);

        getRating(diagnosiscat);


    }



    private void getRating(final int diagnosiscat) {
        reff = FirebaseDatabase.getInstance().getReference().child("HistorySymptoms");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                collectRatingValue((Map<String,Object>) dataSnapshot.getValue(),diagnosiscat);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });


    }

    private void collectRatingValue(Map<String, Object> value, int diagnosiscat) {
        ArrayList<Long> ratingValue = new ArrayList<>();
        int rating=0;
        String Ratingvalue = "HighestRated";
        //iterate through each user, ignoring their UID
        for (Map.Entry<String, Object> entry : value.entrySet()){

            //Get user map
            Map singleUser = (Map) entry.getValue();
            //Get phone field and append to list
            ratingValue.add((Long) singleUser.get("rating"));
            Log.d("tag", "cat ollectRatingValue: " +ratingValue.toString());
        }
       for(int i=0; i<ratingValue.size()-1;i++)
            for(int k=i+1;k<ratingValue.size();k++)
                if(ratingValue.get(i)> ratingValue.get(k)) {
                    rating = i+1;
                    Log.d("tag", "cat egory array " + rating);
                }


        switch (rating){

            case 1:
                getSymptomsNode1(Ratingvalue,diagnosiscat);

                break;
            case 2:
                getSymptomsNode2(Ratingvalue,diagnosiscat);
                break;

            case 3:
                getSymptomsNode3(Ratingvalue,diagnosiscat);
                break;
            case 4:
                getSymptomsNode4(Ratingvalue,diagnosiscat);
                break;

        }

    }

    private void getSymptomsNode1(final String Ratingvalue, final int diagnosiscat) {
        reff = FirebaseDatabase.getInstance().getReference().child("HistorySymptoms");
        reff = reff.child("Symptom 1");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String symptom = dataSnapshot.child("Symptoms").getValue().toString();
                Log.d("tag", "category symptom " + symptom + Ratingvalue);
                getDiagnosis(symptom, Ratingvalue, diagnosiscat);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void getSymptomsNode2(final String Ratingvalue, final int diagnosiscat) {
        reff = FirebaseDatabase.getInstance().getReference().child("HistorySymptoms");
        reff = reff.child("Symptom 2");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String symptom = dataSnapshot.child("Symptoms").getValue().toString();
                Log.d("tag", "category symptom " + symptom + Ratingvalue);
                getDiagnosis(symptom, Ratingvalue, diagnosiscat);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void getSymptomsNode3(final String Ratingvalue, final int diagnosiscat) {
        reff = FirebaseDatabase.getInstance().getReference().child("HistorySymptoms");
        reff = reff.child("Symptom 3");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String symptom = dataSnapshot.child("Symptoms").getValue().toString();
                Log.d("tag", "category symptom " + symptom + Ratingvalue);
                getDiagnosis(symptom, Ratingvalue, diagnosiscat);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void getSymptomsNode4(final String Ratingvalue, final int diagnosiscat) {
        reff = FirebaseDatabase.getInstance().getReference().child("HistorySymptoms");
        reff = reff.child("Symptom 4");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String symptom = dataSnapshot.child("Symptoms").getValue().toString();
                Log.d("tag", "category symptom " + symptom + Ratingvalue);
                getDiagnosis(symptom, Ratingvalue, diagnosiscat);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



    private void getDiagnosis(String symptoms, String rating, int diagnosiscat) {
        reff = FirebaseDatabase.getInstance().getReference().child("Diagnosis");
        switch (diagnosiscat) {

            case 1:
                // retrieve the data from Cardiovascular node
                if(symptoms.equals("Chest pain") && rating.equals("HighestRated")){
                    reff = reff.child("HB");
                }
                else if (symptoms.equals("Shortness of Breath") && rating.equals("HighestRated")) {
                    reff = reff.child("Atrial Flutter");
                }
                else if (symptoms.equals("Fatigue") && rating.equals("HighestRated")) {
                    reff = reff.child("Atrial Fibrillation");
                }
                else {
                    reff = reff.child("Rest");
                }

                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String actitle = dataSnapshot.child("Title").getValue().toString();
                        String acoverview = dataSnapshot.child("Overview").getValue().toString();
                        String acsymptom = dataSnapshot.child("Symptom").getValue().toString();
                        String achowCommon = dataSnapshot.child("How Common").getValue().toString();
                        String acSymptom = dataSnapshot.child("Other Symptom").getValue().toString();
                        String actreatment = dataSnapshot.child("Treatment").getValue().toString();
                        txtOverview16.setText(acoverview);
                        txtTitle16.setText(actitle);
                        txtTypeSymptom14.setText(acsymptom);
                        txtHcommon10.setText(achowCommon);
                        txtSymptoms16.setText(acSymptom);
                        txtTreatment15.setText(actreatment);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });

                break;
            case 2:

                // retrieve the data from Neurological node
                if(symptoms.equals("Muscle weakness") && rating.equals("HighestRated")){
                    reff = reff.child("Motion Sickness");
                }
                else if (symptoms.equals("Paralysis") && rating.equals("HighestRated")) {
                    reff = reff.child("Paralysis");
                }
                else if (symptoms.equals("Slurred speech") && rating.equals("HighestRated")) {
                    reff = reff.child("Motion Sickness");
                }
                else {
                    reff = reff.child("Rest");
                }

                // retrieve the data from Neurological node
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String actitle = dataSnapshot.child("Title").getValue().toString();
                        String acoverview = dataSnapshot.child("Overview").getValue().toString();
                        String acsymptom = dataSnapshot.child("Symptom").getValue().toString();
                        String achowCommon = dataSnapshot.child("How Common").getValue().toString();
                        String acSymptom = dataSnapshot.child("Other Symptom").getValue().toString();
                        String actreatment = dataSnapshot.child("Treatment").getValue().toString();
                        txtOverview16.setText(acoverview);
                        txtTitle16.setText(actitle);
                        txtTypeSymptom14.setText(acsymptom);
                        txtHcommon10.setText(achowCommon);
                        txtSymptoms16.setText(acSymptom);
                        txtTreatment15.setText(actreatment);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });

                break;
            case 3:
                // retrieve the data from Respiratory node
                if(symptoms.equals("Difficulty breathing") && rating.equals("HighestRated")){
                    reff = reff.child("Coronavirus");
                }
                else if (symptoms.equals("Fever") && rating.equals("HighestRated")) {
                    reff = reff.child("Chronic Sinusitis");
                }
                else if (symptoms.equals("Couching") && rating.equals("HighestRated")) {
                    reff = reff.child("Bronchitis");
                }
                else if (symptoms.equals("Chest Pain") && rating.equals("HighestRated")){
                    reff = reff.child("Common Cold");
                }

                // retrieve the data from Cardiovascular node
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String actitle = dataSnapshot.child("Title").getValue().toString();
                        String acoverview = dataSnapshot.child("Overview").getValue().toString();
                        String acsymptom = dataSnapshot.child("Symptom").getValue().toString();
                        String achowCommon = dataSnapshot.child("How Common").getValue().toString();
                        String acSymptom = dataSnapshot.child("Other Symptom").getValue().toString();
                        String actreatment = dataSnapshot.child("Treatment").getValue().toString();
                        txtOverview16.setText(acoverview);
                        txtTitle16.setText(actitle);
                        txtTypeSymptom14.setText(acsymptom);
                        txtHcommon10.setText(achowCommon);
                        txtSymptoms16.setText(acSymptom);
                        txtTreatment15.setText(actreatment);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
                break;
            case 4:
                // retrieve the data from Digestive node
                if(symptoms.equals("Gas") && rating.equals("HighestRated")){
                    reff = reff.child("Gas");
                }
                else if (symptoms.equals("Diarrhea") && rating.equals("HighestRated")) {
                    reff = reff.child("Irritable Bowel Syndrome");
                }
                else if (symptoms.equals("Vomiting") && rating.equals("HighestRated")) {
                    reff = reff.child("Viral Gastroenteritis");
                }
                else {
                    reff = reff.child("Lactose Intolerance");
                }
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String actitle = dataSnapshot.child("Title").getValue().toString();
                        String acoverview = dataSnapshot.child("Overview").getValue().toString();
                        String acsymptom = dataSnapshot.child("Symptom").getValue().toString();
                        String achowCommon = dataSnapshot.child("How Common").getValue().toString();
                        String acSymptom = dataSnapshot.child("Other Symptom").getValue().toString();
                        String actreatment = dataSnapshot.child("Treatment").getValue().toString();
                        txtOverview16.setText(acoverview);
                        txtTitle16.setText(actitle);
                        txtTypeSymptom14.setText(acsymptom);
                        txtHcommon10.setText(achowCommon);
                        txtSymptoms16.setText(acSymptom);
                        txtTreatment15.setText(actreatment);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });

                break;
            case 5:
                // retrieve the data from Intergumentary node
                if(symptoms.equals("Fragile Skin") && rating.equals("HighestRated")){
                    reff = reff.child("Low Blood Sugar");
                }
                else if (symptoms.equals("Thickened Skin") && rating.equals("HighestRated")) {
                    reff = reff.child("Vitamin B12 Deficiency");
                }
                else if (symptoms.equals("Dental problem") && rating.equals("HighestRated")) {
                    reff = reff.child("Cold Sores");
                }
                else {
                    reff = reff.child("Drug Allergy");
                }
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String actitle = dataSnapshot.child("Title").getValue().toString();
                        String acoverview = dataSnapshot.child("Overview").getValue().toString();
                        String acsymptom = dataSnapshot.child("Symptom").getValue().toString();
                        String achowCommon = dataSnapshot.child("How Common").getValue().toString();
                        String acSymptom = dataSnapshot.child("Other Symptom").getValue().toString();
                        String actreatment = dataSnapshot.child("Treatment").getValue().toString();
                        txtOverview16.setText(acoverview);
                        txtTitle16.setText(actitle);
                        txtTypeSymptom14.setText(acsymptom);
                        txtHcommon10.setText(achowCommon);
                        txtSymptoms16.setText(acSymptom);
                        txtTreatment15.setText(actreatment);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });

                break;
        }
    }

}

