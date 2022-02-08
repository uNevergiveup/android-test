package com.antonioestrada.sesion1_myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.antonioestrada.sesion1_myapp.adapters.CategoriaAdapter;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TiendaActivity extends AppCompatActivity {

    List list = new ArrayList<HashMap<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda);
        leerDatos();
    }

    private void leerDatos() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://servicios.campus.pe/serviciocategorias.php";

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
            JSONArray jsonArray = new JSONArray(response); //Para que el texto response sea tratado como json
            for (int i = 0; i<jsonArray.length(); i++){

                String idCategoria = jsonArray.getJSONObject(i).getString("idcategoria");
                String nombreCategoria = jsonArray.getJSONObject(i).getString("nombre");
                String descripcionCategoria = jsonArray.getJSONObject(i).getString("descripcion");

                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("idCategoria",idCategoria);
                hashMap.put("nombre",nombreCategoria);
                hashMap.put("descripcion",descripcionCategoria);

                list.add(hashMap); //Insertando este hashmap en la lista "list"
            }

            RecyclerView mrvCategorias = findViewById(R.id.rvCategorias);
            CategoriaAdapter categoriaAdapter = new CategoriaAdapter(list);
            mrvCategorias.setAdapter(categoriaAdapter);
            mrvCategorias.setLayoutManager(new LinearLayoutManager(this));


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}