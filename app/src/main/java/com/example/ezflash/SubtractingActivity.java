package com.example.ezflash;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class SubtractingActivity extends AppCompatActivity {
    private final String[] subtractStuff = {"5-2", "6-4", "11-6", "8-4", "9-4", "12-3", "14-5", "15-9", "3-3", "7-1"};

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
        setContentView(R.layout.activity_subtracting);
        showProblem = findViewById(R.id.show_problem);
        showProblem.setText(subtractStuff[problemCount]);


        answerA = (Button) findViewById(R.id.answerA);
        answerA.setOnClickListener(v -> {
            checkA(subtractStuff, number);
            nextProblem();//dont touch
            checkbuttons(subtractStuff);
        });

        answerB = (Button) findViewById(R.id.answerB);
        answerB.setOnClickListener(v -> {
            checkB(subtractStuff, number2);
            nextProblem();//dont touch
            checkbuttons(subtractStuff);
        });

        answerC = (Button) findViewById(R.id.answerC);
        answerC.setOnClickListener(v -> {
            checkC(subtractStuff, number3);
            nextProblem();//dont touch
            checkbuttons(subtractStuff);
        });

        answerD = (Button) findViewById(R.id.answerD);
        answerD.setOnClickListener(v -> {
            checkD(subtractStuff, number4);
            nextProblem();//dont touch
            checkbuttons(subtractStuff);
        });

        checkbuttons(subtractStuff);
    }


    public void nextProblem() {//this method calls finish when the adding stuff array goes out of bounds
        problemCount++;
        try {
            showProblem.setText(subtractStuff[problemCount]);

        } catch (ArrayIndexOutOfBoundsException e) {

            Toast toast = Toast.makeText(this, isCorrect + " out of 10 correct, Great job!", Toast.LENGTH_SHORT);//before activity finishes,toast message displaystoast.show();
            toast.show();
            finish();
        }
    }

    public int value(String[] subtractStuff) {
        try {
            String[] split = subtractStuff[problemCount].split("-");
            int num1 = Integer.parseInt(split[0]);
            int num2 = Integer.parseInt(split[1]);
            return num1 - num2;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
    }

    @SuppressLint("SetTextI18n")
    public void checkbuttons(String[] subtractStuff) {

            do {
                number = random.nextInt((14) + 1);
                number2 = random.nextInt((14) + 1);
                number3 = random.nextInt((14) + 1);
                number4 = random.nextInt((14) + 1);
            } while (number != value(subtractStuff) && number2 != value(subtractStuff) && number3 != value(subtractStuff) && number4 != value(subtractStuff));

            if (number == number2 || number == number3 || number == number4) {
                checkbuttons(subtractStuff);
            } else if (number2 == number3 || number2 == number4) {
                checkbuttons(subtractStuff);
            } else if (number3 == number4) {
                checkbuttons(subtractStuff);
            } else {

                answerA.setText(Integer.toString(number));
                answerB.setText(Integer.toString(number2));
                answerC.setText(Integer.toString(number3));
                answerD.setText(Integer.toString(number4));
            }
    }

    public void checkA(String[] subtractStuff, int number) {
        if (value(subtractStuff) == number)
                isCorrect++;
    }

        public void checkB(String[] subtractStuff, int number2) {
            if (value(subtractStuff) == number2)
                    isCorrect++;
        }

            public void checkC(String[] subtractStuff, int number3) {
                if (value(subtractStuff) == number3)
                        isCorrect++;
            }

                public void checkD(String[] subtractStuff, int number4) {
                    if (value(subtractStuff) == number4)
                            isCorrect++;
                }


    }
