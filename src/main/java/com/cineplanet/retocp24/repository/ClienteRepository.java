package com.cineplanet.retocp24.repository;

import com.cineplanet.retocp24.entity.Cliente;
import com.cineplanet.retocp24.entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNombreContainingAndApellidoContainingAndDireccionContaining(String nombre, String apellido, String direccion);
}
