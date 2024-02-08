package com.elitcoder.fitbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.elitcoder.fitbuddy.databinding.ActivityOptionsBinding;

public class OptionsActivity extends AppCompatActivity {
    ActivityOptionsBinding optionsBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        optionsBinding = ActivityOptionsBinding.inflate(getLayoutInflater());
        View view = optionsBinding.getRoot();
        setContentView(view);

        loadBMIActivity();
        loadPedometerActivty();
    }

    private void loadPedometerActivty() {
        optionsBinding.imgRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iPed = new Intent(OptionsActivity.this, PedoMeterActivity.class);
                startActivity(iPed);
            }
        });
    }

    private void loadBMIActivity() {
        optionsBinding.imgBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBMI = new Intent(OptionsActivity.this, BMIActivity.class);
                startActivity(iBMI);
            }
        });
    }
}