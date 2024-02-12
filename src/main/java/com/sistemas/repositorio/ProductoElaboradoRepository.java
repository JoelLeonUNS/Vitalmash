package com.sistemas.repositorio;

import org.springframework.data.jpa.repository. JpaRepository;

import com.sistemas.entidad.ProductoElaborado;

public interface ProductoElaboradoRepository extends JpaRepository<ProductoElaborado, Long>{
    
}
