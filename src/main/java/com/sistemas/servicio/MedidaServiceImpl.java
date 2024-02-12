package com.sistemas.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.sistemas.entidad.Medida;
import com.sistemas.repositorio.MedidaRepository;

public class MedidaServiceImpl implements MedidaService {

	@Autowired
	private MedidaRepository medidaRepository;
	
	@Override
	public Medida agregar(Medida entidad) {
		return medidaRepository.save(entidad);
	}

	@Override
	public List<Medida> listarTodos() {
		return medidaRepository.findAll();
	}

	@Override
	public Medida buscar(Long id) {
		Medida encontrado = null;
		Optional<Medida> buscado = medidaRepository.findById(id);
		if(buscado.isPresent()) {
			encontrado = buscado.get();
		}
		return encontrado;
	}
	@Override
	public Medida actualizar(Medida entidad) {
		return medidaRepository.save(entidad);
	}

	@Override
	public void eliminar(Long id) {
		medidaRepository.deleteById(id);
	}
}
