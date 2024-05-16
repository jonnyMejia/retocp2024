package com.cineplanet.retocp24.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductosTest {

    @Test
    void testClass(){
        Productos productos = new Productos();

        productos.setCodigo(1L);
        productos.setNombre("Producto 1");
        productos.setPrecio(10.0);

        Assertions.assertEquals(1L, productos.getCodigo());
        Assertions.assertEquals("Producto 1", productos.getNombre());
        Assertions.assertEquals(10.0, productos.getPrecio());
    }
}
