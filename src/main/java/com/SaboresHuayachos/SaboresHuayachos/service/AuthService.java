/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.service;

/**
 *
 * @author kevin
 */

import java.util.Map;

public interface AuthService {

    Map<String, Object> login(String correo, String contrasena);

    Map<String, Object> recuperarContrasena(String correo);

    Map<String, Object> cambiarClave(String correo, String nuevaClave);

    boolean verificarCorreo(String correo);

    boolean verificarDocumento(String tipo, String numero);
}
