package co.com.gm.peliculas.Datos;

import co.com.gm.peliculas.Domain.Pelicula;
import co.com.gm.peliculas.Excepciones.AccesoDatosEx;
import co.com.gm.peliculas.Excepciones.EscrituraDatosEx;
import co.com.gm.peliculas.Excepciones.LecturaDatosEx;

import java.util.List;

public interface AccesoDatos {

    boolean existe(String nombreRecurso) throws AccesoDatosEx;

    List<Pelicula> listar(String nombreRecuros) throws LecturaDatosEx;

    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreRecuros, String buscar) throws LecturaDatosEx;

    void crear(String nombreRecuros) throws AccesoDatosEx;

    void borrar(String nombreRecuros) throws AccesoDatosEx;

}
