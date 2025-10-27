/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.rest;

/**
 *
 * @author kevin
 */
import com.SaboresHuayachos.SaboresHuayachos.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthRestController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> data) {
        try {
            String correo = data.get("correo");
            String contrasena = data.get("contrasena");
            Map<String, Object> result = authService.login(correo, contrasena);
            if ("ok".equals(result.get("status"))) {
                return ResponseEntity.ok(result.get("usuario"));
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status", "error",
                    "mensaje", "Error interno en el servidor"
            ));
        }
    }

    @PostMapping("/recuperar")
    public Map<String, Object> recuperar(@RequestBody Map<String, String> data) {
        return authService.recuperarContrasena(data.get("correo"));
    }

    @PostMapping("/cambiar-clave")
    public Map<String, Object> cambiarClave(@RequestBody Map<String, String> data) {
        return authService.cambiarClave(data.get("correo"), data.get("nuevaClave"));
    }

    @GetMapping("/verificar-correo/{correo}")
    public boolean verificarCorreo(@PathVariable String correo) {
        return authService.verificarCorreo(correo);
    }

    @GetMapping("/verificar-documento")
    public boolean verificarDocumento(@RequestParam("tipo") String tipo, @RequestParam("numero") String numero) {
        return authService.verificarDocumento(tipo, numero);
    }
}
