package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FeelingbActivity extends AppCompatActivity {

    RadioGroup FBradioGroup;
    RadioButton FBradioButton;
    Button FBbuttonApply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeling_better);

        //set the radio buttons and the apply button
        FBradioGroup = findViewById(R.id.FBradioGroup);
        FBbuttonApply = findViewById(R.id.Feeling_applyButton);

        // click on Apply button, check with option was selected(yes/no)
        FBbuttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int FBradioId = FBradioGroup.getCheckedRadioButtonId();
                FBradioButton = findViewById(FBradioId);

                //switch cases to move to Thank you or Call a doctor screen
                switch (FBradioId){
                    case R.id.feeling_radio_one:
                        Intent intent = new Intent(FeelingbActivity.this, ThankyouActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.feeling_radio_two:
                        Intent intent2 = new Intent(FeelingbActivity.this, CalldocActivity.class);
                        startActivity(intent2);
                        break;
                }
            }
        });
    }
    //Populate the data with the checked button
    public void FBcheckbutton (View v){
        int FBradioId = FBradioGroup.getCheckedRadioButtonId();
        FBradioButton = findViewById(FBradioId);
    }
}

