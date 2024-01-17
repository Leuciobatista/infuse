package com.infuse.pedidos.infose.service;

import com.infuse.pedidos.infose.model.Pedido;
import com.infuse.pedidos.infose.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional
    public List<Pedido> salvarPedidos(List<Pedido> pedidos) throws Exception {
        for (Pedido pedido : pedidos) {
            if (pedidoRepository.existsByNumeroControle(pedido.getNumeroControle())) {
                throw new Exception("Número de controle já cadastrado: " + pedido.getNumeroControle());
            }
            prepararPedido(pedido);
        }
        return pedidos.stream().map(pedidoRepository::save).collect(Collectors.toList());
    }
    public List<Pedido> buscarPorNumeroControle(String numeroControle) {
        return pedidoRepository.findByNumeroControle(numeroControle);
    }
    public List<Pedido> buscarPorDataCadastro(LocalDate dataCadastro) {
        return pedidoRepository.findByDataCadastro(dataCadastro);
    }
    public List<Pedido> buscarTodosPedidos() {
        return pedidoRepository.findAll();
    }
    public void prepararPedido(Pedido pedido) {
        definirDataCadastro(pedido);
        definirQuantidadePadrao(pedido);
        calcularValorTotal(pedido);
    }

    private void definirDataCadastro(Pedido pedido) {
        if (pedido.getDataCadastro() == null) {
            pedido.setDataCadastro(LocalDate.now());
        }
    }

    private void definirQuantidadePadrao(Pedido pedido) {
        if (pedido.getQuantidade() == null) {
            pedido.setQuantidade(1);
        }
    }

    private void calcularValorTotal(Pedido pedido) {
        BigDecimal valor = pedido.getValor();
        Integer quantidade = pedido.getQuantidade();
        if (valor != null && quantidade != null) {
            BigDecimal valorTotal = valor.multiply(BigDecimal.valueOf(quantidade));
            pedido.setValorTotal(aplicarDesconto(valorTotal, quantidade));
        } else {
            pedido.setValorTotal(BigDecimal.ZERO);
        }
    }

    private BigDecimal aplicarDesconto(BigDecimal valorTotal, int quantidade) {
        if (quantidade > 5 && quantidade < 10) {
            return valorTotal.multiply(BigDecimal.valueOf(0.95)); // Desconto de 5%
        } else if (quantidade >= 10) {
            return valorTotal.multiply(BigDecimal.valueOf(0.90)); // Desconto de 10%
        }
        return valorTotal;
    }

}
