/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.service;

/**
 *
 * @author kevin
 */
import java.util.List;
import com.SaboresHuayachos.SaboresHuayachos.model.ZonaReparto;

public interface ZonaRepartoService {

    List<ZonaReparto> listarPorProvincia(Integer idProvincia);
}
