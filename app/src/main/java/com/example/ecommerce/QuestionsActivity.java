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

    private TextView question, questionCount;
    private Button option1, option2, option3,option4;
    private List<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        question =findViewById(R.id.Question);
        questionCount=findViewById(R.id.CurrentTextNUmber);

        option1 =findViewById(R.id.Option1);
        option2 =findViewById(R.id.Option2);
        option3 =findViewById(R.id.Option3);
        option4 =findViewById(R.id.Option4);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);
        
        getQuestionsList();
    }

    private void getQuestionsList()
    {
        questionList = new ArrayList<>();
        questionList.add(new Question("Question 1","A","B","C","D", 2));
        questionList.add(new Question("Question 2","C","A","B","D", 2));
        questionList.add(new Question("Question 3","D","A","C","B", 2));

        setQuestion();
    }

    private void setQuestion()
    {
        question.setText(questionList.get(0).getQuestion());
        option1.setText(questionList.get(0).getQuestion());
        option2.setText(questionList.get(0).getQuestion());
        option3.setText(questionList.get(0).getQuestion());
        option4.setText(questionList.get(0).getQuestion());

        questionCount.setText(String.valueOf(1) + "/" + String.valueOf(questionList.size()));

    }

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
                
            default:
        }
        
        rateSymptoms(selectedOption);
    }

    private void rateSymptoms(int selectedOption) {

        Intent intent = new Intent(QuestionsActivity.this, ratingActivity.class);
        startActivity(intent);
        QuestionsActivity.this.finish();
    }
}