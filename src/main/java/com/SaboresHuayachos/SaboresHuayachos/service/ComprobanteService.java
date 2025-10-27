/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.service;

/**
 *
 * @author kevin
 */
import java.util.Map;

public interface ComprobanteService {
    Map<String, Object> actualizarEstadoPago(Integer idPago, String estado);
}
