/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.repository;



/**
 *
 * @author kevin
 */

import com.SaboresHuayachos.SaboresHuayachos.model.ZonaReparto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ZonaRepartoRepository extends JpaRepository<ZonaReparto, Integer> {
     @Query("SELECT z FROM ZonaReparto z WHERE z.provincia.idProvincia = :idProvincia")
    List<ZonaReparto> findByProvinciaId(@Param("idProvincia") Integer idProvincia);
}

