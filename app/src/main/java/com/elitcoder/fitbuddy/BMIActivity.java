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
        convertionOfUnits();

    }

    private void convertionOfUnits() {
        String ftS = bmiactivityBinding.spinnerFt.getSelectedItem().toString().split("\\s+")[0];
        Float ftF = Float.parseFloat(ftS);

        String inchS = bmiactivityBinding.spinnerIn.getSelectedItem().toString().split("\\s+")[0];
        Float inchF = Float.parseFloat(inchS);

        String weightS = bmiactivityBinding.spinnerWeight.getSelectedItem().toString().split("\\s+")[0];
        Float weightF = Float.parseFloat(weightS);

        Float meterF = 0.3048f*ftF + 0.0254f*inchF;
        calculateBmi(weightF,meterF);
    }

    private void calculateBmi(Float weightF, Float meterF) {
        float bmi = weightF/(meterF*meterF);
        String bmiS = Float.toString(bmi);
//        bmiactivityBinding.btnCheckBmi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                bmiactivityBinding.tvBmi.setText(bmiS);
//            }
//        });
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