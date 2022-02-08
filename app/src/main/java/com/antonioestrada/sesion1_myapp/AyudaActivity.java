package com.antonioestrada.sesion1_myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AyudaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        //Para agregar la flecha de retroceder
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        List<String> consejos = new ArrayList<>();
        consejos.add("Cambie su contraseña periódicamente");
        consejos.add("No permanezca demasiado tiempo frente a la pantalla");
        consejos.add("Lea el manual de procedimientos");
        consejos.add("Apaque la computadora si no la usa");
        consejos.add("Su contraseña debe ser dificil de adivinar");

        ListView mlvConsejos = findViewById(R.id.lvConsejos);

        ListAdapter listAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                consejos);

        mlvConsejos.setAdapter(listAdapter);

    }
    @Override
    //Para que la flecha de retroceder funcione
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish(); //Se cierra el activity
        }
        return super.onOptionsItemSelected(item);
    }
}