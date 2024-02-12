package servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import entidad.Pedido;
import repositorio.PedidoRepository;

public class PedidoServiceImpl implements PedidoService{

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public Pedido agregar(Pedido entidad) {
		return pedidoRepository.save(entidad);
	}

	@Override
	public List<Pedido> listarTodos() {
		return pedidoRepository.findAll();
	}

	@Override
	public Pedido buscar(Long id) {
		return pedidoRepository.findById(id).orElse(null);
	}

	@Override
	public Pedido actualizar(Pedido entidad) {
		return pedidoRepository.save(entidad);
	}

	@Override
	public void eliminar(Long id) {
		pedidoRepository.deleteById(id);
	}

}
