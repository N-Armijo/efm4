package com.example.libreriaonlineapp;

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

    public static String CATEGORIA_SELECCIONADA = "Todas";

    private RecyclerView recyclerViewLibros;
    private LibroAdapter adaptador;
    private List<Libro> listaLibros;
    private List<Libro> listaLibrosCompleta;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerViewLibros = view.findViewById(R.id.rv_libros);
        recyclerViewLibros.setLayoutManager(new LinearLayoutManager(getContext()));

        // Crear la lista de libros -> Debo cambiar imagenes
        listaLibros = new ArrayList<>();
        listaLibros.add(new Libro("Babel", "Una novela de historia secreta y fantasía oscura de Rebecca F. Kuang.", R.drawable.libro1, "Fantasía Histórica"));
        listaLibros.add(new Libro("La República del Dragón", "Una épica de fantasía de la aclamada autora Rebecca F. Kuang.", R.drawable.libro1, "Fantasía"));
        listaLibros.add(new Libro("Proyecto Hail Mary", "Una historia de supervivencia intergaláctica de Andy Weir.", R.drawable.libro1, "Ciencia Ficción"));
        listaLibros.add(new Libro("Dune", "La obra maestra de ciencia ficción de Frank Herbert.", R.drawable.libro1, "Ciencia Ficción"));
        listaLibros.add(new Libro("El Problema de los Tres Cuerpos", "El inicio de una trilogía de Liu Cixin que redefine la ciencia ficción moderna.", R.drawable.libro1, "Ciencia Ficción"));
        listaLibros.add(new Libro("Katabasis", " La novela sigue a dos magos, candidatos a doctorado, que deben aventurarse en el infierno para salvar a su director de tesis y así obtener cartas de recomendación.", R.drawable.libro1, "Ciencia Ficción"));
        listaLibros.add(new Libro("La Tumba del Emperador", "El primer libro de una serie de fantasía oscura y ciencia ficción de Tamsyn Muir.", R.drawable.libro1, "Fantasía Oscura"));
        listaLibros.add(new Libro("La Guerra de la Amapola", "El primer libro de la trilogía bélica de fantasía de R.F. Kuang.", R.drawable.libro1, "Fantasía Bélica"));
        listaLibros.add(new Libro("Cuentos de Terramar", "Una serie de fantasía clásica de Ursula K. Le Guin.", R.drawable.libro1, "Fantasía Clásica"));
        listaLibros.add(new Libro("El Asesino de Mago", "Un thriller de fantasía de Robin Hobb.", R.drawable.libro1, "Fantasía"));
        listaLibros.add(new Libro("Gideon la Novena", "Ciencia ficción y fantasía oscura de Tamsyn Muir.", R.drawable.libro1, "Ciencia Ficción"));
        listaLibros.add(new Libro("El Principito", "Fábula filosófica de Antoine de Saint-Exupéry.", R.drawable.libro1, "Fábula"));
        listaLibros.add(new Libro("Matilda", "Una niña genio que descubre sus poderes, de Roald Dahl.", R.drawable.libro1, "Ficción"));
        listaLibros.add(new Libro("Donde Viven los Monstruos", "Una aventura de Max en un mundo imaginario.", R.drawable.libro1, "Infantil"));
        listaLibros.add(new Libro("El Grúfalo", "Un ratón ingenioso se enfrenta a una criatura espantosa.", R.drawable.libro1, "Infantil"));
        listaLibros.add(new Libro("La Telaraña de Carlota", "Una historia de amistad entre una araña y un cerdo.", R.drawable.libro1, "Infantil"));
        listaLibros.add(new Libro("El Libro de la Selva", "Las aventuras de Mowgli en la selva, de Rudyard Kipling.", R.drawable.libro1, "Clásico"));
        listaLibros.add(new Libro("Harry Potter y la Piedra Filosofal", "El inicio de las aventuras de Harry Potter en Hogwarts.", R.drawable.libro1, "Fantasía"));

        // Guardar copia original
        listaLibrosCompleta = new ArrayList<>(listaLibros);

        // CREAR EL ADAPTADOR ANTES DE FILTRAR
        adaptador = new LibroAdapter(requireContext(), listaLibros);
        recyclerViewLibros.setAdapter(adaptador);

        // Aplicar el filtro DESPUES de que el adaptador este listo
        if (!CATEGORIA_SELECCIONADA.equals("Todas")) {
            filtrarPorCategoria(CATEGORIA_SELECCIONADA);
        }

        return view;
    }

    public void filtrarPorCategoria(String categoria) {
        System.out.println("Categoría seleccionada: " + categoria);
        listaLibros.clear();

        if (categoria.equals("Todas")) {
            listaLibros.addAll(listaLibrosCompleta);
        } else {
            for (Libro libro : listaLibrosCompleta) {
                if (libro.getCategoria().equals(categoria)) {
                    listaLibros.add(libro);
                }
            }
        }

        adaptador.notifyDataSetChanged();
    }
}