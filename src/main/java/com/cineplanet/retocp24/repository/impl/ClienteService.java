package com.cineplanet.retocp24.repository.impl;

import com.cineplanet.retocp24.entity.Cliente;
import com.cineplanet.retocp24.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
    public Page<Cliente> findAll(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
    public List<Cliente> searchClientes(String nombre, String apellido, String direccion) {
        // Implementar lógica de búsqueda personalizada aquí
        // Por ejemplo, utilizando métodos de consulta personalizados en el repositorio
        return clienteRepository.findByNombreContainingAndApellidoContainingAndDireccionContaining(
                nombre != null ? nombre : "",
                apellido != null ? apellido : "",
                direccion != null ? direccion : ""
        );
    }
}
