package com.antonioestrada.sesion1_myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Se crea un buton y se le asigna el valor del buton del layout
        Button mBtnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        //Se le crea un evento al hacer click
        mBtnIniciarSesion.setOnClickListener(this);

        ImageView mivFotoLogin = findViewById(R.id.ivFotoLogin);
        String path = "https://365psd.com/images/istock/previews/9058/90581657-people-large-group.jpg";

        //Usando la libreria picasso para implementar la imagen
        Picasso.get().load(path).into(mivFotoLogin);
    }

    //Para mostrar el menu en este Activity (Login Activity)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.nav_ayuda:
                mostrarAyuda(); 
                return true;
            case R.id.nav_informacion:
                mostrarInformacion(); 
                return true;
            case R.id.nav_oficinas:
                mostrarOficinas();
                return true;
            case R.id.nav_acercade:
                mostrarAcercaDe();
                return true;
            case R.id.nav_contactos:
                mostrarContactos();
                return true;
            case R.id.nav_calendario:
                mostrarCalendario();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void mostrarAyuda() {
        startActivity(new Intent(this, AyudaActivity.class));
    }

    private void mostrarInformacion() {
        startActivity(new Intent(this,InformacionActivity.class));
    }

    private void mostrarOficinas() {
        startActivity(new Intent(this, OficinasActivity.class));
    }

    private void mostrarAcercaDe() {
        startActivity(new Intent(this, AcercaDeActivity.class));
    }

    private void mostrarContactos() {
        //Para que diriga a los contactos del telefono
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_CONTACTS);
        startActivity(intent);
    }

    private void mostrarCalendario() {
        //Para que diriga al calendario del telefono
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_CALENDAR);
        startActivity(intent);
    }
    //El evento al hacer click "Iniciar Sesion" te lleva al escritorioactivyt
    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,EscritorioActivity.class));
    }
}
