package com.sistemas.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sistemas.entidad.Usuario;
import com.sistemas.repositorio.UsuarioRepository;

@Service
public class UserDetailsImpl implements UserDetailsService{

	private final UsuarioRepository usuarioRepository;
	
	@Autowired
    public UserDetailsImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Usuario> usuarios = usuarioRepository.findAll();
    	Usuario usuarioAutenticado = null;

    	for (Usuario usuario: usuarios) {

			if (usuario.getNombreusuario().equals(username)
	    			) {
	    		usuarioAutenticado = usuario;
	    		break;
	    	}
    	}

		if (usuarioAutenticado == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
		return usuarioAutenticado;
	}
}
