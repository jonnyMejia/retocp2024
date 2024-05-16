package com.cineplanet.retocp24.expose;

import com.cineplanet.retocp24.entity.Productos;
import com.cineplanet.retocp24.repository.impl.ProductosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Producto Management API", description = "Operaciones relativas al producto en Producto Management API")
@Slf4j
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @Operation(summary = "Ver lista de productos disponibles", tags = { "Producto Management API" })
    @GetMapping
    public List<Productos> getAllProductos() {
        return productosService.findAll();
    }


    @GetMapping("/paged")
    public ResponseEntity<Page<Productos>> getAllProductos(Pageable pageable) {
        Page<Productos> productos = productosService.findAll(pageable);
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Productos>> searchProductos(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Double precio) {
        List<Productos> productos = productosService.searchProductos(nombre, precio);
        return ResponseEntity.ok(productos);
    }

    @Operation(summary = "Obtener un producto por ID", description = "Obtener un producto por ID", tags = { "Producto Management API" })
    @GetMapping("/{id}")
    public ResponseEntity<Productos> getProductoById(@PathVariable Long id) {
        Optional<Productos> productos = productosService.findById(id);
        return productos.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Agregar un producto", description = "Crea un nuevo producto", tags = { "Producto Management API" })
    @PostMapping
    public Productos createProducto(@RequestBody Productos producto) {
        return productosService.save(producto);
    }

    @Operation(summary = "Actualizar un producto", description = "Actualiza un producto existente", tags = { "Producto Management API" })
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

    @Operation(summary = "Elimina un producto", description = "Elimina un producto por ID", tags = { "Producto Management API" })
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
