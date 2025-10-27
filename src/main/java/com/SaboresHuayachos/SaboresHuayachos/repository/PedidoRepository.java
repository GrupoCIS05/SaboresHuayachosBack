package com.SaboresHuayachos.SaboresHuayachos.repository;

import com.SaboresHuayachos.SaboresHuayachos.model.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

       @Query("""
        SELECT p
        FROM Pedido p
        WHERE p.usuario.personaId = :idUsuario
          AND LOWER(p.usuario.rol) = 'cliente'
        ORDER BY p.fechaPedido DESC
    """)
    List<Pedido> findPedidosByUsuarioCliente(@Param("idUsuario") Integer idUsuario);

    List<Pedido> findByUsuarioPersonaId(Integer personaId);

    List<Pedido> findByUsuarioCorreo(String correo);
}
