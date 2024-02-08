package com.elitcoder.fitbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.elitcoder.fitbuddy.databinding.ActivityBmiactivityBinding;

import java.util.ArrayList;

public class BMIActivity extends AppCompatActivity {
    ActivityBmiactivityBinding bmiactivityBinding;
    ArrayList<String>ft,inch,weight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bmiactivityBinding = ActivityBmiactivityBinding.inflate(getLayoutInflater());
        View view = bmiactivityBinding.getRoot();
        setContentView(view);

        spinnerSetUp();
    }

    private void spinnerSetUp() {
        ft = new ArrayList<String>();
        inch = new ArrayList<String>();
        weight = new ArrayList<String>();
        for (int i = 1; i <= 10; i++){
            ft.add(i+" ft");
        }
        for (int i = 0; i <= 11; i++){
            inch.add(i+ " inches");
        }
        for (int i = 1; i <= 1000;i++){
            weight.add(i+" kg");
        }

        ArrayAdapter<String>adapterFt = new ArrayAdapter<String >(this, android.R.layout.simple_spinner_dropdown_item,ft);
        bmiactivityBinding.spinnerFt.setAdapter(adapterFt);

        ArrayAdapter<String>adapterInches = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,inch);
        bmiactivityBinding.spinnerIn.setAdapter(adapterInches);

        ArrayAdapter<String>adapterWeight = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,weight);
        bmiactivityBinding.spinnerWeight.setAdapter(adapterWeight);
    }
}