/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.service;
import com.SaboresHuayachos.SaboresHuayachos.model.Producto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
/**
 *
 * @author kevin
 */

public interface ProductoService {
    Producto registrar(Producto producto);
    Producto actualizar(Integer id, Producto producto);
    void cambiarEstado(Integer id, boolean disponible);
    List<Producto> listarActivos();
    Optional<Producto> obtenerPorId(Integer id);

    Page<Producto> listar(int page, int size, Integer categoriaId, String buscar); // 🔹 nuevo
}

