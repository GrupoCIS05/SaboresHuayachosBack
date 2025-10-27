/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.service;

/**
 *
 * @author kevin
 */
import com.SaboresHuayachos.SaboresHuayachos.model.Pedido;
import com.SaboresHuayachos.SaboresHuayachos.model.Usuario;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UsuarioService {

    Map<String, Object> registrarCliente(Map<String, Object> data);

    List<Pedido> obtenerPedidosPorCliente(Integer idUsuario);

    Optional<Usuario> obtenerUsuarioPorId(Integer id);

    Map<String, Object> actualizarDireccionUsuario(Map<String, Object> data);
}
