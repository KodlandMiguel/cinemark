package main.java.com.mjlm.cinemark.dto.response.auth;

public class RegisterResponse {

    private int idUsuario;
    private String mensaje;
    private boolean exito;

    public RegisterResponse(int idUsuario, String mensaje, boolean exito) {
        this.idUsuario = idUsuario;
        this.mensaje = mensaje;
        this.exito = exito;
    }

    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isExito() {
        return exito;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }
}
