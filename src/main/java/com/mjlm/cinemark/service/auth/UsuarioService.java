package main.java.com.mjlm.cinemark.service.auth;

import java.util.List;
import main.java.com.mjlm.cinemark.dto.request.auth.RegisterRequest;
import main.java.com.mjlm.cinemark.dto.response.auth.RegisterResponse;
import main.java.com.mjlm.cinemark.model.auth.Usuarios;
import main.java.com.mjlm.cinemark.repository.auth.UsuarioRepository;

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // Inyección de dependencias por constructor
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Registrar un nuevo usuario con validaciones básicas
    public RegisterResponse registrarUsuario(RegisterRequest req) {
        if (req == null || req.getEmail() == null || req.getContrasena() == null) {
            return new RegisterResponse(0, "Los datos de registro no pueden ser nulos", false);
        }

        return usuarioRepository.registrarUsuario(req);
    }

    // Listar todos los usuarios
    public List<Usuarios> listarUsuarios() {
        return usuarioRepository.listarUsuarios();
    }

    // Buscar usuario por ID
    public Usuarios buscarPorId(int idUsuario) {
        if (idUsuario <= 0) {
            return null;
        }
        return usuarioRepository.buscarPorId(idUsuario);
    }

    // Actualizar usuario
    public boolean actualizarUsuario(int idUsuario, RegisterRequest req) {
        if (idUsuario <= 0 || req == null) {
            return false;
        }
        return usuarioRepository.actualizarUsuario(idUsuario, req);
    }

    // Eliminar usuario
    public boolean eliminarUsuario(int idUsuario) {
        if (idUsuario <= 0) {
            return false;
        }
        return usuarioRepository.eliminarUsuario(idUsuario);
    }
}
