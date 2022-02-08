package com.antonioestrada.sesion1_myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mbtnEmpezar = findViewById(R.id.btnEmpezar);
        mbtnEmpezar.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,EmpezarActivity.class));
    }
}