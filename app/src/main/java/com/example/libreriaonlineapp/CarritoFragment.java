package com.example.libreriaonlineapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarritoFragment extends Fragment {

    private RecyclerView recyclerViewCarrito;
    private TextView textViewMensajeVacio;
    private CarritoAdapter adaptador;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carrito, container, false);

        // Inicializar vistas
        recyclerViewCarrito = view.findViewById(R.id.rv_carrito);
        textViewMensajeVacio = view.findViewById(R.id.tv_mensaje_vacio);

        // Configurar RecyclerView
        recyclerViewCarrito.setLayoutManager(new LinearLayoutManager(getContext()));

        // Obtener libros del carrito
        List<Libro> librosEnCarrito = CarritoManager.getInstancia().getLibrosEnCarrito();

        if (librosEnCarrito.isEmpty()) {
            // Mostrar mensaje de carrito vacío
            textViewMensajeVacio.setVisibility(View.VISIBLE);
            recyclerViewCarrito.setVisibility(View.GONE);
        } else {
            // Mostrar la lista de libros
            textViewMensajeVacio.setVisibility(View.GONE);
            recyclerViewCarrito.setVisibility(View.VISIBLE);

            adaptador = new CarritoAdapter(requireContext(), librosEnCarrito);
            recyclerViewCarrito.setAdapter(adaptador);
        }

        return view;
    }
}