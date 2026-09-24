package main.java.com.mjlm.cinemark.repository.auth;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.java.com.mjlm.cinemark.config.ConnectionDB;
import main.java.com.mjlm.cinemark.dto.request.auth.RegisterRequest;
import main.java.com.mjlm.cinemark.dto.response.auth.RegisterResponse;
import main.java.com.mjlm.cinemark.model.auth.Usuarios;
import main.java.com.mjlm.cinemark.security.jbcrypt.BCrypt;

public class UsuarioRepository {

    public UsuarioRepository() {
    }

    // CREATE (Registrar Usuario)
    public RegisterResponse registrarUsuario(RegisterRequest req) {
        String sql = "INSERT INTO Usuarios (email, nickname, contrasena) VALUES (?, ?, ?)";

        // Encriptar la contraseña con BCrypt
        String contrasenaHasheada = BCrypt.hashpw(req.getContrasena(), BCrypt.gensalt());

        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, req.getEmail());
            pstmt.setString(2, req.getNickname());
            pstmt.setString(3, contrasenaHasheada);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int idGenerado = generatedKeys.getInt(1);
                        return new RegisterResponse(idGenerado, "Usuario registrado exitosamente", true);
                    }
                }
            }
            return new RegisterResponse(0, "No se pudo registrar el usuario", false);

        } catch (SQLException e) {
            return new RegisterResponse(0, "Error en la base de datos: " + e.getMessage(), false);
        }
    }

    // READ (Obtener todos los usuarios)
    public List<Usuarios> listarUsuarios() {
        List<Usuarios> usuarios = new ArrayList<>();
        String sql = "SELECT id_usuario, email, nickname, contrasena FROM Usuarios";

        try (Connection conn = ConnectionDB.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuarios u = new Usuarios(
                        rs.getInt("id_usuario"),
                        rs.getString("email"),
                        rs.getString("nickname"),
                        rs.getString("contrasena")
                );
                usuarios.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    // READ (Buscar usuario por ID)
    public Usuarios buscarPorId(int idUsuario) {
        String sql = "SELECT id_usuario, email, nickname, contrasena FROM Usuarios WHERE id_usuario = ?";

        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idUsuario);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Usuarios(
                            rs.getInt("id_usuario"),
                            rs.getString("email"),
                            rs.getString("nickname"),
                            rs.getString("contrasena")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // UPDATE (Actualizar usuario)
    public boolean actualizarUsuario(int idUsuario, RegisterRequest req) {
        String sql = "UPDATE Usuarios SET email = ?, nickname = ?, contrasena = ? WHERE id_usuario = ?";

        // Encriptar la nueva contraseña con BCrypt
        String contrasenaHasheada = BCrypt.hashpw(req.getContrasena(), BCrypt.gensalt());

        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, req.getEmail());
            pstmt.setString(2, req.getNickname());
            pstmt.setString(3, contrasenaHasheada);
            pstmt.setInt(4, idUsuario);

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE (Eliminar usuario)
    public boolean eliminarUsuario(int idUsuario) {
        String sql = "DELETE FROM Usuarios WHERE id_usuario = ?";

        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idUsuario);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
