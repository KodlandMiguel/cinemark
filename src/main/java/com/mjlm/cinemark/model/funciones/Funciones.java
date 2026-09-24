package main.java.com.mjlm.cinemark.model.funciones;

public class Funciones {

    private int idFuncion;
    private int idPelicula;
    private String fecha;
    private double horas;

    public Funciones(int idFuncion, int idPelicula, String fecha, double horas) {
        this.idFuncion = idFuncion;
        this.idPelicula = idPelicula;
        this.fecha = fecha;
        this.horas = horas;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }
}
