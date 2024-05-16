package com.cineplanet.retocp24.repository;

import com.cineplanet.retocp24.entity.Pedidos;
import com.cineplanet.retocp24.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long> {
    List<Productos> findByNombreContainingAndPrecio(String nombre, Double precio);
}
