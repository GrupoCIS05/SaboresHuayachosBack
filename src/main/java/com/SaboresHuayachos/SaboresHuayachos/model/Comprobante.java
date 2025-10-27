/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaboresHuayachos.SaboresHuayachos.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 *
 * @author kevin
 */

@Entity
@Table(name = "comprobante")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comprobante")
    private Integer idComprobante;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id", nullable = false, unique = true)
    private Pedido pedido;

    @Column(name = "tipo_comprobante", length = 20, nullable = false)
    private String tipoComprobante;

    @Column(name = "serie", length = 4)
    private String serie;

    @Column(name = "numero_comprobante", length = 20)
    private String numeroComprobante;

    @Column(name = "fecha_emision")
    private LocalDateTime fechaEmision;

    @Enumerated(EnumType.STRING)
    @Column(name = "moneda", length = 3)
    private MonedaEnum moneda;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "igv")
    private Double igv;

    @Column(name = "total")
    private Double total;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "archivo_pdf_url", length = 500)
    private String archivoPdfUrl;

    @Column(name = "observaciones", length = 500)
    private String observaciones;
}
