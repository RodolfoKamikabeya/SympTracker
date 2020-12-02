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
        Log.d("tag","category Diag " + category);
        Log.d("tag","category PQ " + diagnosiscat);

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


        reff = FirebaseDatabase.getInstance().getReference().child("Diagnosis");
        switch (diagnosiscat) {

            case 1:
                // retrieve the data from Cardiovascular node
                reff = reff.child("HB");
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
                // retrieve the data from Cardiovascular node
                reff = reff.child("Acute Sinusitis");
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
                // retrieve the data from Cardiovascular node
                reff = reff.child("Coronavirus");
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
                // retrieve the data from Cardiovascular node
                reff = reff.child("Gas");
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
                // retrieve the data from Cardiovascular node
                reff = reff.child("Cold Sores");
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