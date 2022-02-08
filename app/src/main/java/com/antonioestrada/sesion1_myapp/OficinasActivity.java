package com.antonioestrada.sesion1_myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

import com.antonioestrada.sesion1_myapp.fragments.CuscoFragment;
import com.antonioestrada.sesion1_myapp.fragments.IcaFragment;
import com.antonioestrada.sesion1_myapp.fragments.PunoFragment;

public class OficinasActivity extends AppCompatActivity implements View.OnClickListener {
    RadioButton mrbPuno, mrbIca, mrbCusco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oficinas);
        //Para agregar la flecha de retroceder
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mrbPuno = findViewById(R.id.rbPuno);
        mrbIca = findViewById(R.id.rbIca);
        mrbCusco = findViewById(R.id.rbCusco);

        mrbPuno.setOnClickListener(this);
        mrbIca.setOnClickListener(this);
        mrbCusco.setOnClickListener(this);

        mrbPuno.setChecked(true); //Para que aparezca la imagen de puno antes de cualquier opcion
        mostrarPuno();
    }

    @Override
    //Para que la flecha de retroceder funcione
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) { //Aca se identifica la flecha
            finish(); //Se cierra el activity
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rbPuno:
                mostrarPuno();
                break;
            case R.id.rbIca:
                mostrarIca();
                break;
            case R.id.rbCusco:
                mostrarCusco();
                break;
        }
    }

    private void mostrarPuno() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedorOficinas, new PunoFragment())
                .commit();
    }

    private void mostrarIca() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedorOficinas, new IcaFragment())
                .commit();
    }

    private void mostrarCusco() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedorOficinas, new CuscoFragment())
                .commit();
    }
}