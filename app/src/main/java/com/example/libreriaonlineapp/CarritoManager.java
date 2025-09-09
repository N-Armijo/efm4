package com.example.libreriaonlineapp;

import java.util.ArrayList;
import java.util.List;

public class CarritoManager {
    // Singleton: Única instancia de la clase
    private static CarritoManager instancia;

    // Lista que almacena los libros en el carrito
    private List<Libro> librosEnCarrito;

    // Constructor privado para evitar instanciación externa
    private CarritoManager() {
        librosEnCarrito = new ArrayList<>();
    }

    // Método para obtener la instancia única
    public static CarritoManager getInstancia() {
        if (instancia == null) {
            instancia = new CarritoManager();
        }
        return instancia;
    }

    // Agregar un libro al carrito
    public void agregarLibro(Libro libro) {
        librosEnCarrito.add(libro);
    }

    // Obtener la lista completa de libros en el carrito
    public List<Libro> getLibrosEnCarrito() {
        return new ArrayList<>(librosEnCarrito); // Devolvemos una copia para evitar modificaciones externas
    }
    //Futuro implementar un botno para borrar elementos de carrito o un solo elemnto
    // Obtener la cantidad de libros en el carrito
    public int getCantidadLibros() {
        return librosEnCarrito.size();
    }

    // Vaciar el carrito (opcional)
    public void vaciarCarrito() {
        librosEnCarrito.clear();
    }
}
