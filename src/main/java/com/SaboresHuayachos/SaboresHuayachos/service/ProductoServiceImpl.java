/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.service;

import com.SaboresHuayachos.SaboresHuayachos.model.Producto;
import com.SaboresHuayachos.SaboresHuayachos.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author kevin
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto registrar(Producto producto) {
        producto.setDisponible(true);
        producto.setEstado(1);
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizar(Integer id, Producto productoActualizado) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setNombre(productoActualizado.getNombre());
        producto.setDescripcion(productoActualizado.getDescripcion());
        producto.setPrecioUnitario(productoActualizado.getPrecioUnitario());
        producto.setDescuento(productoActualizado.getDescuento());
        producto.setCategoria(productoActualizado.getCategoria());
        producto.setImagenUrl(productoActualizado.getImagenUrl());
        return productoRepository.save(producto);
    }

    @Override
    public void cambiarEstado(Integer id, boolean disponible) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setDisponible(disponible);
        productoRepository.save(producto);
    }

    @Override
    public List<Producto> listarActivos() {
        return productoRepository.findByDisponibleTrue();
    }

    @Override
    public Optional<Producto> obtenerPorId(Integer id) {
        return productoRepository.findById(id);
    }

    
    @Override
    public Page<Producto> listar(int page, int size, Integer categoriaId, String buscar) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("nombre").ascending());

        if (categoriaId != null && buscar != null && !buscar.isEmpty()) {
            return productoRepository.findByCategoria_IdCategoriaAndNombreContainingIgnoreCaseAndDisponibleTrue(
                    categoriaId, buscar, pageable);
        } else if (categoriaId != null) {
            return productoRepository.findByCategoria_IdCategoriaAndDisponibleTrue(categoriaId, pageable);
        } else if (buscar != null && !buscar.isEmpty()) {
            return productoRepository.findByNombreContainingIgnoreCaseAndDisponibleTrue(buscar, pageable);
        } else {
            return productoRepository.findByDisponibleTrue(pageable);
        }
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {

        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

}
