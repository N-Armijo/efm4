package com.example.libreriaonlineapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewLibros;
    private LibroAdapter adaptador;
    private List<Libro> listaLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar vistas
        recyclerViewLibros = findViewById(R.id.recyclerViewLibros);

        // Configurar el RecyclerView
        recyclerViewLibros.setLayoutManager(new LinearLayoutManager(this));

        // Crear la lista de libros de ejemplo
        listaLibros = new ArrayList<>();
        listaLibros.add(new Libro("Cien Años de Soledad", "Obra maestra de Gabriel García Márquez.", R.drawable.libro1));
        listaLibros.add(new Libro("1984", "Distopía escrita por George Orwell.", R.drawable.libro1));
        listaLibros.add(new Libro("El Principito", "Fábula filosófica de Antoine de Saint-Exupéry.", R.drawable.libro1));
        listaLibros.add(new Libro("Don Quijote de la Mancha", "Novela de Miguel de Cervantes.", R.drawable.libro1));
        listaLibros.add(new Libro("Orgullo y Prejuicio", "Novela romántica de Jane Austen.", R.drawable.libro1));
        listaLibros.add(new Libro("La guerra de la amapola", "Novela romántica de Jane Austen.", R.drawable.libro1));
        listaLibros.add(new Libro("La republica del dragon", "Novela romántica de Jane Austen.", R.drawable.libro1));
        listaLibros.add(new Libro("dune", "Novela romántica de Jane Austen.", R.drawable.libro1));
        listaLibros.add(new Libro("Harry Potter", "Novela romántica de Jane Austen.", R.drawable.libro1));
        listaLibros.add(new Libro("jurassic pak", "Novela romántica de Jane Austen.", R.drawable.libro1));
        listaLibros.add(new Libro("El señor de los anillos", "Novela romántica de Jane Austen.", R.drawable.libro1));

        // Crear y asignar el adaptador
        adaptador = new LibroAdapter(this, listaLibros);
        recyclerViewLibros.setAdapter(adaptador);
    }
}