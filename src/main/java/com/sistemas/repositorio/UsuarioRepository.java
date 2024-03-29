package com.sistemas.repositorio;

import org.springframework.data.jpa.repository. JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemas.entidad.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByNombreusuario(String nombreusuario);
	boolean existsByNombreusuario(String nombreusuario);
}
