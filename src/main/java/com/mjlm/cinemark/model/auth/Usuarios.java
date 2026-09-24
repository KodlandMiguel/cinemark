package main.java.com.mjlm.cinemark.model.auth;

public class Usuarios {

    private int idUsuario;
    private String email;
    private String nickname;
    private String contrasena;

    public Usuarios(int idUsuario, String email, String nickname, String contrasena) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.nickname = nickname;
        this.contrasena = contrasena;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
