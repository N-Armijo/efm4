package com.example.libreriaonlineapp;
public class Libro {
    private String titulo;
    private String descripcion;
    private int imagenResourceId;
    private String categoria;

    public Libro(String titulo, String descripcion, int imagenResourceId, String categoria) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagenResourceId = imagenResourceId;
        this.categoria = categoria;
    }

    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public int getImagenResourceId() { return imagenResourceId; }
    public String getCategoria() { return categoria; } // Nuevo getter
}