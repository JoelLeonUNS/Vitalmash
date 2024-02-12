package servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entidad.Elaboracion;
import repositorio.ElaboracionRepository;

@Service
public class ElaboracionServiceImpl implements ElaboracionService{

	@Autowired
	private ElaboracionRepository elaboracionRepository;
	
	@Override
	public Elaboracion agregar(Elaboracion entidad) {
		// retorna la elaboracion con su PK generada
		return elaboracionRepository.save(entidad);
	}

	@Override
	public List<Elaboracion> listarTodos() {
		// retorna la lista de elaboracion
		return elaboracionRepository.findAll();
	}

	@Override
	public Elaboracion buscar(Long id) {
		Elaboracion encontrado = null;
		Optional<Elaboracion> buscado = elaboracionRepository.findById(id);
		if (buscado.isPresent()) {
			encontrado = buscado.get();
		}
		return encontrado;
	}

	@Override
	public Elaboracion actualizar(Elaboracion entidad) {
		return elaboracionRepository.save(entidad);
	}

	@Override
	public void eliminar(Long id) {
		elaboracionRepository.deleteById(id);		
	}
	
}
