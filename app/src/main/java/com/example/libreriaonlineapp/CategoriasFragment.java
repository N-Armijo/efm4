package com.example.libreriaonlineapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoriasFragment extends Fragment {

    private RecyclerView recyclerViewCategorias;
    private CategoriaAdapter adaptador;
    private OnCategoriaSeleccionadaListener listener; // Nueva variable

    @Override
    public void onAttach(@NonNull android.content.Context context) {
        super.onAttach(context);
        // Verificar que la actividad padre implementa la interfaz
        if (context instanceof OnCategoriaSeleccionadaListener) {
            listener = (OnCategoriaSeleccionadaListener) context;
        } else {
            throw new RuntimeException(context.toString() + " debe implementar OnCategoriaSeleccionadaListener");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categorias, container, false);

        recyclerViewCategorias = view.findViewById(R.id.rv_categorias);
        recyclerViewCategorias.setLayoutManager(new LinearLayoutManager(getContext()));

        // Lista de categorías
        List<String> categorias = new ArrayList<>();
        categorias.add("Todas");
        categorias.add("Fantasía Histórica");
        categorias.add("Fantasía");
        categorias.add("Ciencia Ficción");
        categorias.add("Fantasía Oscura");
        categorias.add("Fantasía Bélica");
        categorias.add("Fantasía Clásica");
        categorias.add("Fábula");
        categorias.add("Ficción");
        categorias.add("Infantil");
        categorias.add("Clásico");

        adaptador = new CategoriaAdapter(requireContext(), categorias, new CategoriaAdapter.OnCategoriaClickListener() {
            @Override
            public void onCategoriaClick(String categoria) {
                System.out.println("DEBUG: Categoría clickeada: " + categoria);
                Toast.makeText(requireContext(), "Categoría seleccionada: " + categoria, Toast.LENGTH_SHORT).show(); // <-- AGREGA ESTO

                if (listener != null) {
                    System.out.println("DEBUG: Enviando al listener...");
                    listener.onCategoriaSeleccionada(categoria);
                } else {
                    System.out.println("DEBUG: ¡ERROR! Listener es NULL.");
                    Toast.makeText(requireContext(), "¡ERROR! Listener es NULL.", Toast.LENGTH_LONG).show(); // <-- AGREGA ESTO
                }
            }
        });

        recyclerViewCategorias.setAdapter(adaptador);

        return view;
    }


}