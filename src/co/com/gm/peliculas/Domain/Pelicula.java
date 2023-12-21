package co.com.gm.peliculas.Domain;

public class Pelicula {

    private String Nombre;

    public Pelicula(String nombre) {
        this.Nombre = nombre;
    }

    public Pelicula() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    @Override
    public String toString() {
        return this.Nombre;
    }
}
