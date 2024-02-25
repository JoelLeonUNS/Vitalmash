package com.sistemas.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.entidad.Categoria;
import com.sistemas.repositorio.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public Categoria agregar(Categoria entidad) {
		return categoriaRepository.save(entidad);
	}

	@Override
	public List<Categoria> listarTodos() {
		return categoriaRepository.findAll();
	}

	@Override
	public Categoria buscar(Long id) {
		Categoria encontrado = null;
		Optional<Categoria> buscado = categoriaRepository.findById(id);
		if (buscado.isPresent()) {
			encontrado = buscado.get();
		}
		return encontrado;
	}

	@Override
	public Categoria actualizar(Categoria entidad) {
		return categoriaRepository.save(entidad);
	}

	@Override
	public void eliminar(Long id) {
		categoriaRepository.deleteById(id);
	}
}
