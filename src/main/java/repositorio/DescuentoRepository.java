package repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import entidad.Descuento;

public interface DescuentoRepository extends JpaRepository<Descuento, Long> {

}