package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class HomeActivity extends AppCompatActivity {

    private ImageView heartIcon, CardiovascularButton;
    private ImageView neuroIcon, NeurologicalButton;
    private ImageView respIcon, RespiratoryButton;
    private ImageView digestIcon, DigestoryButton;
    private ImageView integumIcon, IntegumentaryButton;

    private RelativeLayout layout;

    private ConstraintSet constraintSetNew = new ConstraintSet();
    private boolean altLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        heartIcon = (ImageView) findViewById(R.id.heart);
        CardiovascularButton = (ImageView) findViewById(R.id.CardiovascularImg);

        neuroIcon = (ImageView) findViewById(R.id.neuro);
        NeurologicalButton = (ImageView) findViewById(R.id.NeurologicalImg);

        respIcon = (ImageView) findViewById(R.id.resp);
        RespiratoryButton = (ImageView) findViewById(R.id.RespiratoryImg);

        digestIcon = (ImageView) findViewById(R.id.digest);
        DigestoryButton = (ImageView) findViewById(R.id.DigestiveImg);

        integumIcon = (ImageView) findViewById(R.id.Integum);
        IntegumentaryButton = (ImageView) findViewById(R.id.IntegumentaryImg);

        layout = findViewById(R.id.categorylayout);
        constraintSetNew.clone(this,R.layout.heartdetails);

        heartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DetailsActivity.class);
                startActivity(intent);

            }
        });

        CardiovascularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, QuestionsActivity.class);
                startActivity(intent);
            }
        });


    }


}