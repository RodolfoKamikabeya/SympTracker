package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FollowupActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    private Button buttonapply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followup);

        //set the radio buttons and the apply button
        radioGroup = findViewById(R.id.radiogroup);
        buttonapply = findViewById(R.id.Followup_applyButton);

        // click on Apply button, check with option was selected(yes/no)
        buttonapply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);

                //switch cases to move to Thank you or Call a doctor screen
                switch (radioId){
                    case R.id.radio_one:
                        Intent intent = new Intent(FollowupActivity.this, FeelingbActivity.class);
                        startActivity(intent);

                        break;

                    case R.id.radio_two:
                        Intent intent2 = new Intent(FollowupActivity.this, HomeActivity.class);
                        startActivity(intent2);
                        FollowupActivity.this.finish();
                        break;
                }

            }
        });
    }

    //Verify the checked option and return the true value (Yes / No)
    public void checkButton(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

    }
}