package com.antonioestrada.sesion1_myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AcercaDeActivity extends AppCompatActivity {

    ArrayList arrayList = new ArrayList<HashMap<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        //Para agregar la flecha de retroceder
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        leerDatos();
    }

    private void leerDatos() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://servicios.campus.pe/servicioproveedores.php";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Datos",response);
                        llenarLista(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Datos",error.getMessage());
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private void llenarLista(String response) {
        try {
            JSONArray jsonArray = new JSONArray(response);
            for (int i = 0; i<jsonArray.length(); i++){
                String idProveedor = jsonArray.getJSONObject(i).getString("idproveedor");
                String nombreEmpresa = jsonArray.getJSONObject(i).getString("nombreempresa");
                String nombreContacto = jsonArray.getJSONObject(i).getString("nombrecontacto");
                String ciudad = jsonArray.getJSONObject(i).getString("ciudad");


                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("codigo",idProveedor);
                hashMap.put("nombre",nombreEmpresa);
                hashMap.put("contrato",nombreContacto);
                hashMap.put("ciudad",ciudad);

                arrayList.add(hashMap); //Insertando este hashmap en la lista "list"

            }
            String [] origen = {"codigo","nombre","contrato","ciudad"};
            int [] destino = {R.id.tvcodigoempresa,R.id.tvnombreempresa,R.id
                    .tvnombrecontacto,R.id.tvciudad};

            ListAdapter listAdapter = new SimpleAdapter(this,
                    arrayList,
                    R.layout.item_proovedor,
                    origen,
                    destino);

            ListView mlvProovedores = findViewById(R.id.lvProovedores);
            mlvProovedores.setAdapter(listAdapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }

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