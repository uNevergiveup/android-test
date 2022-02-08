package com.antonioestrada.sesion1_myapp.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.antonioestrada.sesion1_myapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmpleadosAdapter extends RecyclerView.Adapter<EmpleadosAdapter.ViewHolder> {

    List listEmpleados;

    public EmpleadosAdapter(List listEmpleados) {
        this.listEmpleados = listEmpleados;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_empleados,parent,false);
        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder representa a cada caja de texto
        HashMap<String,String> hashMap = (HashMap<String, String>) listEmpleados.get(position);
        holder.mtvNombre.setText(hashMap.get("empleadoTratamiento") + " " + hashMap.get("empleadoNombre") + " " + hashMap.get("empleadoApellidos"));
        holder.mtvCargo.setText(hashMap.get("empleadoCargo"));

        String path = "https://servicios.campus.pe/fotos/" + hashMap.get("empleadoFoto");
        //Usando la libreria picasso para implementar la imagen
        Picasso.get().load(path).into(holder.mivFotoEmpleado);
    }

    @Override
    public int getItemCount() {
        return listEmpleados.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mtvCargo, mtvNombre;
        ImageView mivFotoEmpleado;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mtvNombre = itemView.findViewById(R.id.tvNombre);
            mtvCargo = itemView.findViewById(R.id.tvCargo);
            mivFotoEmpleado = itemView.findViewById(R.id.ivFotoEmpleado);
        }
    }
}
