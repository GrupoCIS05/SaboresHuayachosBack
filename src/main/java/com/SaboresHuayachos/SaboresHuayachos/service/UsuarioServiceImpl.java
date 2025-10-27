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
import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

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
    private ProvinciaRepository provinciaRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PedidoRepository pedidoRepository;

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

    @Override
    public List<Pedido> obtenerPedidosPorCliente(Integer idUsuario) {
        return pedidoRepository.findPedidosByUsuarioCliente(idUsuario);
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    @Transactional
    public Map<String, Object> actualizarDireccionUsuario(Map<String, Object> data) {
        Map<String, Object> response = new HashMap<>();

        try {
            Integer personaId = (Integer) data.get("personaId");
            String direccion = (String) data.get("direccion");
            String telefono = (String) data.get("telefono");
            Integer sucursalId = (Integer) data.get("sucursalId");

            if (personaId == null) {
                throw new RuntimeException("ID de la persona no proporcionado.");
            }

            Persona persona = personaRepository.findById(personaId)
                    .orElseThrow(() -> new RuntimeException("Persona no encontrada con ID: " + personaId));

            if (direccion != null && !direccion.trim().isEmpty()) {
                persona.setDireccion(direccion);
            }
            if (telefono != null && !telefono.trim().isEmpty()) {
                persona.setTelefono(telefono);
            }
            personaRepository.save(persona);

            Usuario usuario = usuarioRepository.findByPersonaId(personaId)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con persona ID: " + personaId));

            if (sucursalId != null) {
                Sucursal sucursal = sucursalRepository.findById(sucursalId)
                        .orElseThrow(() -> new RuntimeException("Sucursal no encontrada con ID: " + sucursalId));
                usuario.setSucursal(sucursal);
                usuarioRepository.save(usuario);
            }

            response.put("success", true);
            response.put("message", "Dirección actualizada correctamente.");
            response.put("persona", persona);
            response.put("usuario", usuario);

        } catch (RuntimeException e) {
            response.put("success", false);
            response.put("message", "Error al actualizar la dirección: " + e.getMessage());
        }

        return response;
    }

}
