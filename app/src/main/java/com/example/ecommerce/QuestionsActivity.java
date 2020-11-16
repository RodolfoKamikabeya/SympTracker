package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuestionsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView question;
    private Button option1, option2, option3,option4;
    private List<Question> questionList;



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
        questionList = new ArrayList<>();
        switch (categoryNum) {

            case 1:
                questionList.add(new Question("Cardiovascular","Chest pain","Shortness of Breath","Fatigue","Dizziness"));
                break;
            case 2:
                questionList.add(new Question("Neurological","Muscle weakness","Paralysis","Slurred speech","Blurry Vision"));
                break;
            case 3:
                questionList.add(new Question("Respiratory","Difficulty Breathing","Fever","Couching","Chest Pain"));
                break;
            case 4:
                questionList.add(new Question("Digestive","Gas","Diarrhea","Vomiting","Abdominal Pain"));
                break;
            case 5:
                questionList.add(new Question("Intergumentary","Fragile Skin","Thickened skin","Dental problems","Difficulty swallowing"));
                break;

            }

            setQuestion();
        }

    // Return the question data and populate our layout
    private void setQuestion()
        {
        question.setText(questionList.get(0).getQuestion());
        option1.setText(questionList.get(0).getOptionA());
        option2.setText(questionList.get(0).getOptionB());
        option3.setText(questionList.get(0).getOptionC());
        option4.setText(questionList.get(0).getOptionD());

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