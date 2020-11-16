package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int position = 0;
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null){
            position = extras.getInt("position");}

        switch  (position) {

                case 1 :
                    setContentView(R.layout.heartdetails);
                    break;
                case 2:
                    setContentView(R.layout.neurodetails);
                    break;
                case 3 :
                    setContentView(R.layout.respdetails);
                    break;
                case 4:
                    setContentView(R.layout.digestivedetails);
                    break;
                case 5 :
                    setContentView(R.layout.intergumentarydetails);
                    break;
                default:
                    setContentView(R.layout.activity_home);
                    break;

                }

    }
}