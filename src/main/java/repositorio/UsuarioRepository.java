package repositorio;
import org.springframework.data.jpa.repository. JpaRepository;

import entidad.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
