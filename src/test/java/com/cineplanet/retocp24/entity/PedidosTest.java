package com.cineplanet.retocp24.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PedidosTest {

    @Test
    void testClass(){
        Pedidos pedidos = new Pedidos();

        pedidos.setNroPedido(1L);
        pedidos.setCodigoProducto(1L);
        pedidos.setCantidad(1);

        Cliente cliente = new Cliente("Cliente Nombre", "Cliente Apellido");

        pedidos.setCliente(cliente);

        Assertions.assertEquals(1L, pedidos.getNroPedido());
        Assertions.assertEquals(1L, pedidos.getCodigoProducto());
        Assertions.assertEquals(1, pedidos.getCantidad());
        Assertions.assertNotNull(pedidos.getCliente());
    }
}
