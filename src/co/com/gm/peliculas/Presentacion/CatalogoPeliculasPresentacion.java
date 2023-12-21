package co.com.gm.peliculas.Presentacion;

import co.com.gm.peliculas.Servicio.CatalogoPeliculas;
import co.com.gm.peliculas.Servicio.CatalogoPeliculasImpl;

import java.util.Scanner;

public class CatalogoPeliculasPresentacion {

    public static void main(String[] args) {

        var opcion = -1;
        Scanner sc = new Scanner(System.in);
        CatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImpl();


        while (opcion != 0) {
            System.out.println("Elija una opción: \n"
                    + "1. Iniciar catalogo peliculas\n" +
                    "2. Agregar pelicula\n" +
                    "3. Listar Peliculas\n" +
                    "4. Buscar Pelicula\n" +
                    "0. Salir\n");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1:

                    catalogoPeliculas.iniciarCatalogoPeliculas();
                    break;

                case 2:

                    System.out.println("Introduzca Nombre de la Pelicula");
                    var nombrePelicula = sc.nextLine();
                    catalogoPeliculas.agregarPelicula(nombrePelicula);
                    break;

                case 3:

                    catalogoPeliculas.listarPeliculas();
                    break;

                case 4:

                    System.out.println("Introduzca nombre a buscar");
                    var buscar = sc.nextLine();
                    catalogoPeliculas.buscarPelicula(buscar);
                    break;

                case 0:

                    System.out.println("Adios");
                    break;

                default:

                    System.out.println("Opcion no reconocida");

            }
        }
    }
}
