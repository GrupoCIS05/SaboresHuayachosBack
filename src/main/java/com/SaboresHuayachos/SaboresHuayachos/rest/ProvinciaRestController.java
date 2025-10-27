/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.rest;

/**
 *
 * @author kevin
 */
import com.SaboresHuayachos.SaboresHuayachos.model.Provincia;
import com.SaboresHuayachos.SaboresHuayachos.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/provincias")
@CrossOrigin(origins = "http://localhost:4200")
public class ProvinciaRestController {

    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping
    public List<Provincia> listarProvincias() {
        return provinciaService.listarProvincias();
    }
}
