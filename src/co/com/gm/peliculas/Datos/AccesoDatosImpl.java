package co.com.gm.peliculas.Datos;

import co.com.gm.peliculas.Domain.Pelicula;
import co.com.gm.peliculas.Excepciones.AccesoDatosEx;
import co.com.gm.peliculas.Excepciones.EscrituraDatosEx;
import co.com.gm.peliculas.Excepciones.LecturaDatosEx;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatosImpl implements AccesoDatos {


    @Override
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {

        var archivo = new File(nombreRecurso);

        return archivo.exists();

    }

    @Override
    public List<Pelicula> listar(String nombreRecuros) throws LecturaDatosEx {
        var archivo = new File(nombreRecuros);
        List<Pelicula> peliculas = new ArrayList<>();

        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {

                var pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();

            }
            entrada.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar pelicula: " + e.getMessage());
        } catch (IOException e) {
            throw new LecturaDatosEx("Excepcion al listar pelicula: " + e.getMessage());
        }
        return peliculas;

    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {

        var archivo = new File(nombreRecurso);

        try {
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito información al archivo:" + pelicula);
        } catch (IOException e) {
            throw new EscrituraDatosEx("Excepcion al escribir pelicula: " + e.getMessage());
        }


    }

    @Override
    public String buscar(String nombreRecuros, String buscar) throws LecturaDatosEx {

        var archivo = new File(nombreRecuros);
        String resultado = null;

        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            int indice = 1;
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Pelicula " + linea + "encontrada en el indice " + indice;
                    break;

                }
                linea = entrada.readLine();
                indice++;

            }
            entrada.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar pelicula: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar pelicula: " + e.getMessage());
        }

        return resultado;
    }

    @Override
    public void crear(String nombreRecuros) throws AccesoDatosEx {

        var archivo = new File(nombreRecuros);
        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (IOException e) {
            e.printStackTrace();
            throw new AccesoDatosEx("Excepcion al crear archivo: " + e.getMessage());
        }


    }

    @Override
    public void borrar(String nombreRecuros) throws AccesoDatosEx {

        var archivo = new File(nombreRecuros);
        if (archivo.exists())
            archivo.delete();
        System.out.println("Se ha borrado el archivo");

    }
}
