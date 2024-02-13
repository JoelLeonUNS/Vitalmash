package com.sistemas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemas.entidad.ElaboracionDetalle;
import com.sistemas.entidad.ElaboracionDetalleID;

public interface ElaboracionDetalleRepository extends JpaRepository<ElaboracionDetalle, ElaboracionDetalleID>{

}
