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

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;





public class AddingActivity extends AppCompatActivity {
    private String[] addingStuff = {"4+4","3+6","5+7","2+3","9+4","8+6","1+2","7+5","3+3","3+7"};
    private String[] answers ={"8","8","11","4","11","13","3","10","6","8"};
    private String[] answers2 = {"1","2","3","5","5","6","7","8","9","11"};
    private String[] answers3 = {"9","9","7","6","13","14","5","2","1","9"};
    private String[] answers4 = {"6","3","12","2","10","6","2","12","5","10"};
    private TextView showProblem;
    private int problemCount = 0;
    private Button answerA;
    private Button answerB;
    private Button answerC;
    private Button answerD;
    private int isCorrect = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);

        showProblem = findViewById(R.id.show_problem);
        showProblem.setText(addingStuff[problemCount]);


        answerA = (Button)findViewById(R.id.answerA);
        answerA.setText(answers[problemCount]);
        answerA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkA(addingStuff, answers);
                nextProblem();
                buttonChange();
            }
        });
        answerB = (Button)findViewById(R.id.answerB);
        answerB.setText(answers2[problemCount]);
        answerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkB(addingStuff, answers2);
                nextProblem();
                buttonChange();
            }
        });
        answerC = (Button)findViewById(R.id.answerC);
        answerC.setText(answers3[problemCount]);
        answerC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkC(addingStuff, answers3);
                nextProblem();
                buttonChange();
            }
        });
        answerD = (Button)findViewById(R.id.answerD);
        answerD.setText(answers4[problemCount]);
        answerD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkD(addingStuff, answers4);
                nextProblem();
                buttonChange();
            }
        });
    }


    public void nextProblem() {//this method calls finish when the adding stuff array goes out of bounds
        problemCount++;
        try {
            showProblem.setText(addingStuff[problemCount]);
        } catch (ArrayIndexOutOfBoundsException e) {
            if (isCorrect == 10) {
                Toast toast = Toast.makeText(this, isCorrect + " out of 10 correct, Great job!", Toast.LENGTH_LONG);//before activity finishes,toast message displays
                toast.show();
            } else if (isCorrect < 10) {
                Toast toast1 = Toast.makeText(this, isCorrect + " out of 10 correct, Keep trying!", Toast.LENGTH_LONG);
                toast1.show();
            }
            finish();
        }
    }


    public void buttonChange() {
       try {
           answerA.setText(answers[problemCount]);
           answerB.setText(answers2[problemCount]);
           answerC.setText(answers3[problemCount]);
           answerD.setText(answers4[problemCount]);
       } catch (ArrayIndexOutOfBoundsException e) {
       }
           }


           public void checkA(String[] addingStuff, String[] answers) {
            String[] split = addingStuff[problemCount].split("\\+");
            int num1 = Integer.parseInt(split[0]);
            int num2 = Integer.parseInt(split[1]);
            int val1 = Integer.parseInt(answers[problemCount]);
                if (num1 + num2 == val1) {
                    isCorrect++;
                }

          }
            public void checkB(String[] addingStuff, String[] answers2) {
                String[] split = addingStuff[problemCount].split("\\+");
                int num1 = Integer.parseInt(split[0]);
                int num2 = Integer.parseInt(split[1]);
                int val2 = Integer.parseInt(answers2[problemCount]);
                    if (num1 + num2 == val2) {
                    isCorrect++;
                    }

            }
            public void checkC(String[] addingStuff, String[] answers3) {
                String[] split = addingStuff[problemCount].split("\\+");
                int num1 = Integer.parseInt(split[0]);
                int num2 = Integer.parseInt(split[1]);
                int val3 = Integer.parseInt(answers3[problemCount]);
                    if (num1 + num2 == val3) {
                    isCorrect++;
                    }

            }
            public void checkD(String[] addingStuff, String[] answers4) {
                String[] split = addingStuff[problemCount].split("\\+");
                int num1 = Integer.parseInt(split[0]);
                int num2 = Integer.parseInt(split[1]);
                int val4 = Integer.parseInt(answers4[problemCount]);
                    if (num1 + num2 == val4) {
                        isCorrect++;
                    }

            }
}

