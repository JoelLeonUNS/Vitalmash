package com.sistemas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemas.entidad.Descuento;

public interface DescuentoRepository extends JpaRepository<Descuento, Long> {

}