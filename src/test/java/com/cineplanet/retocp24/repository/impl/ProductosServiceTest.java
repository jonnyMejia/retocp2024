package com.cineplanet.retocp24.repository.impl;

import com.cineplanet.retocp24.entity.Productos;
import com.cineplanet.retocp24.repository.ProductosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ProductosServiceTest {

    @Mock
    private ProductosRepository productoRepository;

    @InjectMocks
    private ProductosService productoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        Productos producto1 = new Productos("Productos 1", 100.00);
        Productos producto2 = new Productos("Productos 2", 200.00);
        List<Productos> productos = Arrays.asList(producto1, producto2);

        when(productoRepository.findAll()).thenReturn(productos);

        List<Productos> result = productoService.findAll();
        assertEquals(2, result.size());
        verify(productoRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Productos producto = new Productos("Productos 1", 100.00);
        when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));

        Optional<Productos> result = productoService.findById(1L);
        assertTrue(result.isPresent());
        assertEquals("Productos 1", result.get().getNombre());
        verify(productoRepository, times(1)).findById(1L);
    }

    @Test
    public void testSave() {
        Productos producto = new Productos("Productos 1", 100.00);
        when(productoRepository.save(producto)).thenReturn(producto);

        Productos result = productoService.save(producto);
        assertEquals("Productos 1", result.getNombre());
        verify(productoRepository, times(1)).save(producto);
    }

    @Test
    public void testDeleteById() {
        productoService.deleteById(1L);
        verify(productoRepository, times(1)).deleteById(1L);
    }
}