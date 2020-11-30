package com.example.ecommerce;

public class Question {

    String question;
    String optionA, optionB, OptionC, OptionD;
    int category;

    public Question(String question, String optionA, String optionB, String optionC, String optionD) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.OptionC = optionC;
        this.OptionD = optionD;
    }

    public String getQuestion() {
        return question;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return OptionC;
    }

    public String getOptionD() {
        return OptionD;
    }

    public int getCategory() {
        return category;
    }


}
