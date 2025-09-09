package com.example.libreriaonlineapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarritoAdapter extends RecyclerView.Adapter<CarritoAdapter.CarritoViewHolder> {

    private Context context;
    private List<Libro> listaLibros;

    public CarritoAdapter(Context context, List<Libro> listaLibros) {
        this.context = context;
        this.listaLibros = listaLibros;
    }

    @NonNull
    @Override
    public CarritoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carrito, parent, false);
        return new CarritoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarritoViewHolder holder, int position) {
        Libro libro = listaLibros.get(position);

        holder.textViewTitulo.setText(libro.getTitulo());
        holder.textViewDescripcion.setText(libro.getDescripcion());
        holder.imageViewPortada.setImageResource(libro.getImagenResourceId());
    }

    @Override
    public int getItemCount() {
        return listaLibros.size();
    }

    public static class CarritoViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTitulo;
        public TextView textViewDescripcion;
        public ImageView imageViewPortada;

        public CarritoViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitulo = itemView.findViewById(R.id.textViewTituloCarrito);
            textViewDescripcion = itemView.findViewById(R.id.textViewDescripcionCarrito);
            imageViewPortada = itemView.findViewById(R.id.imageViewPortadaCarrito);
        }
    }
}