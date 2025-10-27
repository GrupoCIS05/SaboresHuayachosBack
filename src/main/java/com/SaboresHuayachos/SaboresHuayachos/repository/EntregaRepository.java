/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.repository;

import com.SaboresHuayachos.SaboresHuayachos.model.Entrega;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kevin
 */
public interface EntregaRepository extends JpaRepository<Entrega, Integer> {
    List<Entrega> findByRepartidorPersonaId(Integer personaId);
    List<Entrega> findByTrabajadorPersonaId(Integer personaId);
    Entrega findByPedidoIdPedido(Integer pedidoId);
}
