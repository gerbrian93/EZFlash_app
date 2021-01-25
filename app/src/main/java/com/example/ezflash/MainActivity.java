package com.example.ezflash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);                                      //button#1
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddActivity();
            }
        });
        button2 = findViewById(R.id.button2);                                    //button#2
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSubtractActivity();
            }
        });
        button3 = findViewById(R.id.button3);                                     //button#3
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMultiplyActivity();
            }
        });
        button4 = findViewById(R.id.button4);                                    //button#4
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDivideActivity();
            }
        });
        button5 = findViewById(R.id.button5);                                    //button#5
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutActivity();
            }
        });
    }
//methods to open various activities
    public void openAddActivity() {
        Intent intent = new Intent(this, AddingActivity.class);
        startActivity(intent);
    }
        public void openSubtractActivity() {
            Intent intent2 = new Intent(this, SubtractingActivity.class);
            startActivity(intent2);
        }
             public void openMultiplyActivity() {
                Intent intent3 = new Intent(this, MulitplyingActivity.class);
                startActivity(intent3);

            }
                public void openDivideActivity() {
                    Intent intent4 = new Intent(this, DividingActivity.class);
                    startActivity(intent4);
                }
                    public void openAboutActivity() {
                        Intent intent5 = new Intent(this, AboutActivity.class);
                        startActivity(intent5);
                    }
}