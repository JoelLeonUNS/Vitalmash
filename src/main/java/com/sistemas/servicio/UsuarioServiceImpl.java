package com.sistemas.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.entidad.Usuario;
import com.sistemas.repositorio.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario agregar(Usuario entidad) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(entidad);
	}

	@Override
	public List<Usuario> listarTodos() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario buscar(Long id) {
		Usuario encontrado = null;
		Optional<Usuario> buscado = usuarioRepository.findById(id);
		
		if(buscado.isPresent()) {
			encontrado = buscado.get();
		}
		
		return encontrado;
	}

	@Override
	public Usuario actualizar(Usuario entidad) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(entidad);
	}

	@Override
	public void eliminar(Long id) {
		usuarioRepository.deleteById(id);
		
	}
}
