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
@Table(name = "historial_estado_pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistorialEstadoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_pedido")
    private Integer idEstadoPedido;

    @Enumerated(EnumType.STRING)
    private EstadoPedidoEnum estado;

    @Column(name = "fecha_estado")
    private LocalDateTime fechaEstado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;
}
