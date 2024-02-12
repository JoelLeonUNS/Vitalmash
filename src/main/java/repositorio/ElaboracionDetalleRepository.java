package repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import entidad.ElaboracionDetalle;
import entidad.ElaboracionDetalleID;

public interface ElaboracionDetalleRepository extends JpaRepository<ElaboracionDetalle, ElaboracionDetalleID>{

}
