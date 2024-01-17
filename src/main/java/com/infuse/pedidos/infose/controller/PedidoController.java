package com.infuse.pedidos.infose.controller;

import com.infuse.pedidos.infose.model.Pedido;
import com.infuse.pedidos.infose.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<?> criarPedidos(@RequestBody List<Pedido> pedidos) throws Exception {
        if (pedidos.size() > 10) {
            return ResponseEntity.badRequest().body("Não é permitido enviar mais de 10 pedidos por vez.");
        }

        List<Pedido> pedidosSalvos = pedidoService.salvarPedidos(pedidos);
        return ResponseEntity.ok(pedidosSalvos);
    }
    @GetMapping("/buscarPorNumeroControle")
    public List<Pedido> buscarPorNumeroControle(@RequestParam String numeroControle) {
        return pedidoService.buscarPorNumeroControle(numeroControle);
    }
    @GetMapping("/buscarPorDataCadastro")
    public List<Pedido> buscarPorDataCadastro(@RequestParam String dataCadastro) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(dataCadastro, formatter);
        return pedidoService.buscarPorDataCadastro(date);
    }
    @GetMapping("/todos")
    public List<Pedido> buscarTodosPedidos() {
        return pedidoService.buscarTodosPedidos();
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}

