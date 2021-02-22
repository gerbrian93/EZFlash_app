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
            toast();
            checkA(subtractStuff, number);
            nextProblem();//dont touch
            checkbuttons(subtractStuff);

        });
        answerB = (Button) findViewById(R.id.answerB);
        answerB.setOnClickListener(v -> {
            toast();
            checkB(subtractStuff, number2);
            nextProblem();//dont touch
            checkbuttons(subtractStuff);

        });
        answerC = (Button) findViewById(R.id.answerC);
        answerC.setOnClickListener(v -> {
            toast();
            checkC(subtractStuff, number3);
            nextProblem();//dont touch
            checkbuttons(subtractStuff);

        });
        answerD = (Button) findViewById(R.id.answerD);
        answerD.setOnClickListener(v -> {
            toast();
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


            System.out.println(isCorrect);
            finish();
        }
    }


    @SuppressLint("SetTextI18n")
    public void checkbuttons(String[] subtractStuff) {
        try {
            String[] split = subtractStuff[problemCount].split("-");
            int num1 = Integer.parseInt(split[0]);
            int num2 = Integer.parseInt(split[1]);
            int diff = num1 - num2;

            do {
                number = random.nextInt((14) + 1);
                number2 = random.nextInt((14) + 1);
                number3 = random.nextInt((14) + 1);
                number4 = random.nextInt((14) + 1);
            } while (number != diff && number2 != diff && number3 != diff && number4 != diff);

            if(number == number2 || number == number3 || number == number4) {
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
        } catch (ArrayIndexOutOfBoundsException e) {

        }


    }
    public void checkA(String[] subtractStuff, int number) {
        try {
            String[] split = subtractStuff[problemCount].split("-");
            int num1 = Integer.parseInt(split[0]);
            int num2 = Integer.parseInt(split[1]);
            int total = num1 - num2;

            if (total == number)
                isCorrect++;
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }

    public void checkB(String[] subtractStuff, int number2) {
        try {
            String[] split = subtractStuff[problemCount].split("-");
            int num1 = Integer.parseInt(split[0]);
            int num2 = Integer.parseInt(split[1]);
            int total = num1 + num2;

            if (total == number2)
                isCorrect++;
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }
    public void checkC(String[] subtractStuff, int number3) {
        try {
            String[] split = subtractStuff[problemCount].split("-");
            int num1 = Integer.parseInt(split[0]);
            int num2 = Integer.parseInt(split[1]);
            int total = num1 + num2;

            if (total == number3)
                isCorrect++;
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }
    public void checkD(String[] subtractStuff, int number4) {
        try {
            String[] split = subtractStuff[problemCount].split("-");
            int num1 = Integer.parseInt(split[0]);
            int num2 = Integer.parseInt(split[1]);
            int total = num1 + num2;

            if (total == number4)
                isCorrect++;
        } catch (ArrayIndexOutOfBoundsException e)  {

        }
    }

    public void toast() {
        if (problemCount > 0) {
            Toast toast = Toast.makeText(this, isCorrect + " out of 10 correct, Great job!", Toast.LENGTH_SHORT);//before activity finishes,toast message displays
            toast.show();
        }
    }





}