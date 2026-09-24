package main.java.com.mjlm.cinemark.model.movies;

public class Peliculas {

    private int idPelicula;
    private String nombrePelicula;
    private double duracion;

    public Peliculas(int idPelicula, String nombrePelicula, double duracion) {
        this.idPelicula = idPelicula;
        this.nombrePelicula = nombrePelicula;
        this.duracion = duracion;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
}
