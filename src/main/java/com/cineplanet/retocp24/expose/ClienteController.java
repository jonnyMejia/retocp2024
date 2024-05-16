package com.cineplanet.retocp24.expose;

import com.cineplanet.retocp24.entity.Cliente;
import com.cineplanet.retocp24.repository.impl.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Cliente Management System", description = "Operations pertaining to client in Cliente Management System")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "View a list of available clients", description = "Get all clients", tags = { "Cliente Management System" })
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.findAll();
    }

    @Operation(summary = "View a list of available clients paged", description = "Get all clients", tags = { "Cliente Management System" })
    @GetMapping("/paged")
    public ResponseEntity<Page<Cliente>> getAllClientes(Pageable pageable) {
        Page<Cliente> clientes = clienteService.findAll(pageable);
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Cliente>> searchClientes(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellido,
            @RequestParam(required = false) String direccion) {
        List<Cliente> clientes = clienteService.searchClientes(nombre, apellido, direccion);
        return ResponseEntity.ok(clientes);
    }

    @Operation(summary = "Get a client by Id", description = "Get client by ID", tags = { "Cliente Management System" })
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.findById(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Add a client", description = "Create a new client", tags = { "Cliente Management System" })
    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @Operation(summary = "Update a client", description = "Update an existing client", tags = { "Cliente Management System" })
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetails) {
        Optional<Cliente> cliente = clienteService.findById(id);
        if (cliente.isPresent()) {
            Cliente updatedCliente = cliente.get();
            updatedCliente.setNombre(clienteDetails.getNombre());
            updatedCliente.setApellido(clienteDetails.getApellido());
            return ResponseEntity.ok(clienteService.save(updatedCliente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete a client", description = "Delete a client by ID", tags = { "Cliente Management System" })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        if (clienteService.findById(id).isPresent()) {
            clienteService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}