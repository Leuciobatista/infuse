package com.infuse.pedidos.infose;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.infuse.pedidos.infose.model.Pedido;
import com.infuse.pedidos.infose.repository.PedidoRepository;
import com.infuse.pedidos.infose.service.PedidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class PedidoTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @InjectMocks
    private PedidoService pedidoService;

    private Pedido pedido;

    @BeforeEach
    void setUp() {
        pedido = new Pedido();
    }

    @Test
    void testSalvarPedido() throws Exception {
        Pedido pedido = new Pedido();
        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);

        List<Pedido> pedidosParaSalvar = Collections.singletonList(pedido);
        List<Pedido> savedPedidos = pedidoService.salvarPedidos(pedidosParaSalvar);

        assertNotNull(savedPedidos);
        assertFalse(savedPedidos.isEmpty());
        assertEquals(1, savedPedidos.size());
    }
    @Test
    void testBuscarPorNumeroControle() {
        String numeroControle = "12345";
        List<Pedido> pedidosMock = Collections.singletonList(new Pedido());
        when(pedidoRepository.findByNumeroControle(numeroControle)).thenReturn(pedidosMock);

        List<Pedido> pedidosEncontrados = pedidoService.buscarPorNumeroControle(numeroControle);

        assertNotNull(pedidosEncontrados);
        assertEquals(1, pedidosEncontrados.size());
    }

    @Test
    void testBuscarPorDataCadastro() {
        LocalDate dataCadastro = LocalDate.of(2024, 1, 17);
        List<Pedido> pedidosMock = Collections.singletonList(new Pedido());
        when(pedidoRepository.findByDataCadastro(dataCadastro)).thenReturn(pedidosMock);

        List<Pedido> pedidosEncontrados = pedidoService.buscarPorDataCadastro(dataCadastro);

        assertNotNull(pedidosEncontrados);
        assertEquals(1, pedidosEncontrados.size());
    }
    @Test
    void testBuscarTodosPedidos() {
        List<Pedido> pedidosMock = Arrays.asList(new Pedido(), new Pedido());
        when(pedidoRepository.findAll()).thenReturn(pedidosMock);

        List<Pedido> todosPedidos = pedidoService.buscarTodosPedidos();

        assertNotNull(todosPedidos);
        assertEquals(2, todosPedidos.size());
    }
    @Test
    void testSalvarPedidoListaVazia() throws Exception {
        List<Pedido> pedidosParaSalvar = Collections.emptyList();
        List<Pedido> savedPedidos = pedidoService.salvarPedidos(pedidosParaSalvar);

        assertTrue(savedPedidos.isEmpty());
    }

    @Test
    void testSalvarPedidoComExcecao() {
        Pedido pedido = new Pedido();
        when(pedidoRepository.save(any(Pedido.class))).thenThrow(new RuntimeException("Erro ao salvar"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            pedidoService.salvarPedidos(Collections.singletonList(pedido));
        });

        assertEquals("Erro ao salvar", exception.getMessage());
    }
    @Test
    void testBuscarPorNumeroControleNaoEncontrado() {
        String numeroControle = "12345";
        when(pedidoRepository.findByNumeroControle(numeroControle)).thenReturn(Collections.emptyList());

        List<Pedido> pedidosEncontrados = pedidoService.buscarPorNumeroControle(numeroControle);

        assertTrue(pedidosEncontrados.isEmpty());
    }
    @Test
    void testBuscarPorDataCadastroNaoEncontrada() {
        LocalDate dataCadastro = LocalDate.of(2024, 1, 17);
        when(pedidoRepository.findByDataCadastro(dataCadastro)).thenReturn(Collections.emptyList());

        List<Pedido> pedidosEncontrados = pedidoService.buscarPorDataCadastro(dataCadastro);

        assertTrue(pedidosEncontrados.isEmpty());
    }


}
