package com.cineplanet.retocp24.repository;

import com.cineplanet.retocp24.entity.Cliente;
import com.cineplanet.retocp24.entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
