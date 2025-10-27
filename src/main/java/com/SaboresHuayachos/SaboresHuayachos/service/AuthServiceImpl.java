/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.service;

/**
 *
 * @author kevin
 */
import com.SaboresHuayachos.SaboresHuayachos.model.Usuario;
import com.SaboresHuayachos.SaboresHuayachos.repository.PersonaRepository;
import com.SaboresHuayachos.SaboresHuayachos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Map<String, Object> login(String correo, String contrasena) {
        Map<String, Object> resp = new HashMap<>();

        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreoIgnoreCase(correo);

        if (usuarioOpt.isEmpty()) {
            resp.put("status", "error");
            resp.put("mensaje", "Correo no registrado");
            return resp;
        }

        Usuario usuario = usuarioOpt.get();
        if (!passwordEncoder.matches(contrasena, usuario.getContrasena())) {
            resp.put("status", "error");
            resp.put("mensaje", "Contraseña incorrecta");
            return resp;
        }
        resp.put("status", "ok");
        resp.put("usuario", usuario);
        System.out.println(resp);
        return resp;
    }

    @Override
    public Map<String, Object> recuperarContrasena(String correo) {
        Map<String, Object> resp = new HashMap<>();
        Optional<Usuario> usuario = usuarioRepository.findByCorreoIgnoreCase(correo);

        if (usuario.isPresent()) {
            resp.put("status", "ok");
            resp.put("mensaje", "Se ha enviado un enlace de recuperación al correo (simulado)");
        } else {
            resp.put("status", "error");
            resp.put("mensaje", "El correo no está registrado");
        }
        return resp;
    }

    @Override
    public Map<String, Object> cambiarClave(String correo, String nuevaClave) {
        Map<String, Object> resp = new HashMap<>();
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreoIgnoreCase(correo);

        if (usuarioOpt.isEmpty()) {
            resp.put("status", "error");
            resp.put("mensaje", "Usuario no encontrado");
            return resp;
        }

        Usuario usuario = usuarioOpt.get();
        usuario.setContrasena(passwordEncoder.encode(nuevaClave));
        usuario.setCambioContrasena(1);
        usuarioRepository.save(usuario);

        resp.put("status", "ok");
        resp.put("mensaje", "Contraseña actualizada correctamente");
        return resp;
    }

    @Override
    public boolean verificarCorreo(String correo) {
        return usuarioRepository.existsByCorreo(correo);
    }

    @Override
    public boolean verificarDocumento(String tipo, String numero) {
        return personaRepository.existsByTipoDocumentoAndNumeroDocumento(tipo, numero);
    }
}
