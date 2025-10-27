/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.service;

/**
 *
 * @author kevin
 */

import com.SaboresHuayachos.SaboresHuayachos.model.Pago;
import com.SaboresHuayachos.SaboresHuayachos.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ComprobanteServiceImpl implements ComprobanteService {

    @Autowired
    private PagoRepository pagoRepository;

    @Override
    public Map<String, Object> actualizarEstadoPago(Integer idPago, String estado) {
        Map<String, Object> resp = new HashMap<>();

        try {
            Pago pago = pagoRepository.findById(idPago).orElse(null);

            if (pago == null) {
                resp.put("status", "error");
                resp.put("mensaje", "El pago no existe.");
                return resp;
            }

            pago.setEstadoPago(estado);
            pagoRepository.save(pago);

            resp.put("status", "ok");
            resp.put("mensaje", "Estado de pago actualizado correctamente.");
            resp.put("pago", pago);
        } catch (Exception e) {
            resp.put("status", "error");
            resp.put("mensaje", "Error al actualizar estado de pago: " + e.getMessage());
        }

        return resp;
    }
}

