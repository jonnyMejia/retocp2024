package com.cineplanet.retocp24.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    @Test
    void testClass(){

        Cliente cliente = new Cliente();

        cliente.setNombre("Cliente Nombre");
        cliente.setApellido("Cliente Apellido");

        Assertions.assertEquals("Cliente Nombre", cliente.getNombre());
        Assertions.assertEquals("Cliente Apellido", cliente.getApellido());
    }
}
