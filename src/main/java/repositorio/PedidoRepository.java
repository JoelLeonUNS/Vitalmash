package repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import entidad.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
