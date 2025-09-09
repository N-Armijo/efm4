package com.example.libreriaonlineapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

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
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Configurar RecyclerView
        recyclerViewLibros.setLayoutManager(new LinearLayoutManager(this));

        // Datos de ejemplo
        listaLibros = new ArrayList<>();
        listaLibros.add(new Libro("Cien Años de Soledad", "Obra maestra de Gabriel García Márquez.", R.drawable.libro1));
        listaLibros.add(new Libro("1984", "Distopía escrita por George Orwell.", R.drawable.libro1));
        listaLibros.add(new Libro("El Principito", "Fábula filosófica de Antoine de Saint-Exupéry.", R.drawable.libro1));
        listaLibros.add(new Libro("Don Quijote", "Novela de Miguel de Cervantes.", R.drawable.libro1));
        listaLibros.add(new Libro("Orgullo y Prejuicio", "Novela romántica de Jane Austen.", R.drawable.libro1));

        // Asignar adaptador
        adaptador = new LibroAdapter(this, listaLibros);
        recyclerViewLibros.setAdapter(adaptador);

        // Configurar BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navigation_home) {
                // Ya estamos en Home, no hacemos nada
                return true;
            } else if (item.getItemId() == R.id.navigation_categories) {
                startActivity(new Intent(MainActivity.this, CategoriasActivity.class));
                return true;
            } else if (item.getItemId() == R.id.navigation_cart) {
                startActivity(new Intent(MainActivity.this, CarritoActivity.class));
                return true;
            }
            return false;
        });
    }
}