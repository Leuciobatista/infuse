package com.infuse.pedidos.infose.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String numeroControle;
    private LocalDate dataCadastro;
    private String nome;
    private BigDecimal valor;
    private Integer quantidade;
    private Long codigoCliente;
    private BigDecimal valorTotal;

    public void setDataCadastro(LocalDate data) {
        this.dataCadastro = data;
    }
}
