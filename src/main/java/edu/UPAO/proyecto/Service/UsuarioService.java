package edu.UPAO.proyecto.Service;

import edu.UPAO.proyecto.Modelo.Usuario;
import edu.UPAO.proyecto.DAO.UsuarioDAO;

public class UsuarioService {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public Usuario login(String usuario, String contrasena) {
        return usuarioDAO.login(usuario, contrasena);
    }
}
