package com.sistemas.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.entidad.Descuento;
import com.sistemas.repositorio.DescuentoRepository;

@Service
public class DescuentoServiceImpl implements DescuentoService{
	@Autowired
	private DescuentoRepository descuentoRepository;

	@Override
	public Descuento agregar(Descuento entidad) {
		// retorna el descuento con su PK generada
		return descuentoRepository.save(entidad);
	}

	@Override
	public List<Descuento> listarTodos() {
		// retorna la lista de descuentos
		return descuentoRepository.findAll();
	}

	@Override
	public Descuento buscar(Long id) {
		Descuento encontrado = null;
		Optional<Descuento> buscado = descuentoRepository.findById(id);
		
		if(buscado.isPresent()) {
			encontrado = buscado.get();
		}
		// retorna el descuento encontrado
		return encontrado;
	}

	@Override
	public Descuento actualizar(Descuento entidad) {
		// actualiza
		return descuentoRepository.save(entidad);
	}

	@Override
	public void eliminar(Long id) {
		// elimina
		descuentoRepository.deleteById(id);
		
	}
	
}
