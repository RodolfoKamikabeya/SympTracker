package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CalldocActivity extends AppCompatActivity {

    private Button call_docButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_doc);
        call_docButton = findViewById(R.id.Call_Button);

        // OK button transfer to Login (Quit the app)
        call_docButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalldocActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}