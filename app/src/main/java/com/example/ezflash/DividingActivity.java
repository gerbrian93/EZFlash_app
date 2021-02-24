package com.example.ezflash;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class DividingActivity extends AppCompatActivity {

    private final String[] divideStuff = {"20/2", "6/3", "36/6", "36/4", "12/4", "24/3", "108/2", "54/6", "3/3", "63/3"};

    private TextView showProblem;
    private int problemCount = 0;

    private Button answerA;
    private Button answerB;
    private Button answerC;
    private Button answerD;


    final Random random = new Random();
    int number;
    int number2;
    int number3;
    int number4;
    private int isCorrect = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dividing);
        showProblem = findViewById(R.id.show_problem4);
        showProblem.setText(divideStuff[problemCount]);


        answerA = (Button) findViewById(R.id.answerA);
        answerA.setOnClickListener(v -> {
            checkA(divideStuff, number);
            nextProblem();//dont touch
            checkbuttons(divideStuff);
        });

        answerB = (Button) findViewById(R.id.answerB);
        answerB.setOnClickListener(v -> {
            checkB(divideStuff, number2);
            nextProblem();//dont touch
            checkbuttons(divideStuff);
        });

        answerC = (Button) findViewById(R.id.answerC);
        answerC.setOnClickListener(v -> {
            checkC(divideStuff, number3);
            nextProblem();//dont touch
            checkbuttons(divideStuff);
        });

        answerD = (Button) findViewById(R.id.answerD);
        answerD.setOnClickListener(v -> {
            checkD(divideStuff, number4);
            nextProblem();//dont touch
            checkbuttons(divideStuff);
        });

        checkbuttons(divideStuff);
    }


    public void nextProblem() {//this method calls finish when the adding stuff array goes out of bounds
        problemCount++;
        try {
            showProblem.setText(divideStuff[problemCount]);

        } catch (ArrayIndexOutOfBoundsException e) {

            Toast toast = Toast.makeText(this, isCorrect + " out of 10 correct, Great job!", Toast.LENGTH_LONG);//before activity finishes,toast message displays
            toast.show();
            finish();
        }
    }


    public int value(String[] divideStuff) {
        try {
            String[] split = divideStuff[problemCount].split("/");
            int num1 = Integer.parseInt(split[0]);
            int num2 = Integer.parseInt(split[1]);
            return num1 / num2;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
    }

    @SuppressLint("SetTextI18n")
    public void checkbuttons(String[] divideStuff) {

            do {
                number = random.nextInt((54) + 1);
                number2 = random.nextInt((54) + 1);
                number3 = random.nextInt((54) + 1);
                number4 = random.nextInt((54) + 1);
            } while (number != value(divideStuff) && number2 != value(divideStuff) && number3 != value(divideStuff) && number4 != value(divideStuff));

            if(number == number2 || number == number3 || number == number4) {
                checkbuttons(divideStuff);
            } else if (number2 == number3 || number2 == number4) {
                checkbuttons(divideStuff);
            } else if (number3 == number4) {
                checkbuttons(divideStuff);
            } else {

                answerA.setText(Integer.toString(number));
                answerB.setText(Integer.toString(number2));
                answerC.setText(Integer.toString(number3));
                answerD.setText(Integer.toString(number4));
            }
    }

    public void checkA(String[] divideStuff, int number) {
        if (value(divideStuff) == number)
                isCorrect++;
    }

        public void checkB(String[] divideStuff, int number2) {
            if (value(divideStuff) == number2)
                    isCorrect++;
        }

            public void checkC(String[] divideStuff, int number3) {
                if (value(divideStuff) == number3)
                    isCorrect++;

            }
                public void checkD(String[] divideStuff, int number4) {
                    if (value(divideStuff) == number4)
                        isCorrect++;

                }


}