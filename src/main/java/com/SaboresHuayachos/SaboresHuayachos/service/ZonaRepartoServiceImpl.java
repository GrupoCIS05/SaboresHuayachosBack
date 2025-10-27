/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.service;

/**
 *
 * @author kevin
 */

import com.SaboresHuayachos.SaboresHuayachos.model.ZonaReparto;
import com.SaboresHuayachos.SaboresHuayachos.repository.ZonaRepartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ZonaRepartoServiceImpl implements ZonaRepartoService {

    @Autowired
    private ZonaRepartoRepository zonaRepartoRepository;

    @Override
    public List<ZonaReparto> listarPorProvincia(Integer idProvincia) {
        return zonaRepartoRepository.findByProvinciaId(idProvincia);
    }
}

