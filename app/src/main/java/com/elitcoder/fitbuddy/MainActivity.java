package com.elitcoder.fitbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.elitcoder.fitbuddy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);

        loadOptionActivity();

    }

    private void loadOptionActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent iOption = new Intent(MainActivity.this, OptionsActivity.class);
                startActivity(iOption);
            }
        },3000);
    }
}