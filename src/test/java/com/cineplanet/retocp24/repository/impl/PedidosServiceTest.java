package com.cineplanet.retocp24.repository.impl;

import com.cineplanet.retocp24.entity.Cliente;
import com.cineplanet.retocp24.entity.Pedidos;
import com.cineplanet.retocp24.repository.PedidosRepository;
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

public class PedidosServiceTest {

    @Mock
    private PedidosRepository pedidoRepository;

    @InjectMocks
    private PedidosService pedidoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        Cliente cliente = new Cliente("John Doe", "","john@example.com");
        Pedidos pedido1 = new Pedidos(1L, 10, cliente);
        Pedidos pedido2 = new Pedidos(2L, 20, cliente);
        List<Pedidos> pedidos = Arrays.asList(pedido1, pedido2);

        when(pedidoRepository.findAll()).thenReturn(pedidos);

        List<Pedidos> result = pedidoService.findAll();
        assertEquals(2, result.size());
        verify(pedidoRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Cliente cliente = new Cliente("John Doe", "","john@example.com");
        Pedidos pedido = new Pedidos(1L, 10, cliente);
        when(pedidoRepository.findById(1L)).thenReturn(Optional.of(pedido));

        Optional<Pedidos> result = pedidoService.findById(1L);
        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getCodigoProducto());
        verify(pedidoRepository, times(1)).findById(1L);
    }

    @Test
    public void testSave() {
        Cliente cliente = new Cliente("John Doe", "","john@example.com");
        Pedidos pedido = new Pedidos(1L, 10, cliente);
        when(pedidoRepository.save(pedido)).thenReturn(pedido);

        Pedidos result = pedidoService.save(pedido);
        assertEquals(1L, result.getCodigoProducto());
        verify(pedidoRepository, times(1)).save(pedido);
    }

    @Test
    public void testDeleteById() {
        pedidoService.deleteById(1L);
        verify(pedidoRepository, times(1)).deleteById(1L);
    }
}
