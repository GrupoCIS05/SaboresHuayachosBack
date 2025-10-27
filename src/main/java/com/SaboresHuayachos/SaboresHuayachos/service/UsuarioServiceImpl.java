/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.service;

/**
 *
 * @author kevin
 */
import com.SaboresHuayachos.SaboresHuayachos.model.*;
import com.SaboresHuayachos.SaboresHuayachos.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

import java.time.LocalDate;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ContactoRepository contactoRepository;
    @Autowired
    private SucursalRepository sucursalRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, Object> registrarCliente(Map<String, Object> data) {
        Map<String, Object> resp = new HashMap<>();

        try {
  
            Persona persona = new Persona();
            persona.setNombre(data.get("nombre").toString());
            persona.setApellido(data.get("apellido").toString());
            persona.setTipoDocumento(data.get("tipoDocumento").toString());
            persona.setNumeroDocumento(data.get("numeroDocumento").toString());
            persona.setDireccion(data.get("direccion").toString());
            persona.setTelefono(data.get("telefono").toString());
            persona.setFechaRegistro(LocalDate.now());
            personaRepository.save(persona);

        
            Usuario usuario = new Usuario();
            usuario.setPersona(persona);
            usuario.setCorreo(data.get("correo").toString());
            usuario.setContrasena(passwordEncoder.encode("user123"));

            usuario.setRol("Cliente");
            usuario.setEstado(1);
            usuario.setCambioContrasena(0);

        
            if (data.get("sucursalId") != null) {
                Integer sucursalId = Integer.valueOf(data.get("sucursalId").toString());
                Sucursal sucursal = sucursalRepository.findById(sucursalId).orElse(null);
                usuario.setSucursal(sucursal);
            }

            usuarioRepository.save(usuario);

     
            Contacto contacto = new Contacto();
            contacto.setNombre(persona.getNombre() + " " + persona.getApellido());
            contacto.setTelefono(persona.getTelefono());
            contacto.setMensaje("Nuevo registro de cliente");
            contacto.setFechaEnvio(LocalDate.now());
            contactoRepository.save(contacto);

            resp.put("status", "ok");
            resp.put("mensaje", "Cliente registrado correctamente");
            resp.put("usuario", usuario);

        } catch (NumberFormatException e) {
            resp.put("status", "error");
            resp.put("mensaje", "Error al registrar cliente: " + e.getMessage());
        }

        return resp;
    }
}
