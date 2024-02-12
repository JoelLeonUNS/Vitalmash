package repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import entidad.PedidoDetalle;

public interface PedidoDetalleRepository extends JpaRepository<PedidoDetalle, Long> {

}
