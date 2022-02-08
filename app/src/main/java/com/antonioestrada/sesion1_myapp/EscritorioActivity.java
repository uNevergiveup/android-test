package com.antonioestrada.sesion1_myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EscritorioActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escritorio);

        Button mbtnTienda = findViewById(R.id.btnTienda);
        Button mbtnEmpleados = findViewById(R.id.btnEmpleados);
        Button mbtnCorporacion = findViewById(R.id.btnCorporacion);
        Button mbtnCaja = findViewById(R.id.btnCaja);
        Button mbtnCerrarSesion = findViewById(R.id.btnCerrarSesion);
        Button mbtnSalir = findViewById(R.id.btnSalir);

        mbtnTienda.setOnClickListener(this);
        mbtnEmpleados.setOnClickListener(this);
        mbtnCorporacion.setOnClickListener(this);
        mbtnCaja.setOnClickListener(this);
        mbtnCerrarSesion.setOnClickListener(this);
        mbtnSalir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnTienda:
                mostrarTienda();
                break;
            case R.id.btnEmpleados:
                mostrarEmpleados(); 
                break;
            case R.id.btnCorporacion:
                mostrarCorporacion(); 
                break;
            case R.id.btnCaja:
                mostrarCaja(); 
                break;
            case R.id.btnCerrarSesion:
                mostrarCerrarSesion(); 
                break;
            case R.id.btnSalir:
                mostrarSalir(); 
                break;
        }
    }

    private void mostrarSalir() {
    }

    private void mostrarCerrarSesion() {
    }

    private void mostrarCaja() {
    }

    private void mostrarCorporacion() {
    }

    private void mostrarEmpleados() {
        startActivity(new Intent(this,EmpleadosActivity.class));
    }

    private void mostrarTienda() {
        //Se muestra el activity Tienda
        startActivity(new Intent(this,TiendaActivity.class));
    }
}