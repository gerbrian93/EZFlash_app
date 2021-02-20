package com.example.ezflash;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MulitplyingActivity extends AppCompatActivity {

    private final String[] multiplyStuff = {"5x2", "6x4", "11x6", "8x4", "9x4", "12x3", "9x5", "9x9", "3x3", "7x3"};

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
        setContentView(R.layout.activity_mulitplying);
        showProblem = findViewById(R.id.show_problem3);
        showProblem.setText(multiplyStuff[problemCount]);


        answerA = (Button) findViewById(R.id.answerA);
        answerA.setOnClickListener(v -> {
            nextProblem();//dont touch
            checkbuttons(multiplyStuff);
            checkA(multiplyStuff, number);
        });
        answerB = (Button) findViewById(R.id.answerB);
        answerB.setOnClickListener(v -> {
            nextProblem();//dont touch
            checkbuttons(multiplyStuff);
            checkB(multiplyStuff, number2);
        });
        answerC = (Button) findViewById(R.id.answerC);
        answerC.setOnClickListener(v -> {
            nextProblem();//dont touch
            checkbuttons(multiplyStuff);
            checkC(multiplyStuff, number3);
        });
        answerD = (Button) findViewById(R.id.answerD);
        answerD.setOnClickListener(v -> {
            nextProblem();//dont touch
            checkbuttons(multiplyStuff);
            checkD(multiplyStuff, number4);
        });
        checkbuttons(multiplyStuff);
        System.out.println(isCorrect);

    }


    public void nextProblem() {//this method calls finish when the adding stuff array goes out of bounds
        problemCount++;
        try {
            showProblem.setText(multiplyStuff[problemCount]);

        } catch (ArrayIndexOutOfBoundsException e) {

            Toast toast = Toast.makeText(this, isCorrect + " out of 10 correct, Great job!", Toast.LENGTH_LONG);//before activity finishes,toast message displays
            toast.show();
            System.out.println(isCorrect);
            finish();
        }
    }


    @SuppressLint("SetTextI18n")
    public void checkbuttons(String[] addingStuff) {
        try {
            String[] split = addingStuff[problemCount].split("x");
            int num1 = Integer.parseInt(split[0]);
            int num2 = Integer.parseInt(split[1]);
            int product = num1 * num2;

            do {
                number = random.nextInt((81) + 1);
                number2 = random.nextInt((81) + 1);
                number3 = random.nextInt((81) + 1);
                number4 = random.nextInt((81) + 1);
            } while (number != product && number2 != product && number3 != product && number4 != product);

            if(number == number2 || number == number3 || number == number4) {
                checkbuttons(multiplyStuff);
            } else if (number2 == number3 || number2 == number4) {
                checkbuttons(multiplyStuff);
            } else if (number3 == number4) {
                checkbuttons(multiplyStuff);
            } else {

                answerA.setText(Integer.toString(number));
                answerB.setText(Integer.toString(number2));
                answerC.setText(Integer.toString(number3));
                answerD.setText(Integer.toString(number4));
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }


    }
    public void checkA(String[] multiplyStuff, int number) {
        try {
            String[] split = multiplyStuff[problemCount].split("x");
            int num1 = Integer.parseInt(split[0]);
            int num2 = Integer.parseInt(split[1]);
            int product = num1 * num2;

            if (product == number)
                isCorrect++;
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }

    public void checkB(String[] multiplyStuff, int number2) {
        try {
            String[] split = multiplyStuff[problemCount].split("x");
            int num1 = Integer.parseInt(split[0]);
            int num2 = Integer.parseInt(split[1]);
            int product = num1 * num2;

            if (product == number2)
                isCorrect++;
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }
    public void checkC(String[] multiplyStuff, int number3) {
        try {
            String[] split = multiplyStuff[problemCount].split("x");
            int num1 = Integer.parseInt(split[0]);
            int num2 = Integer.parseInt(split[1]);
            int product = num1 * num2;

            if (product == number3)
                isCorrect++;
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }
    public void checkD(String[] multiplyStuff, int number4) {
        try {
            String[] split = multiplyStuff[problemCount].split("x");
            int num1 = Integer.parseInt(split[0]);
            int num2 = Integer.parseInt(split[1]);
            int product = num1 * num2;

            if (product == number4)
                isCorrect++;
        } catch (ArrayIndexOutOfBoundsException e)  {

        }
    }






}