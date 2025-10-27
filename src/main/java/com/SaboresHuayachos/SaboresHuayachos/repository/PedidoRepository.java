package com.SaboresHuayachos.SaboresHuayachos.repository;

import com.SaboresHuayachos.SaboresHuayachos.model.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByUsuarioPersonaId(Integer personaId);

    List<Pedido> findByUsuarioCorreo(String correo);
}

