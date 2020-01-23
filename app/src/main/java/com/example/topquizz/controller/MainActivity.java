package com.example.topquizz.controller;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.topquizz.R;
import com.example.topquizz.model.User;

public class MainActivity extends Activity {

    private TextView mGreetingText;
    private EditText mNameInput;
    private Button mPlayButton;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUser= new User();
        mGreetingText = (TextView)findViewById(R.id.activity_main_greeting_txt);
        mNameInput = (EditText)findViewById(R.id.activity_main_name_input);
        mPlayButton = findViewById(R.id.activity_main_play_btn);
        mPlayButton.setEnabled(false);

        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayButton.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = mNameInput.getText().toString();
                mUser.setFirstName(firstname);
                Intent choiceTheme = new Intent(MainActivity.this, ChoiceTheme.class);
                startActivity(choiceTheme);
            }
        });
    }


}
