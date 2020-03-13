package com.artemis.guesspic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    int[] a = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.ee,R.drawable.f};
    Random ran = new Random();
    int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final int choice = ran.nextInt(a.length);

        CountDownTimer cdt = new CountDownTimer(15000, 1000) {
            public void onTick(long millisUntilFinished) {
                TextView textView = (TextView) findViewById(R.id.textViewCounter);
                textView.setText(millisUntilFinished / 1000 + "");
                ImageView imageView = (ImageView) findViewById(R.id.imageViewMain);
                int i = ran.nextInt(a.length);
                imageView.setImageResource(a[i]);
                if(i == choice){
                    counter++;
                }
            }

            public void onFinish() {
                TextView textView = (TextView) findViewById(R.id.textViewCounter);
                textView.setText("Done!");

                Intent goToResult = new Intent(getApplicationContext(),ResultActivity.class);
                goToResult.putExtra("counter",counter);
                goToResult.putExtra("choice",a[choice]);
                startActivity(goToResult);
            }
        }.start();
    }
}
