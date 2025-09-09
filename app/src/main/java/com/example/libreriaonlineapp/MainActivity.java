package com.example.libreriaonlineapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements OnCategoriaSeleccionadaListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bnv_navigation);

        // Cargar el fragmento de inicio por defecto
        loadFragment(new HomeFragment());

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

    public void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        String tag = null;

        if (fragment instanceof HomeFragment) {
            tag = "HOME_FRAGMENT";
        } else if (fragment instanceof CategoriasFragment) {
            tag = "CATEGORIAS_FRAGMENT";
        } else if (fragment instanceof CarritoFragment) {
            tag = "CARRITO_FRAGMENT";
        }

        fragmentManager.beginTransaction()
                .replace(R.id.fl_fragment_container, fragment, tag)
                .commit();
    }

    @Override
    public void onCategoriaSeleccionada(String categoria) {
        System.out.println("DEBUG: MainActivity recibio: " + categoria);

        // Siempre creamos un NUEVO HomeFragment
        HomeFragment homeFragment = new HomeFragment();

        // Guardamos la categoría seleccionada en una variable estática
        HomeFragment.CATEGORIA_SELECCIONADA = categoria;

        // Cargamos el nuevo fragmento
        loadFragment(homeFragment);

        // Cambiamos a la pestaña de Inicio
        BottomNavigationView bottomNav = findViewById(R.id.bnv_navigation);
        bottomNav.setSelectedItemId(R.id.navigation_home);
    }
}