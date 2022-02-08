package com.antonioestrada.sesion1_myapp.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.antonioestrada.sesion1_myapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.ViewHolder> {
    //Clase Adapter para enlazar los datos que tenemos en el Array con esta clase (CategoriaAdapter)
    //Luego enlazar esta clase con item_categoria

    List list;
    public static OnItemClickListener onItemClickListener;

    public CategoriaAdapter(List list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_categoria,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder representa a cada caja de texto
        HashMap<String, String> hashMap = (HashMap<String, String>) list.get(position);
        holder.mtvCategoriaNombre.setText(hashMap.get("nombre"));
        holder.mtvCategoriaDescripcion.setText(hashMap.get("descripcion"));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mtvCategoriaNombre,mtvCategoriaDescripcion;

        public ViewHolder(@NonNull View itemView) {
            //Acceso a cada caja de texto
            super(itemView);
            mtvCategoriaNombre = itemView.findViewById(R.id.tvCategoriaNombre);
            mtvCategoriaDescripcion = itemView.findViewById(R.id.tvCategoriaDescripcion);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d("POSITION",String.valueOf(getLayoutPosition()));

            onItemClickListener.onItemClick(getLayoutPosition());
        }
    }
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        CategoriaAdapter.onItemClickListener = onItemClickListener;
    }
}
