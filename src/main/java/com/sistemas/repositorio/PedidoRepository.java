package com.sistemas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemas.entidad.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
