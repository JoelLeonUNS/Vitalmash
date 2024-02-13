package com.sistemas.repositorio;

import org.springframework.data.jpa.repository. JpaRepository;

import com.sistemas.entidad.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}