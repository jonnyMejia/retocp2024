package com.cineplanet.retocp24.expose;

import com.cineplanet.retocp24.entity.Pedidos;
import com.cineplanet.retocp24.entity.Pedidos;
import com.cineplanet.retocp24.repository.impl.PedidosService;
import com.cineplanet.retocp24.repository.impl.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @GetMapping
    public List<Pedidos> getAllPedidoss() {
        return pedidosService.findAll();
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