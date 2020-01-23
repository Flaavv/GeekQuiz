package com.example.topquizz.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.topquizz.R;

public class ChoiceTheme extends Activity implements View.OnClickListener {




    private Button mChoiceButton1;
    private Button mChoiceButton2;
    private Button mChoiceButton3;
    private Button mChoiceButton4;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        Button btMap= findViewById(R.id.btnJava);
        btMap.setOnClickListener(new View.OnClickListener(){

            @Override
    public void onClick(View v) {
                startActivity(new Intent(ChoiceTheme.this, JavaQuestion.class));
    }
            });
    }

    @Override
    public void onClick(View v) {

    }
}