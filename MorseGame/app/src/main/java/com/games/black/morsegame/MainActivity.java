package com.games.black.morsegame;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    MorseCode morseCode=new MorseCode();
    String currentLetter;
    Integer score;
    Integer highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = 0;
        final SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        highScore = sharedPreferences.getInt("highScore", 0);// zero default value to return if the key isn't present
        final TextView textViewHighScore = (TextView)findViewById(R.id.textViewHighScore);
        textViewHighScore.setText("High score: "+highScore);


        final HashMap morse = morseCode.getMorseCharacters();

        Button buttonRandom = (Button) findViewById(R.id.buttonRandom);
        buttonRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object[] letters = morse.keySet().toArray();
                Object key = letters[new Random().nextInt(letters.length)];
                String randomLetter = key.toString();
                currentLetter=randomLetter;

                TextView textViewLetter = (TextView)findViewById(R.id.textViewLetter);
                textViewLetter.setText(randomLetter);
            }
        });

        Button buttonEnter = (Button) findViewById(R.id.buttonEnter);
        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText)findViewById(R.id.editTextMorse);
                String userInput = editText.getText().toString();

                TextView textViewResponse = (TextView)findViewById(R.id.textViewResponse);
                String correctAnswer = (String) morse.get(currentLetter);
                if(userInput.equals(correctAnswer) ){
                    textViewResponse.setText("Correct");
                    score = score+10;
                    TextView textViewScore = (TextView)findViewById(R.id.textViewScore);
                    textViewScore.setText("Score: "+score);

                    if(score>highScore){
                        highScore=score;
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("highScore", highScore);
                        editor.commit();

                        textViewHighScore.setText("High score: "+highScore);
                    }
                }
                else {
                    textViewResponse.setText("Wrong, the correct answer was "+correctAnswer);
                    score=0;
                }

                InputMethodManager inputManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });
    }
}
