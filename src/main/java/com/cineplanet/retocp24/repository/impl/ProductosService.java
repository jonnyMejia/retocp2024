package com.cineplanet.retocp24.repository.impl;

import com.cineplanet.retocp24.entity.Productos;
import com.cineplanet.retocp24.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosService {

    @Autowired
    private ProductosRepository productoRepository;

    public List<Productos> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Productos> findById(Long id) {
        return productoRepository.findById(id);
    }

    public Productos save(Productos producto) {
        return productoRepository.save(producto);
    }

    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}