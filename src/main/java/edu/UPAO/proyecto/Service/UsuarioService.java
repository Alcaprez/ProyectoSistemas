package edu.UPAO.proyecto.Service;

import edu.UPAO.proyecto.Modelo.Usuario;
import edu.UPAO.proyecto.DAO.UsuarioDAO;
import java.util.List;

public class UsuarioService {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public Usuario login(String usuario, String contrasena) {
        return usuarioDAO.login(usuario, contrasena);
    }
    public List<Usuario> listarUsuarios() {
        // ajusta el nombre del método real del DAO que lista todo:
        // puede llamarse listar(), obtenerTodos(), findAll(), etc.
        return usuarioDAO.listar();
    }
}
