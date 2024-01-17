package com.infuse.pedidos.infose.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.infuse.pedidos.infose.model.Pedido;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByNumeroControle(String numeroControle);
    List<Pedido> findByDataCadastro(LocalDate dataCadastro);
    boolean existsByNumeroControle(String numeroControle);
}


