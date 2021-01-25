package com.example.ezflash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class SubtractingActivity extends AppCompatActivity {
    private String[] array = {"9-4","6-5","10-3","5-1","8-6","12-3","9-1","11-7","13-8","3-1"};
     ArrayList<String> subtractStuff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtracting);
        subtractStuff = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            subtractStuff.add(array[i]);

        }
    }
}