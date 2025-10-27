/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.rest;

/**
 *
 * @author kevin
 */

import com.SaboresHuayachos.SaboresHuayachos.service.ComprobanteService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comprobantes")
@CrossOrigin(origins = "http://localhost:4200")
public class ComprobanteRestController {

    @Autowired
    private ComprobanteService comprobanteService;

    @PutMapping("/pago/{idPago}/estado")
    public Map<String, Object> actualizarEstadoPago(@PathVariable Integer idPago, @RequestBody Map<String, String> body) {
        String estado = body.get("estado");
        return comprobanteService.actualizarEstadoPago(idPago, estado);
    }
}
