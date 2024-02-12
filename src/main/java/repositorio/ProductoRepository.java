package repositorio;

import org.springframework.data.jpa.repository. JpaRepository;

import entidad.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}