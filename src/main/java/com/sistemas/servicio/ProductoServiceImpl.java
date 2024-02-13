package com.sistemas.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.sistemas.entidad.Producto;
import com.sistemas.repositorio.ProductoRepository;

public class ProductoServiceImpl implements ProductoService {
    @Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public Producto agregar(Producto entidad) {		
		return productoRepository.save(entidad);
	}

	@Override
	public List<Producto> listarTodos() {
		return productoRepository.findAll();
	}

	@Override
	public Producto buscar(Long id) {
		Producto encontrado = null;
		Optional<Producto> buscado = productoRepository.findById(id);
		
		if(buscado.isPresent()) {
			encontrado = buscado.get();
		}
		
		return encontrado;
	}

	@Override
	public Producto actualizar(Producto entidad) {
		return productoRepository.save(entidad);
	}

	@Override
	public void eliminar(Long id) {
		productoRepository.deleteById(id);
		
	}
}