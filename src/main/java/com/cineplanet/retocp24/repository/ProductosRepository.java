package com.cineplanet.retocp24.repository;

import com.cineplanet.retocp24.entity.Pedidos;
import com.cineplanet.retocp24.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long> {
}
