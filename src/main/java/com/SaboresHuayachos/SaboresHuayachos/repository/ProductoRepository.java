/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.repository;

import com.SaboresHuayachos.SaboresHuayachos.model.Categoria;
import com.SaboresHuayachos.SaboresHuayachos.model.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.*;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    List<Producto> findByDisponibleTrue();

    List<Producto> findByCategoriaAndDisponibleTrue(Categoria categoria);

    Page<Producto> findByDisponibleTrue(Pageable pageable);

    Page<Producto> findByCategoria_IdCategoriaAndDisponibleTrue(Integer categoriaId, Pageable pageable);

    Page<Producto> findByNombreContainingIgnoreCaseAndDisponibleTrue(String nombre, Pageable pageable);

    Page<Producto> findByCategoria_IdCategoriaAndNombreContainingIgnoreCaseAndDisponibleTrue(
            Integer categoriaId, String nombre, Pageable pageable);

}
