package com.example.libreriaonlineapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Cargar el fragmento de inicio por defecto
        loadFragment(new HomeFragment());

        // Configurar el listener del BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment fragment = null;

            if (item.getItemId() == R.id.navigation_home) {
                fragment = new HomeFragment();
            } else if (item.getItemId() == R.id.navigation_categories) {
                fragment = new CategoriasFragment();
            } else if (item.getItemId() == R.id.navigation_cart) {
                fragment = new CarritoFragment();
            }

            if (fragment != null) {
                loadFragment(fragment);
                return true;
            }
            return false;
        });
    }

    // Método para cargar un fragmento en el contenedor
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }
}