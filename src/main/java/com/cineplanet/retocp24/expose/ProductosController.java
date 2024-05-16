package com.cineplanet.retocp24.expose;

import com.cineplanet.retocp24.entity.Productos;
import com.cineplanet.retocp24.repository.impl.ProductosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Producto Management System", description = "Operations pertaining to product in Producto Management System")
@Slf4j
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @Operation(summary = "Ver una lista de productos disponibles", tags = { "Producto Management System" })
    @GetMapping
    public List<Productos> getAllProductos() {
        return productosService.findAll();
    }

    @Operation(summary = "Get a product by Id", description = "Get product by ID", tags = { "Producto Management System" })
    @GetMapping("/{id}")
    public ResponseEntity<Productos> getProductoById(@PathVariable Long id) {
        Optional<Productos> productos = productosService.findById(id);
        return productos.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Add a product", description = "Create a new product", tags = { "Producto Management System" })
    @PostMapping
    public Productos createProducto(@RequestBody Productos producto) {
        return productosService.save(producto);
    }

    @Operation(summary = "Update a product", description = "Update an existing product", tags = { "Producto Management System" })
    @PutMapping("/{id}")
    public ResponseEntity<Productos> updateProducto(@PathVariable Long id, @RequestBody Productos productoDetails) {
        Optional<Productos> producto = productosService.findById(id);
        if (producto.isPresent()) {
            Productos updatedProducto = producto.get();
            updatedProducto.setNombre(productoDetails.getNombre());
            updatedProducto.setPrecio(productoDetails.getPrecio());
            return ResponseEntity.ok(productosService.save(updatedProducto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete a product", description = "Delete a product by ID", tags = { "Producto Management System" })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        if (productosService.findById(id).isPresent()) {
            productosService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
