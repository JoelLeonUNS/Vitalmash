package servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import entidad.ProductoElaborado;
import repositorio.ProductoElaboradoRepository;

public class ProductoElaboradoServiceImpl implements ProductoElaboradoService {
    @Autowired
	private ProductoElaboradoRepository productoElaboradoRepository;
	
	@Override
	public ProductoElaborado agregar(ProductoElaborado entidad) {		
		return productoElaboradoRepository.save(entidad);
	}

	@Override
	public List<ProductoElaborado> listarTodos() {
		return productoElaboradoRepository.findAll();
	}

	@Override
	public ProductoElaborado buscar(Long id) {
		ProductoElaborado encontrado = null;
		Optional<ProductoElaborado> buscado = productoElaboradoRepository.findById(id);
		
		if(buscado.isPresent()) {
			encontrado = buscado.get();
		}
		
		return encontrado;
	}

	@Override
	public ProductoElaborado actualizar(ProductoElaborado entidad) {
		return productoElaboradoRepository.save(entidad);
	}

	@Override
	public void eliminar(Long id) {
		productoElaboradoRepository.deleteById(id);
		
	}
}

