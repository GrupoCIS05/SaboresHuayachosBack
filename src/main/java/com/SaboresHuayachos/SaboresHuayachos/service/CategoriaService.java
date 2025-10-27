/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.service;

import com.SaboresHuayachos.SaboresHuayachos.model.Categoria;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author kevin
 */
public interface CategoriaService {

    Categoria registrar(Categoria categoria);

    Categoria actualizar(Integer id, Categoria categoria);

    void eliminar(Integer id);

    List<Categoria> listar();

    List<Categoria> listarEstadoActivo();

    Optional<Categoria> obtenerPorId(Integer id);

}
