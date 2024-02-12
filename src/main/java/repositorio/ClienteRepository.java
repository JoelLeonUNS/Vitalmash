package repositorio;
import org.springframework.data.jpa.repository. JpaRepository;

import entidad.Cliente;
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
