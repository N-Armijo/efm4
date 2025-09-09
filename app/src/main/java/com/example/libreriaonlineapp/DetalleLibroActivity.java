package com.example.libreriaonlineapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

public class DetalleLibroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_libro);

        // Habilitar boton "up" en la ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ImageView imageViewPortada = findViewById(R.id.iv_portada_detalle);
        TextView textViewTitulo = findViewById(R.id.tv_titulo_detalle);
        TextView textViewDescripcion = findViewById(R.id.tv_descripcion_detalle);

        // Obtener datos del Intent
        String titulo = getIntent().getStringExtra("TITULO_LIBRO");
        String descripcion = getIntent().getStringExtra("DESCRIPCION_LIBRO");
        int imagenId = getIntent().getIntExtra("IMAGEN_LIBRO", R.drawable.katabasis);

        // Mostrar datos
        if (titulo != null) {
            textViewTitulo.setText(titulo);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(titulo);
            }
        }
        if (descripcion != null) {
            textViewDescripcion.setText(descripcion);
        }
        imageViewPortada.setImageResource(imagenId);

        // Boton de compra
        findViewById(R.id.btn_comprar).setOnClickListener(v ->
                Toast.makeText(this, "¡Proximamente;!", Toast.LENGTH_LONG).show()
        );
        if (titulo != null && getSupportActionBar() != null) {
            getSupportActionBar().setTitle(titulo);
        }
    }

    // Manejar navegacion "hacia arriba"
    @Override
    public boolean onSupportNavigateUp() {
        NavUtils.navigateUpFromSameTask(this);
        return true;
    }
}