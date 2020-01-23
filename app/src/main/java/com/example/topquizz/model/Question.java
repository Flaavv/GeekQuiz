package com.example.topquizz.model;

import java.util.List;

public class Question {
    private String mQuestion;
    private List<String> mChoiceList;
    private int mAnswerIndex;


    public Question(String question, List<String> choiceList, int answerIndex) {
        this.setQuestion(question);
        this.setChoiceList(choiceList);
        this.setAnswerIndex(answerIndex);
    }

    public String getQuestion() {

        return mQuestion;
    }

    public void setQuestion(String question) {
        this.mQuestion = question;
    }


    public List<String> getChoiceList() {
        return mChoiceList;
    }

    public void setChoiceList(List<String> choiceList) {
        this.mChoiceList = choiceList;

    }



    public int getAnswerIndex() {
        return mAnswerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        this.mAnswerIndex = answerIndex;
    }


}
