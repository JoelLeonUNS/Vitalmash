package com.sistemas.repositorio;

import org.springframework.data.jpa.repository. JpaRepository;
import com.sistemas.entidad.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
