package com.antonioestrada.sesion1_myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EmpezarActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empezar);

        Button mbtnIniciar = findViewById(R.id.btnIniciar);
        TextView mtvTerminos = findViewById(R.id.tvTerminos);

        mbtnIniciar.setOnClickListener(this);
        mtvTerminos.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnIniciar:
                startActivity(new Intent(this,LoginActivity.class));
                break;
            case R.id.tvTerminos:
                startActivity(new Intent(this,TerminosActivity.class));
                break;
        }
    }
}