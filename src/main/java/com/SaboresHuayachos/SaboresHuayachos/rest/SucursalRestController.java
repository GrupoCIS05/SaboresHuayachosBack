package com.SaboresHuayachos.SaboresHuayachos.rest;

import com.SaboresHuayachos.SaboresHuayachos.model.Sucursal;
import com.SaboresHuayachos.SaboresHuayachos.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sucursales")
@CrossOrigin(origins = "http://localhost:4200")
public class SucursalRestController {

    @Autowired
    private SucursalRepository sucursalRepository;

    @GetMapping("/zona/{idZona}")
    public List<Sucursal> getSucursalesPorZona(@PathVariable Integer idZona) {
        return sucursalRepository.findByZonaRepartoId(idZona);
    }
}

