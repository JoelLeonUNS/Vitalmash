package servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entidad.ElaboracionDetalle;
import entidad.ElaboracionDetalleID;
import repositorio.ElaboracionDetalleRepository;

@Service
public class ElaboracionDetalleServiceImpl implements ElaboracionDetalleService{

	@Autowired
	private ElaboracionDetalleRepository elaboracionDetalleRepository;
	
	@Override
	public ElaboracionDetalle agregar(ElaboracionDetalle entidad) {
		return elaboracionDetalleRepository.save(entidad);
	}

	@Override
	public List<ElaboracionDetalle> listarTodos() {
		return elaboracionDetalleRepository.findAll();
	}

	@Override
	public ElaboracionDetalle buscar(ElaboracionDetalleID id) {
		return elaboracionDetalleRepository.findById(id).orElse(null);
	}

	@Override
	public ElaboracionDetalle actualizar(ElaboracionDetalle entidad) {
		return elaboracionDetalleRepository.save(entidad);
	}

	@Override
	public void eliminar(ElaboracionDetalleID id) {
		elaboracionDetalleRepository.deleteById(id);
	}
	
}
