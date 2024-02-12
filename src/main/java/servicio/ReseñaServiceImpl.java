package servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import entidad.Reseña;
import repositorio.ReseñaRepository;

public class ReseñaServiceImpl implements ReseñaService{
	
	@Autowired
	private ReseñaRepository reseñaRepository;

	@Override
	public Reseña agregar(Reseña entidad) {
		return reseñaRepository.save(entidad);
	}

	@Override
	public List<Reseña> listarTodos() {
		return reseñaRepository.findAll();
	}

	@Override
	public Reseña buscar(Long id) {
		Reseña encontrado = null;
		Optional<Reseña> buscado = reseñaRepository.findById(id);
		if (buscado.isPresent()) {
			encontrado = buscado.get();
		}
		return encontrado;
	}
	@Override
	public Reseña actualizar(Reseña entidad) {
		return reseñaRepository.save(entidad);
	}

	@Override
	public void eliminar(Long id) {
		reseñaRepository.deleteById(id);
	}
}
