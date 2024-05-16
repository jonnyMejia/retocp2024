package com.cineplanet.retocp24.repository.impl;

import com.cineplanet.retocp24.entity.Cliente;
import com.cineplanet.retocp24.repository.ClienteRepository;
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

public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        Cliente cliente1 = new Cliente("John Doe", "Apellido", "");
        Cliente cliente2 = new Cliente("Jane Doe", "Apellido", "");
        List<Cliente> clientes = Arrays.asList(cliente1, cliente2);

        when(clienteRepository.findAll()).thenReturn(clientes);

        List<Cliente> result = clienteService.findAll();
        assertEquals(2, result.size());
        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Cliente cliente = new Cliente("John Doe", "Apellido", "");
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Optional<Cliente> result = clienteService.findById(1L);
        assertTrue(result.isPresent());
        assertEquals("John Doe", result.get().getNombre());
        verify(clienteRepository, times(1)).findById(1L);
    }

    @Test
    public void testSave() {
        Cliente cliente = new Cliente("John Doe", "Apellido", "");
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente result = clienteService.save(cliente);
        assertEquals("John Doe", result.getNombre());
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    public void testDeleteById() {
        clienteService.deleteById(1L);
        verify(clienteRepository, times(1)).deleteById(1L);
    }
}