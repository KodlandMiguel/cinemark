package main.java.com.mjlm.cinemark.model.salas;

public class Salas {

    private int idSala;
    private int idPelicula;
    private int idUsuario;

    public Salas(int idSala, int idPelicula, int idUsuario) {
        this.idSala = idSala;
        this.idPelicula = idPelicula;
        this.idUsuario = idUsuario;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
