package com.cineplanet.retocp24.repository.impl;

import com.cineplanet.retocp24.entity.Pedidos;
import com.cineplanet.retocp24.entity.Productos;
import com.cineplanet.retocp24.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidoRepository;

    public List<Pedidos> findAll() {
        return pedidoRepository.findAll();
    }
    public Page<Pedidos> findAll(Pageable pageable) {
        return pedidoRepository.findAll(pageable);
    }

    public Optional<Pedidos> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedidos save(Pedidos pedido) {
        return pedidoRepository.save(pedido);
    }

    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }

    public List<Pedidos> searchPedidos(Integer cantidad, Long clienteId) {
        // Implementar lógica de búsqueda personalizada aquí
        // Por ejemplo, utilizando métodos de consulta personalizados en el repositorio
        return pedidoRepository.findByCantidadAndClienteId(
                cantidad != null ? cantidad : 0,
                clienteId != null ? clienteId : 0L
        );
    }
}