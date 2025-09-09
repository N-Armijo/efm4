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
        listaLibros.add(new Libro("Babel", "Una novela de historia secreta y fantasía oscura de Rebecca F. Kuang.", R.drawable.babel, "Fantasía Histórica"));
        listaLibros.add(new Libro("La República del Dragón", "Una épica de fantasía de la aclamada autora Rebecca F. Kuang.", R.drawable.republica_dragon, "Fantasía"));
        listaLibros.add(new Libro("Proyecto Hail Mary", "Una historia de supervivencia intergaláctica de Andy Weir.", R.drawable.proyecto_hail_mary, "Ciencia Ficción"));
        listaLibros.add(new Libro("Dune", "La obra maestra de ciencia ficción de Frank Herbert.", R.drawable.dune, "Ciencia Ficción"));
        listaLibros.add(new Libro("El Problema de los Tres Cuerpos", "El inicio de una trilogía de Liu Cixin que redefine la ciencia ficción moderna.", R.drawable.el_problema_de_los_tres_cuerpos, "Ciencia Ficción"));
        listaLibros.add(new Libro("Katabasis", " La novela sigue a dos magos, candidatos a doctorado, que deben aventurarse en el infierno para salvar a su director de tesis y así obtener cartas de recomendación.", R.drawable.katabasis, "Ciencia Ficción"));
        listaLibros.add(new Libro("La Tumba del Emperador", "El primer libro de una serie de fantasía oscura y ciencia ficción de Tamsyn Muir.", R.drawable.la_tumba_del_emperador, "Fantasía Oscura"));
        listaLibros.add(new Libro("La Guerra de la Amapola", "El primer libro de la trilogía bélica de fantasía de R.F. Kuang.", R.drawable.la_guerra_de_la_amapola, "Fantasía Bélica"));
        listaLibros.add(new Libro("Cuentos de Terramar", "Una serie de fantasía clásica de Ursula K. Le Guin.", R.drawable.cuentos_de_terramar, "Fantasía Clásica"));
        listaLibros.add(new Libro("Asesino Real", "Un thriller de fantasía de Robin Hobb.", R.drawable.asesino_real, "Fantasía"));
        listaLibros.add(new Libro("Harrow La Novena", "Ciencia ficción y fantasía oscura de Tamsyn Muir.", R.drawable.harrow_la_novena, "Ciencia Ficción"));
        listaLibros.add(new Libro("El Principito", "Fábula filosófica de Antoine de Saint-Exupéry.", R.drawable.el_principito, "Fábula"));
        listaLibros.add(new Libro("Matilda", "Una niña genio que descubre sus poderes, de Roald Dahl.", R.drawable.matilda, "Infantil"));
        listaLibros.add(new Libro("Donde Viven los Monstruos", "Una aventura de Max en un mundo imaginario, de Maurice Sendak.", R.drawable.donde_viven_los_monstruos, "Infantil"));
        listaLibros.add(new Libro("El Grúfalo", "Un ratón ingenioso se enfrenta a una criatura espantosa, de Julia Donaldson.", R.drawable.el_grufalo, "Infantil"));
        listaLibros.add(new Libro("La Telaraña de Carlota", "Una historia de amistad entre una araña y un cerdo.", R.drawable.la_telarana_de_carlota, "Infantil"));
        listaLibros.add(new Libro("El Libro de la Selva", "Las aventuras de Mowgli en la selva, de Rudyard Kipling.", R.drawable.el_libro_de_la_selva, "Clásico"));
        listaLibros.add(new Libro("Harry Potter y la Piedra Filosofal", "El inicio de las aventuras de Harry Potter en Hogwarts.", R.drawable.harry_potter_y_la_piedra_filosofal, "Fantasía"));

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