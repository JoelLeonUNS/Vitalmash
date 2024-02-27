package com.sistemas.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.entidad.Usuario;

@Service
public class LoginService {
	@Autowired
    private UsuarioServiceImpl usuarioService;

    public Usuario autenticar(String nombreUsuario, String clave) {
    	
    	List<Usuario> usuarios = usuarioService.listarTodos();
    	Usuario usuarioAutenticado = null;
    	
    	for (Usuario usuario: usuarios) {
    		usuarioAutenticado = null;
			if (usuario.getNombreUsuario().equals(nombreUsuario)
	    			&& usuario.getClave().equals(clave)) {
	    		usuarioAutenticado = usuario;
	    		break;
	    	}
    	}

        return usuarioAutenticado;
    }
}
