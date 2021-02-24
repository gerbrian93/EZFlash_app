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


        answerA = findViewById(R.id.answerA);
        answerA.setOnClickListener(v -> {
            checkA(multiplyStuff, number);
            nextProblem();//dont touch
            checkbuttons(multiplyStuff);

        });
        answerB = findViewById(R.id.answerB);
        answerB.setOnClickListener(v -> {
            checkB(multiplyStuff, number2);
            nextProblem();//dont touch
            checkbuttons(multiplyStuff);

        });
        answerC = findViewById(R.id.answerC);
        answerC.setOnClickListener(v -> {
            checkC(multiplyStuff, number3);
            nextProblem();//dont touch
            checkbuttons(multiplyStuff);

        });
        answerD = findViewById(R.id.answerD);
        answerD.setOnClickListener(v -> {
            checkD(multiplyStuff, number4);
            nextProblem();//dont touch
            checkbuttons(multiplyStuff);

        });
        checkbuttons(multiplyStuff);
    }


    public void nextProblem() {//this method calls finish when the adding stuff array goes out of bounds
        problemCount++;
        try {
            showProblem.setText(multiplyStuff[problemCount]);

        } catch (ArrayIndexOutOfBoundsException e) {
            Toast toast = Toast.makeText(this, isCorrect + " out of 10 correct, Great job!", Toast.LENGTH_SHORT);//before activity finishes,toast message displaystoast.show();
            toast.show();
            finish();
        }
    }
public int value(String[] multiplyStuff) {
   try {
       String[] split = multiplyStuff[problemCount].split("x");
       int num1 = Integer.parseInt(split[0]);
       int num2 = Integer.parseInt(split[1]);
       return num1 * num2;
   } catch (ArrayIndexOutOfBoundsException e) {
       return 0;
   }
}

    @SuppressLint("SetTextI18n")
    public void checkbuttons(String[] multiplyStuff) {


        do {
                number = random.nextInt((81) + 1);
                number2 = random.nextInt((81) + 1);
                number3 = random.nextInt((81) + 1);
                number4 = random.nextInt((81) + 1);
            } while (number != value(multiplyStuff) && number2 != value(multiplyStuff) && number3 != value(multiplyStuff) && number4 != value(multiplyStuff));

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


    }
    public void checkA(String[]multiplyStuff, int number) {
            if (number == value(multiplyStuff))
                isCorrect++;
    }

    public void checkB(String[] multiplyStuff, int number2) {
            if (number2 == value(multiplyStuff))
                isCorrect++;
    }
    public void checkC(String[] multiplyStuff, int number3) {
            if (number3 == value(multiplyStuff))
                isCorrect++;
    }
    public void checkD(String[] multiplyStuff, int number4) {
            if (number4 == value(multiplyStuff))
                isCorrect++;
         }







}