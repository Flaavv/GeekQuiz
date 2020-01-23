package com.example.topquizz.controller;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.topquizz.R;
import com.example.topquizz.model.Question;
import com.example.topquizz.model.QuestionBank;

import java.util.Arrays;

public class JavaQuestion extends Activity implements View.OnClickListener{
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
        setContentView(R.layout.activity_java);
        //System.out.println("GameActivity::onCreate()");

        mQuestionBank = this.generateQuestions();
        int mScore = 0;
        numberOfQuestions = 5;


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
    public void onClick(View v) {
        int responseIndex = (int) v.getTag();

        if (responseIndex == mCurrentQuestion.getAnswerIndex()) {
            //bonne réponse
            mScore++;


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

        if(mScore<2||mScore==2) {
            builder.setTitle("C'est déjà fini ! Voyons ton score...");
            builder.setMessage("Va falloir réviser..! Tu as seulement " + mScore + " point(s)");
        }else if(mScore>2 && mScore==5){
            builder.setTitle("C'est déjà fini ! Voyons ton score...");
            builder.setMessage("Super! Tu as obtenu " + mScore + " points");

                }

                builder.setPositiveButton("Tu veux retenter?", new DialogInterface.OnClickListener() {
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
                Arrays.asList("Write once, run everywhere", "Write once, and be a billionaire", "Please, never learn it",
                        "shut the fuck up and gimme your money"),
                0);

        Question question2 = new Question("Pour transformer un code lisible en code compréhensible par la machine, on utilise :",
                Arrays.asList("Un transformateur", "Un traducteur", "Un compilateur", "Un traducteur"),
                2);

        Question question3= new Question ("Pour avoir un commentaire sur une ligne, on place en début de ligne le(s) caractère(s) :",
                Arrays.asList("#", "//", "<--!  -->", "!--"), 1);

        Question question4 = new Question("Lequel n'a pas sa place parmi ces choix :",
                Arrays.asList("instanceof", "select", "for", "volatile"),
                3);


        Question question5 = new Question("Lequel de ces identificateurs est incorrect :",
                Arrays.asList("ToTal", "nom_prenom", "2echoix", "valeur$"),
                2);

        Question question6 = new Question("De quel type primitif est le littéral 25.5F ?",
                Arrays.asList("double", "float", "long", "int"),
                1);

        Question question7 = new Question("Pour déclarer une variable de type primitif int qui a pour nom jour, il faut écrire :",
                Arrays.asList("int jour;", "declare(type int) : jour;", "dim jour as integer;", "jour = new int;"),
                0);

        Question question8 = new Question("Pour spécifier que la valeur d'une variable ne peut changer, on la déclare comme une constante avec le mot réservé :",
                Arrays.asList("var", "final", "const", "$var"),
                2);

        Question question9 = new Question("Trouvez la ligne incorrecte :",
                Arrays.asList("int somme = 15;", "int somme=15;", "i nt somme = 1 5 ;", "new int somme = 15;"),
                2);

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