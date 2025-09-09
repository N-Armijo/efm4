package com.example.libreriaonlineapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewLibros;
    private LibroAdapter adaptador;
    private List<Libro> listaLibros;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Inicializar vistas
        recyclerViewLibros = view.findViewById(R.id.recyclerViewLibros);

        // Configurar RecyclerView
        recyclerViewLibros.setLayoutManager(new LinearLayoutManager(getContext()));

        // Datos de ejemplo
        listaLibros = new ArrayList<>();
        listaLibros.add(new Libro("Cien Años de Soledad", "Obra maestra de Gabriel García Márquez.", R.drawable.libro1));
        listaLibros.add(new Libro("1984", "Distopía escrita por George Orwell.", R.drawable.libro1));
        listaLibros.add(new Libro("El Principito", "Fábula filosófica de Antoine de Saint-Exupéry.", R.drawable.libro1));
        listaLibros.add(new Libro("Don Quijote", "Novela de Miguel de Cervantes.", R.drawable.libro1));
        listaLibros.add(new Libro("Orgullo y Prejuicio", "Novela romántica de Jane Austen.", R.drawable.libro1));
        listaLibros.add(new Libro("Orgullo y Prejuicio", "Novela romántica de Jane Austen.", R.drawable.libro1));
        listaLibros.add(new Libro("Orgullo y Prejuicio", "Novela romántica de Jane Austen.", R.drawable.libro1));
        listaLibros.add(new Libro("Orgullo y Prejuicio", "Novela romántica de Jane Austen.", R.drawable.libro1));
        listaLibros.add(new Libro("Orgullo y Prejuicio", "Novela romántica de Jane Austen.", R.drawable.libro1));
        listaLibros.add(new Libro("Orgullo y Prejuicio", "Novela romántica de Jane Austen.", R.drawable.libro1));

        // Asignar adaptador
        adaptador = new LibroAdapter(requireContext(), listaLibros);
        recyclerViewLibros.setAdapter(adaptador);

        return view;
    }
}