/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

/**
 *
 * @author kevin
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pago")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer idPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metodo_pago_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private MetodoPago metodoPago;

    @Column(name = "estado_pago", length = 30)
    private String estadoPago;

    @Column(name = "monto_pagado")
    private Double montoPagado;

    @Column(name = "fecha_pago")
    private LocalDate fechaPago;

    @Column(name = "referencia_pago", length = 100)
    private String referenciaPago;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Pedido pedido;
}


