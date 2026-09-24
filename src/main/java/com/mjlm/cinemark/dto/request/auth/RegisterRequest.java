package main.java.com.mjlm.cinemark.dto.request.auth;

public class RegisterRequest {

    private String email;
    private String nickname;
    private String contrasena;

    public RegisterRequest() {
    }

    public RegisterRequest(String email, String nickname, String contrasena) {
        this.email = email;
        this.nickname = nickname;
        this.contrasena = contrasena;
    }

    // Getters y Setters
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
