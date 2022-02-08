package com.antonioestrada.sesion1_myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.antonioestrada.sesion1_myapp.adapters.CategoriaAdapter;
import com.antonioestrada.sesion1_myapp.adapters.EmpleadosAdapter;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmpleadosActivity extends AppCompatActivity {

    List listEmpleados = new ArrayList<HashMap<String,String>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleados);
        leerDatos();
    }
    private void leerDatos() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://servicios.campus.pe/servicioempleados.php";

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
        queue.add(stringRequest);
    }
    private void llenarLista(String response) {
        try {
            JSONArray jsonArray = new JSONArray(response); //Para que el texto response sea tratado como json
            for (int i = 0; i<jsonArray.length(); i++){

                String apellidosEmpleado = jsonArray.getJSONObject(i).getString("apellidos");
                String nombreEmpleado = jsonArray.getJSONObject(i).getString("nombres");
                String cargoEmpleado = jsonArray.getJSONObject(i).getString("cargo");
                String tratamientoEmpleado = jsonArray.getJSONObject(i).getString("tratamiento");
                String fotoEmpleado = jsonArray.getJSONObject(i).getString("foto");

                //Lo que se recupera del json y se almacena en las variables se setean en el hashmap
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("empleadoApellidos",apellidosEmpleado);
                hashMap.put("empleadoNombre",nombreEmpleado);
                hashMap.put("empleadoCargo",cargoEmpleado);
                hashMap.put("empleadoTratamiento",tratamientoEmpleado);
                hashMap.put("empleadoFoto",fotoEmpleado);

                listEmpleados.add(hashMap); //Insertando este hashmap en la lista "listEmpleados"
            }

            RecyclerView mrvEmpleados = findViewById(R.id.rvEmpleados);
            EmpleadosAdapter empleadosAdapter = new EmpleadosAdapter(listEmpleados);
            mrvEmpleados.setAdapter(empleadosAdapter);
            mrvEmpleados.setLayoutManager(new LinearLayoutManager(this));


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}