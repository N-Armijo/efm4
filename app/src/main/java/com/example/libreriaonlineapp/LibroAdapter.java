package com.example.libreriaonlineapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LibroAdapter extends RecyclerView.Adapter<LibroAdapter.LibroViewHolder> {

    private Context context;
    private List<Libro> listaLibros;

    public LibroAdapter(Context context, List<Libro> listaLibros) {
        this.context = context;
        this.listaLibros = listaLibros;
    }

    @NonNull
    @Override
    public LibroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_libro, parent, false);
        return new LibroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibroViewHolder holder, int position) {
        Libro libroActual = listaLibros.get(position);

        holder.textViewTitulo.setText(libroActual.getTitulo());
        holder.textViewDescripcion.setText(libroActual.getDescripcion());
        holder.imageViewPortada.setImageResource(libroActual.getImagenResourceId());

        holder.buttonAgregarCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Agregar el libro al carrito usando el gestor
                CarritoManager.getInstancia().agregarLibro(libroActual);

                // Mostrar un mensaje de confirmacion
                Toast.makeText(context, "¡" + libroActual.getTitulo() + " agregado al carrito!", Toast.LENGTH_SHORT).show();
            }
        });

        // Navegar a la pantalla de detalles al hacer click en el item
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetalleLibroActivity.class);
            intent.putExtra("TITULO_LIBRO", libroActual.getTitulo());
            intent.putExtra("DESCRIPCION_LIBRO", libroActual.getDescripcion());
            intent.putExtra("IMAGEN_LIBRO", libroActual.getImagenResourceId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listaLibros.size();
    }

    public static class LibroViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTitulo;
        public TextView textViewDescripcion;
        public ImageView imageViewPortada;
        public Button buttonAgregarCarrito;

        public LibroViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitulo = itemView.findViewById(R.id.tv_titulo);
            textViewDescripcion = itemView.findViewById(R.id.tv_descripcion);
            imageViewPortada = itemView.findViewById(R.id.iv_portada);
            buttonAgregarCarrito = itemView.findViewById(R.id.btn_agregar_carrito);
        }
    }
}