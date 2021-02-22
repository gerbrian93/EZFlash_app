package com.example.ezflash;
/*
This activity successfully runs through the problems presented in the array, with a use of a single
variable it goes through all 10 problems upon user selection and presents a toast message upon
finishing when the index of the addingStuff array goes out of bounds.
tasks:
-create counter to show user what number out of 10 problems they're on.
-introduce variability with buttons and problem sets
 */
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
        Toast toast = Toast.makeText(this, isCorrect + " out of 10 correct, Great job!", Toast.LENGTH_LONG);//before activity finishes,toast message displays
        try {
            showProblem.setText(addingStuff[problemCount]);

        } catch (ArrayIndexOutOfBoundsException a) {

            toast.show();
            System.out.println("0");

            finish();
        }
        }


    @SuppressLint("SetTextI18n")
    public void checkbuttons(String[] addingStuff) {
        try {
            String[] split = addingStuff[problemCount].split("\\+");
            int num1 = Integer.parseInt(split[0]);
            int num2 = Integer.parseInt(split[1]);
            int total = num1 + num2;

            do {
                number = random.nextInt((14) + 1);
                number2 = random.nextInt((14) + 1);
                number3 = random.nextInt((14) + 1);
                number4 = random.nextInt((14) + 1);
            } while (number != total && number2 != total && number3 != total && number4 != total);

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
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("1");
        }


    }
    public void checkA(String[] addingStuff, int number) {
      try {
          String[] split = addingStuff[problemCount].split("\\+");
          int num1 = Integer.parseInt(split[0]);
          int num2 = Integer.parseInt(split[1]);
          int total = num1 + num2;

          if (total == number)
              isCorrect++;
      } catch (ArrayIndexOutOfBoundsException e) {
          System.out.println("2");
      }
    }

         public void checkB(String[] addingStuff, int number2) {
           try {
               String[] split = addingStuff[problemCount].split("\\+");
               int num1 = Integer.parseInt(split[0]);
               int num2 = Integer.parseInt(split[1]);
               int total = num1 + num2;

               if (total == number2)
                   isCorrect++;
           } catch (ArrayIndexOutOfBoundsException e) {
               System.out.println("3");
           }
        }
                public void checkC(String[] addingStuff, int number3) {
                   try {
                       String[] split = addingStuff[problemCount].split("\\+");
                       int num1 = Integer.parseInt(split[0]);
                       int num2 = Integer.parseInt(split[1]);
                       int total = num1 + num2;

                       if (total == number3)
                           isCorrect++;
                   } catch (ArrayIndexOutOfBoundsException e) {
                       System.out.println("4");
                   }
                }
                        public void checkD(String[] addingStuff, int number4) {
                           try {
                               String[] split = addingStuff[problemCount].split("\\+");
                               int num1 = Integer.parseInt(split[0]);
                               int num2 = Integer.parseInt(split[1]);
                               int total = num1 + num2;

                               if (total == number4)
                                   isCorrect++;
                           } catch (ArrayIndexOutOfBoundsException e)  {
                                    System.out.println("5");
                           }
                        }






}
