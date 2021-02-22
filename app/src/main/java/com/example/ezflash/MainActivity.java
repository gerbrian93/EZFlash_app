package com.example.ezflash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> openAddActivity());

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v -> openSubtractActivity());

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(v -> openMultiplyActivity());

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(v -> openDivideActivity());

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(v -> openAboutActivity());
    }
//methods to start various activities
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