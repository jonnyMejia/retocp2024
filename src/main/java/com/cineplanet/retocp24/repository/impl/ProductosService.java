package com.cineplanet.retocp24.repository.impl;

import com.cineplanet.retocp24.entity.Productos;
import com.cineplanet.retocp24.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Productos> findAll(Pageable pageable) {
        return productoRepository.findAll(pageable);
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

    public List<Productos> searchProductos(String nombre, Double precio) {
        // Implementar lógica de búsqueda personalizada aquí
        // Por ejemplo, utilizando métodos de consulta personalizados en el repositorio
        return productoRepository.findByNombreContainingAndPrecio(
                nombre != null ? nombre : "",
                precio != null ? precio : 0.0
        );
    }
}