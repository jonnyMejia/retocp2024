package com.cineplanet.retocp24.expose;

import com.cineplanet.retocp24.entity.Pedidos;
import com.cineplanet.retocp24.entity.Pedidos;
import com.cineplanet.retocp24.repository.impl.PedidosService;
import com.cineplanet.retocp24.repository.impl.PedidosService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
@Tag(name = "Pedido Management System", description = "Operations pertaining to order in Pedido Management System")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @GetMapping
    public List<Pedidos> getAllPedidoss() {
        return pedidosService.findAll();
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<Pedidos>> getAllPedidos(Pageable pageable) {
        Page<Pedidos> pedidos = pedidosService.findAll(pageable);
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Pedidos>> searchPedidos(
            @RequestParam(required = false) Integer cantidad,
            @RequestParam(required = false) Long clienteId) {
        List<Pedidos> pedidos = pedidosService.searchPedidos(cantidad, clienteId);
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedidos> getPedidosById(@PathVariable Long id) {
        Optional<Pedidos> pedido = pedidosService.findById(id);
        return pedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pedidos createPedidos(@RequestBody Pedidos pedido) {
        return pedidosService.save(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedidos> updatePedidos(@PathVariable Long id, @RequestBody Pedidos pedidoDetails) {
        Optional<Pedidos> pedido = pedidosService.findById(id);
        if (pedido.isPresent()) {
            Pedidos updatedPedidos = pedido.get();
            updatedPedidos.setCodigoProducto(pedidoDetails.getCodigoProducto());
            updatedPedidos.setCantidad(pedidoDetails.getCantidad());
            updatedPedidos.setCliente(pedidoDetails.getCliente());
            return ResponseEntity.ok(pedidosService.save(updatedPedidos));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedidos(@PathVariable Long id) {
        if (pedidosService.findById(id).isPresent()) {
            pedidosService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}