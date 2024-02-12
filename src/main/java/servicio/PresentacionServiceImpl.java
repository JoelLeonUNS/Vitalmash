package servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import entidad.Presentacion;
import repositorio.PresentacionRepository;

public class PresentacionServiceImpl implements PresentacionService {

	@Autowired
	private PresentacionRepository presentacionRepository;
	
	@Override
	public Presentacion agregar(Presentacion entidad) {
		return presentacionRepository.save(entidad);
	}

	@Override
	public List<Presentacion> listarTodos() {
		return presentacionRepository.findAll();
	}

	@Override
	public Presentacion buscar(Long id) {
		Presentacion encontrado = null;
		Optional<Presentacion> buscado = presentacionRepository.findById(id);
		if(buscado.isPresent()) {
			encontrado = buscado.get();
		}	
		return encontrado;
	}

	@Override
	public Presentacion actualizar(Presentacion entidad) {
		return presentacionRepository.save(entidad);
	}

	@Override
	public void eliminar(Long id) {
		presentacionRepository.deleteById(id);
	}
}
