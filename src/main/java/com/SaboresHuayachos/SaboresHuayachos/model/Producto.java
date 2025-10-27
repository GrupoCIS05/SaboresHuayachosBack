package com.SaboresHuayachos.SaboresHuayachos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "producto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", nullable = false)

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "productos"})
    private Categoria categoria;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @Column(name = "descuento")
    private Double descuento;

    @Column(name = "imagen_url", length = 100)
    private String imagenUrl;

    @Column(name = "disponible", columnDefinition = "TINYINT(1)")
    private Boolean disponible;

    @Column(name = "estado")
    private Integer estado;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"producto"})
    private List<DetallePedido> detallesPedido;
}
