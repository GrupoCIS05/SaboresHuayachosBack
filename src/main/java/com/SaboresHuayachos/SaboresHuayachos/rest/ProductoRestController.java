/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.rest;

/**
 *
 * @author kevin
 */
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.SaboresHuayachos.SaboresHuayachos.model.Producto;
import com.SaboresHuayachos.SaboresHuayachos.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoRestController {

    @Autowired
    private ProductoService productoService;


    @GetMapping("/activos")
    public ResponseEntity<List<Producto>> listarActivos() {
        return ResponseEntity.ok(productoService.listarActivos());
    }


    @GetMapping
    public ResponseEntity<Page<Producto>> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size,
            @RequestParam(required = false) Integer categoriaId,
            @RequestParam(required = false) String buscar
    ) {
        Page<Producto> productos = productoService.listar(page, size, categoriaId, buscar);
        return ResponseEntity.ok(productos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Integer id) {
        return productoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Producto> registrar(@RequestBody Producto producto) {
        Producto nuevo = productoService.registrar(producto);
        return ResponseEntity.ok(nuevo);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Integer id, @RequestBody Producto producto) {
        Producto actualizado = productoService.actualizar(id, producto);
        return ResponseEntity.ok(actualizado);
    }


    @PatchMapping("/{id}/estado")
    public ResponseEntity<Void> cambiarEstado(@PathVariable Integer id, @RequestParam boolean disponible) {
        productoService.cambiarEstado(id, disponible);
        return ResponseEntity.noContent().build();
    }
}
