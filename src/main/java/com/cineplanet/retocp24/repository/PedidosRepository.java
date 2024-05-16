package com.cineplanet.retocp24.repository;

import com.cineplanet.retocp24.entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
    List<Pedidos> findByCantidadAndClienteId(Integer cantidad, Long clienteId);
}
