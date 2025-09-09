package com.example.libreriaonlineapp;

public class Libro {
    private String titulo;
    private String descripcion;
    private int imagenResourceId; // ID del recurso de la imagen

    // Constructor
    public Libro(String titulo, String descripcion, int imagenResourceId) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagenResourceId = imagenResourceId;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getImagenResourceId() {
        return imagenResourceId;
    }
}