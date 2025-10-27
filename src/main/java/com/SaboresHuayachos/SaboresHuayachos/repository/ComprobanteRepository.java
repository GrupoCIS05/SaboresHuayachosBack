/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.repository;

import com.SaboresHuayachos.SaboresHuayachos.model.Comprobante;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kevin
 */
public interface ComprobanteRepository extends JpaRepository<Comprobante, Integer> {
    Optional<Comprobante> findByPedidoIdPedido(Integer pedidoId);
}
