package com.sistemabancario.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste base para implementação dos testes
 * unitários para a classe {@link Movimentacao}.
 * Os testes foram gerados pelo IDE apenas como modelo
 * (fiz apenas algumas melhorias de boas práticas 
 * como tirar visibilidade public e definir variáveis como final).
 * 
 * Assim, NENHUM DELES FUNCIONA E O CÓDIGO PRECISA SER ALTERADO
 * de acordo com as regras de negócio dos métodos da classe {@link Movimentacao}.
 * Ao iniciar a alteração de um teste aqui,
 * a primeira coisa a fazer é remover a chamada de fail(),
 * que indica que o teste é apenas um protótipo.
 * 
 * @author Manoel Campos da Silva Filho
 */
class MovimentacaoTest {
    /*
    @Test
    void testGetId() {
        final Movimentacao instance = new Movimentacao(new Conta());
        final long esperado = 1;
        instance.setId(esperado);
        final long obtido = instance.getId();
        assertEquals(esperado, obtido);
    }*/
    
    
    
    @Test
    public void testMovimentacaoTipoC_P1(){
        final Conta conta = new Conta();
        final Movimentacao instancia = new Movimentacao(conta);
        final char esperado = 'C';
        instancia.setTipo(esperado);
        final char obtido = instancia.getTipo();
        assertEquals(Character.toUpperCase(esperado),obtido);
    }
    
    
    
    @Test
    public void testMovimentacaoTipoD_P1(){
        final Conta conta = new Conta();
        final Movimentacao instancia = new Movimentacao(conta);
        final char esperado = 'D';
        instancia.setTipo(esperado);
        final char obtido = instancia.getTipo();
        assertEquals(esperado,obtido);
    }    
    
    
    @Test
    public void testTipoInvalido_P1(){
        final Movimentacao instancia = new Movimentacao(new Conta());
        final char invalido = 'H';
        assertThrows(IllegalArgumentException.class, () -> instancia.setTipo(invalido));
    }
    
    @Test
    public void testValorNegativo_P2(){
        final Movimentacao instancia = new Movimentacao(new Conta());
        final double negativo = -90;
        assertThrows(IllegalArgumentException.class, () -> instancia.setValor(negativo));
    }
    
    @Test
    public void testValorMovimentacaoSuperiorAoSaldoConta_P3(){
        Conta conta = new Conta();
        double saldo = 100;
        double valorSuperior = 200;
        conta.depositoDinheiro(saldo);
        final Movimentacao instancia = new Movimentacao(conta);
        instancia.setTipo('D');
        assertThrows(IllegalStateException.class, () -> instancia.setValor(valorSuperior));
    }
    
    @Test
    public void testMovimentacoesConfirmadasPorPADRAO_P4(){
        final Movimentacao movimentacao = new Movimentacao(new Conta());
        final boolean esperado = true;
        final boolean obtido = movimentacao.isConfirmada();
        assertEquals(esperado,obtido);
    }
    
    @Test
    public void testMovimentaccaoNaoConfirmadasEmCheque_P4(){
        Conta conta = new Conta();
        conta.depositoCheque(0);
        final boolean esperado=false;
        final boolean obtido = conta.getMovimentacoes().get(0).isConfirmada();
        assertEquals(esperado,obtido);
    }
    
    @Test
    public void testMovimentaccaoNaoConfirmadasEmEnvelope_P4(){
        Conta conta = new Conta();
        conta.depositoEnvelope(0);
        final boolean esperado=false;
        final boolean obtido = conta.getMovimentacoes().get(0).isConfirmada();
        assertEquals(esperado,obtido);
    }
    
    @Test
    public void testAtualizarSaldoQuandoMovimentacaoEConfirmada_P4(){
        final Movimentacao movimentacao = new Movimentacao(new Conta());
        final boolean esperado = true;
        final boolean obtido = movimentacao.isConfirmada();
        assertEquals(esperado,obtido);
    }
    
    @Test
    public void testInstaciaMovimentacaoParaConta_P5(){
        Conta conta = new Conta();
        Movimentacao movimentacao = new Movimentacao(conta);
        assertNotNull(conta.getMovimentacoes());
    }
}
