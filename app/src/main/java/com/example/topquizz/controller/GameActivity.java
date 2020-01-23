package com.example.topquizz.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.topquizz.R;
import com.example.topquizz.model.Question;
import com.example.topquizz.model.QuestionBank;
import java.util.Collections;

import java.util.Arrays;
import java.util.List;
public class GameActivity extends AppCompatActivity  implements View.OnClickListener {

    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;
    private int mScore;
    private int numberOfQuestions;

    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";




        private TextView mQuestionTextView;
        private Button mAnswerButton1;
        private Button mAnswerButton2;
        private Button mAnswerButton3;
        private Button mAnswerButton4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //System.out.println("GameActivity::onCreate()");

        mQuestionBank=this.generateQuestions();
        int mScore = 0;
        numberOfQuestions = 4;


        //Widgets
        mQuestionTextView = (TextView) findViewById(R.id.activity_game_question_text);
        mAnswerButton1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        mAnswerButton2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        mAnswerButton3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        mAnswerButton4 = (Button) findViewById(R.id.activity_game_answer4_btn);

        //assignation bouton à un tag
        mAnswerButton1.setTag(0);
        mAnswerButton2.setTag(1);
        mAnswerButton3.setTag(2);
        mAnswerButton4.setTag(3);

        //enregistrer activité courante pour que OnClick soit enregistrée,this = activité courante

        mAnswerButton1.setOnClickListener(this);
        mAnswerButton2.setOnClickListener(this);
        mAnswerButton3.setOnClickListener(this);
        mAnswerButton4.setOnClickListener(this);


        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);



    }

        @Override
        public void onClick (View v){
        int responseIndex = (int) v.getTag();

        if (responseIndex == mCurrentQuestion.getAnswerIndex()) {
            //bonne réponse

            Toast.makeText(this, "ouais..bien", Toast.LENGTH_SHORT).show();
            mScore++;


        } else {
            //mauvaise réponse
            Toast.makeText(this, "T'es mauvais!", Toast.LENGTH_SHORT).show();


        }
        if (--numberOfQuestions == 0) {
            //fin du jeu
            endGame();
        } else {
            mCurrentQuestion = mQuestionBank.getQuestion();
            displayQuestion(mCurrentQuestion);
        }

    }


        private void endGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("T'as joué comme une merde")
                .setMessage("Ton score c'est " +mScore+"pts")
                .setPositiveButton("Ciao fdp", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //fin
                        Intent intent = new Intent();
                        intent.putExtra(BUNDLE_EXTRA_SCORE, mScore);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                })
                .setCancelable(false)
                .create()
                .show();
    }


    private void displayQuestion(final Question question) {
        mQuestionTextView.setText(question.getQuestion());
        mAnswerButton1.setText(question.getChoiceList().get(0));
        mAnswerButton2.setText(question.getChoiceList().get(1));
        mAnswerButton3.setText(question.getChoiceList().get(2));
        mAnswerButton4.setText(question.getChoiceList().get(3));

    }

    private QuestionBank generateQuestions() {

        Question question1 = new Question("Quelle est la devise de Java?",
                Arrays.asList("Write once, run everywhere", "Write once, and be a billionaire", "pooping on your mom's shoes is bad",
                        "shut the fuck up and gimme your money"),
                0);

        Question question2 = new Question("A quel putain de rital Zidane a t-il mis un coup de tête?",
                Arrays.asList("Mozzarella", "Matuffachiste", "Spaghettiti", "Materrazzi"),
                3);

        Question question3= new Question ("Quel est l'ingrédient principal de la sauce tomate?",
                Arrays.asList("Le poisson", "La tomate", "Les fraises", "Du koala farci"), 1);

        Question question4 = new Question("Quelle est la durée du plus long pet?",
                Arrays.asList("32sec", "16sec", "1min2", "31min17"),
                3);


        Question question5 = new Question("De quelle nationalité est la majorité des putes de Toulouse?",
                Arrays.asList("Roumaine", "Africaine", "Espagnole", "C koi une pute?"),
                0);

        Question question6 = new Question("Complétez cette phrase: De Vinci est à l'orticulture ce que...",
                Arrays.asList("Le fromage est au ciel", "Les doigts sont à la langue", "Johnny est à la Vittel", "La tasse est à l'oreiller"),
                1);

        Question question7 = new Question("Dans quelle ville y a t-il le plus de Kevin?",
                Arrays.asList("Strasbourg", "Calais", "Paris", "Lille"),
                2);

        Question question8 = new Question("De quelle couleur était le slip préféré de Louis XIII?",
                Arrays.asList("rose fushia", "tagueule", "rose fushia", "ftg fdp"),
                3);

        Question question9 = new Question("What is the phone number of Barack Obama?",
                Arrays.asList("42", "101", "666", "742"),
                3);

        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3,
                question4,
                question5,
                question6,
                question7,
                question8,
                question9));
    }



}
