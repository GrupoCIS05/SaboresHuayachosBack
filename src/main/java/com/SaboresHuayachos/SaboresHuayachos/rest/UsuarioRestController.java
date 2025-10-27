/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.rest;

/**
 *
 * @author kevin
 */
import com.SaboresHuayachos.SaboresHuayachos.model.Usuario;
import java.util.stream.Collectors;
import com.SaboresHuayachos.SaboresHuayachos.service.UsuarioService;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioRestController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrarCliente")
    public Map<String, Object> registrarCliente(@RequestBody Map<String, Object> data) {
        return usuarioService.registrarCliente(data);
    }

    @GetMapping("/{id}/pedidos")
    public List<Map<String, Object>> obtenerPedidos(@PathVariable Integer id) {
        return usuarioService.obtenerPedidosPorCliente(id)
                .stream()
                .map(p -> {
                    Map<String, Object> pedidoMap = new HashMap<>();
                    pedidoMap.put("idPedido", p.getIdPedido());
                    pedidoMap.put("fechaPedido", p.getFechaPedido());
                    pedidoMap.put("subtotal", p.getSubtotal());
                    pedidoMap.put("impuesto", p.getImpuesto());
                    pedidoMap.put("montoTotal", p.getMontoTotal());
                    pedidoMap.put("estadoPagoGlobal", p.getEstadoPagoGlobal());
                    return pedidoMap;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<Usuario> obtenerUsuarioPorId(@PathVariable Integer id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @PutMapping("/actualizar-direccion")
    public ResponseEntity<Map<String, Object>> actualizarDireccion(@RequestBody Map<String, Object> data) {
        System.out.println(data);
        Map<String, Object> response = usuarioService.actualizarDireccionUsuario(data);
        return ResponseEntity.ok(response);
    }

}
