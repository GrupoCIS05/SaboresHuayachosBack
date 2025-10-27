package com.SaboresHuayachos.SaboresHuayachos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "zonas_reparto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ZonaReparto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zonas_reparto")
    private Integer idZonasReparto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provincia_id", nullable = false)
    @JsonIgnore
    private Provincia provincia;

    @Column(name = "codigo_zona", length = 20, nullable = false)
    private String codigoZona;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "cobertura", length = 500)
    private String cobertura;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 20)
    private EstadoZonaEnum estado;

    @OneToMany(mappedBy = "zonaReparto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Sucursal> sucursales;
}
