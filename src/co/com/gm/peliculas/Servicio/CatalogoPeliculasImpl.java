package co.com.gm.peliculas.Servicio;

import co.com.gm.peliculas.Datos.AccesoDatos;
import co.com.gm.peliculas.Datos.AccesoDatosImpl;
import co.com.gm.peliculas.Domain.Pelicula;
import co.com.gm.peliculas.Excepciones.AccesoDatosEx;
import co.com.gm.peliculas.Excepciones.LecturaDatosEx;

public class CatalogoPeliculasImpl implements CatalogoPeliculas {

    private final AccesoDatos datos;


    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }


    @Override
    public void agregarPelicula(String nombrePelicula) {

        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = datos.listar(NOMBRE_RECURSO);
            for (var pelicula : peliculas) {
                System.out.println("pelicula = " + pelicula);
            }
        } catch (LecturaDatosEx e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void buscarPelicula(String buscar) {

        String resultado = null;
        try {
            resultado = datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (LecturaDatosEx e) {
            throw new RuntimeException(e);
        }
        System.out.println("resultado = " + resultado);

    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if (datos.existe(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);

            } else {
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx e) {
            throw new RuntimeException(e);
        }

    }
}
