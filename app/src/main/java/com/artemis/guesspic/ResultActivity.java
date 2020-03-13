package com.artemis.guesspic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        final int choice = getIntent().getExtras().getInt("choice");
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(choice);

        final Button buttonResult = (Button) findViewById(R.id.buttonResult);
        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextGuess = (EditText) findViewById(R.id.editTextGuess);
                int userGuess = Integer.parseInt(editTextGuess.getText().toString());
                int counter = getIntent().getExtras().getInt("counter");
                TextView textViewResult = (TextView) findViewById(R.id.textViewResult);
                if(userGuess == counter){
                    textViewResult.setText("Success");
                    buttonResult.setEnabled(false);
                }
                else{
                    textViewResult.setText("Wrong!");
                }
            }
        });
    }
}
