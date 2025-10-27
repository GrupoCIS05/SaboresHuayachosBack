/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.repository;



/**
 *
 * @author kevin
 */
import com.SaboresHuayachos.SaboresHuayachos.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
    @Query("SELECT s FROM Sucursal s WHERE s.zonaReparto.idZonasReparto = :idZona")
    List<Sucursal> findByZonaRepartoId(@Param("idZona") Integer idZona);
}