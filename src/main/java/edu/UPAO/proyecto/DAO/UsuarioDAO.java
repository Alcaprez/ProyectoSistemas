package edu.UPAO.proyecto.DAO;

import edu.UPAO.proyecto.Modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private static List<Usuario> usuarios = new ArrayList<>();

    static {
        // Datos iniciales simulando usuarios registrados
        usuarios.add(new Usuario("1234", 12345678, true, "666", "Juan Pérez", "CAJERO", "cajero1"));
        usuarios.add(new Usuario("admin", 87654321, true,"777" , "María López", "ADMIN", "admin1"));
        usuarios.add(new Usuario("0000", 11112222, false,"888" , "Carlos Ruiz", "CAJERO", "cajero2")); // este está desactivado
    }

    // Listar todos los usuarios
    public List<Usuario> listar() {
        return usuarios;
    }

    // Buscar usuario por ID
    public Usuario buscarPorId(String id) {
    if (id == null) return null;
    String needle = id.trim(); // o .toUpperCase() si quieres ignorar mayúsculas/minúsculas
    return usuarios.stream()
            .filter(u -> needle.equals(u.getId()))               // o equalsIgnoreCase
            .findFirst()
            .orElse(null);
}


    // Buscar usuario por username
    public Usuario buscarPorUsuario(String username) {
        return usuarios.stream()
                .filter(u -> u.getUsuario().equalsIgnoreCase(username))
                .findFirst()
                .orElse(null);
    }

    // Validar login
    public Usuario login(String usuario, String contrasena) {
        return usuarios.stream()
                .filter(u -> u.getUsuario().equalsIgnoreCase(usuario)
                        && u.getContrasena().equals(contrasena)
                        && u.isEstado())
                .findFirst()
                .orElse(null);
    }

    // Agregar usuario
    public void agregar(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Eliminar usuario por ID
    public void eliminar(String id) {
       if (id == null) return;
    usuarios.removeIf(u -> id.equals(u.getId()));
    }

    // Activar o desactivar usuario
    public void cambiarEstado(String id, boolean nuevoEstado) {
        Usuario u = buscarPorId(id);
        if (u != null) {
            u.setEstado(nuevoEstado);
        }
    }
}