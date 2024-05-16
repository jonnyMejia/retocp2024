package com.cineplanet.retocp24.repository.impl;

import com.cineplanet.retocp24.entity.Pedidos;
import com.cineplanet.retocp24.entity.Productos;
import com.cineplanet.retocp24.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<Pedidos> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedidos save(Pedidos pedido) {
        return pedidoRepository.save(pedido);
    }

    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }
}