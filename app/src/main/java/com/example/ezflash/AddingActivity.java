package com.example.ezflash;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class AddingActivity extends AppCompatActivity {
    private final String[] addingStuff = {"4+4", "3+6", "5+7", "2+3", "9+4", "8+6", "1+2", "7+5", "3+3", "3+7"};

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
        setContentView(R.layout.activity_adding);
        showProblem = findViewById(R.id.show_problem);
        showProblem.setText(addingStuff[problemCount]);


         answerA = findViewById(R.id.answerA);
        answerA.setOnClickListener(v -> {
            checkA(addingStuff, number);
            nextProblem();//dont touch
            checkbuttons(addingStuff);
        });
         answerB = findViewById(R.id.answerB);
        answerB.setOnClickListener(v -> {
            checkB(addingStuff, number2);
            nextProblem();//dont touch
            checkbuttons(addingStuff);
        });
         answerC = findViewById(R.id.answerC);
        answerC.setOnClickListener(v -> {
            checkC(addingStuff, number3);
            nextProblem();//dont touch
            checkbuttons(addingStuff);
        });
         answerD = findViewById(R.id.answerD);
        answerD.setOnClickListener(v -> {
            checkD(addingStuff, number4);
            nextProblem();//dont touch
            checkbuttons(addingStuff);

        });
        checkbuttons(addingStuff);


    }


    public void nextProblem() {//this method calls finish when the adding stuff array goes out of bounds
        problemCount++;

        try {
            showProblem.setText(addingStuff[problemCount]);

        } catch (ArrayIndexOutOfBoundsException a) {


            System.out.println("0");

            finish();
        }
        }



    public int value(String[] addingStuff) {
        try {
            String[] split = addingStuff[problemCount].split("\\+");
            int num1 = Integer.parseInt(split[0]);
            int num2 = Integer.parseInt(split[1]);
            return num1 + num2;
        } catch (ArrayIndexOutOfBoundsException e) {
            Toast toast = Toast.makeText(this, isCorrect + " out of 10 correct, Great job!", Toast.LENGTH_SHORT);//before activity finishes,toast message displaystoast.show();
            toast.show();
            return 0;
        }
    }

    @SuppressLint("SetTextI18n")
    public void checkbuttons(String[] addingStuff) {

            do {
                number = random.nextInt((14) + 1);
                number2 = random.nextInt((14) + 1);
                number3 = random.nextInt((14) + 1);
                number4 = random.nextInt((14) + 1);
            } while (number != value(addingStuff) && number2 != value(addingStuff) && number3 != value(addingStuff) && number4 != value(addingStuff));

            if(number == number2 || number == number3 || number == number4) {
                checkbuttons(addingStuff);
            } else if (number2 == number3 || number2 == number4) {
                checkbuttons(addingStuff);
            } else if (number3 == number4) {
                checkbuttons(addingStuff);
            } else {

                answerA.setText(Integer.toString(number));
                answerB.setText(Integer.toString(number2));
                answerC.setText(Integer.toString(number3));
                answerD.setText(Integer.toString(number4));
            }
    }

    public void checkA(String[] addingStuff, int number) {
        if (value(addingStuff) == number)
              isCorrect++;
    }
         public void checkB(String[] addingStuff, int number2) {
            if (value(addingStuff) == number2)
                   isCorrect++;
         }
                public void checkC(String[] addingStuff, int number3) {
                    if (value(addingStuff) == number3)
                           isCorrect++;
                }
                        public void checkD(String[] addingStuff, int number4) {
                            if (value(addingStuff) == number4)
                                   isCorrect++;
                        }






}
