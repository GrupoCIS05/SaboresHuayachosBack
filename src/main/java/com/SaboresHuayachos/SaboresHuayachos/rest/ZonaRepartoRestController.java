/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.rest;

/**
 *
 * @author kevin
 */
import com.SaboresHuayachos.SaboresHuayachos.model.ZonaReparto;
import com.SaboresHuayachos.SaboresHuayachos.service.ZonaRepartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/zonas")
@CrossOrigin(origins = "http://localhost:4200")
public class ZonaRepartoRestController {

    @Autowired
    private ZonaRepartoService zonaRepartoService;

    @GetMapping("/provincia/{idProvincia}")
    public List<ZonaReparto> listarPorProvincia(@PathVariable Integer idProvincia) {
        return zonaRepartoService.listarPorProvincia(idProvincia);
    }
}
