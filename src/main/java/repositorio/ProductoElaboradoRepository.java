package repositorio;

import org.springframework.data.jpa.repository. JpaRepository;

import entidad.ProductoElaborado;

public interface ProductoElaboradoRepository extends JpaRepository<ProductoElaborado, Long>{
    
}
