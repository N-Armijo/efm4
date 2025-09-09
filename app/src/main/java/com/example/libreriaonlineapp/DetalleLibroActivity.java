package com.example.libreriaonlineapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleLibroActivity extends AppCompatActivity {

    private ImageView imageViewPortada;
    private TextView textViewTitulo;
    private TextView textViewDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_libro);

        // Inicializar vistas
        imageViewPortada = findViewById(R.id.imageViewPortadaDetalle);
        textViewTitulo = findViewById(R.id.textViewTituloDetalle);
        textViewDescripcion = findViewById(R.id.textViewDescripcionDetalle);

        // Obtener los datos enviados desde MainActivity
        String titulo = getIntent().getStringExtra("TITULO_LIBRO");
        String descripcion = getIntent().getStringExtra("DESCRIPCION_LIBRO");
        int imagenId = getIntent().getIntExtra("IMAGEN_LIBRO", R.drawable.libro1); // Valor por defecto

        // Mostrar los datos en la UI
        if (titulo != null) {
            textViewTitulo.setText(titulo);
        }
        if (descripcion != null) {
            textViewDescripcion.setText(descripcion);
        }
        imageViewPortada.setImageResource(imagenId);

        // Configurar botón de compra (opcional, para demostración)
        findViewById(R.id.buttonComprar).setOnClickListener(v -> {
            Toast.makeText(this, "¡Compra de '" + titulo + "' iniciada!", Toast.LENGTH_LONG).show();
        });
    }
}