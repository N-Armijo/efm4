package com.example.libreriaonlineapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder> {

    private Context context;
    private List<String> listaCategorias;
    private OnCategoriaClickListener listener;

    // Interfaz para manejar clics
    public interface OnCategoriaClickListener {
        void onCategoriaClick(String categoria);
    }

    public CategoriaAdapter(Context context, List<String> listaCategorias, OnCategoriaClickListener listener) {
        this.context = context;
        this.listaCategorias = listaCategorias;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categoria, parent, false);
        return new CategoriaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder holder, int position) {
        String categoria = listaCategorias.get(position);
        holder.textViewNombre.setText(categoria);

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onCategoriaClick(categoria);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaCategorias.size();
    }

    public static class CategoriaViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNombre;

        public CategoriaViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.textViewNombreCategoria);
        }
    }
}