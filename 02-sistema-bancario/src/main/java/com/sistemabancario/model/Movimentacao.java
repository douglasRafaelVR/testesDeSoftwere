package com.sistemabancario.model;

/**
 * Representa uma movimentação em uma {@link Conta} bancária, que pode indicar entrada ou saída.
 *
 * <p>
 * <b>NOTA</b>: Mesmo sendo possível obter o saldo somando-se todas as movimentações,
 * à medida que os dados no sistema aumentarem ao longo do tempo, 
 * calcular o saldo pode se tornar uma operação extremamente lenta.
 * Isto normalmente ocorrer quando o histórico de movimentações se torna longo
 * (principalmente depois de alguns anos).
 * </p>
 * 
 * @author Manoel Campos da Silva Filho
 */

/* ---------------------------------------------------------------------------------------------------
   ---------------------------------------------------------------------------------------------------
Exigências do professor : 

1º ) Tipo de movimentação foi definida como crédito
2º ) A movimentação foi confirmada
4º ) O valor foi atribuído a movimentação
5º ) incluída na lista de movimentações

   ---------------------------------------------------------------------------------------------------
   ---------------------------------------------------------------------------------------------------
*/
public class Movimentacao implements Cadastro {
    private long id;
    private String descricao;

    /**
     * Conta bancária a qual a movimentação está vinculada.
     */
    private Conta conta;
    
    /**
     * Tipo da movimentação deve ser 'C' para crédito (entrada de dinheiro)
     * ou 'D' para débito (saída de dinheiro). (R01)
     */
    private char tipo;

    /**
     * Valor monetário da movimentação.
     * O valor não deve ser negativo, uma vez que existe o atributo {@link #tipo}. (R02)
     * Se o tipo for débito, o valor da movimentação não pode ser superior ao saldo total da {@link Conta}. (R03)
     */
    private double valor;

    /**
     * Indica se a movimentação foi confirmada e deve ser registrada no saldo da
     * conta, quando for adicionada à lista de movimentações usando
     * 
     * Ou seja,(na classe conta,) quando essa movimentação for adicionada a lista de movimentações da conta, caso
     * essa movimentação esteja como "confirmada" seu valor(o da movimentação) será adicionado ao saldo da conta.
     * 
     * {@link Conta#addMovimentacao(Movimentacao)}.
     *
     * <ul>
     *  <li>Movimentacoes devem ser instanciadas como "confirmadas" por padrão. (R04)</li>
     *  <li>
     *      Somente operações como depósito em envelope ou em cheque devem ser
     *      registradas inicialmente como não confirmadas. Após uma operação ser    < ----  FALTA A 1º PARTE
     *      confirmada, deve-se atualizar o saldo da conta.
     *  <li>
     * </ul>
     *
     * @see Conta#depositoEnvelope(double)
     * @see Conta#depositoCheque(double)
     */
    private boolean confirmada;

    /**
     * Instancia uma movimentação para uma determinada {@link Conta} bancária. (R05)
     * @param conta a {@link Conta} para vincular a movimentação.
     */
    
    public Movimentacao(Conta conta){
        this.conta = conta;
        this.confirmada = true;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public char getTipo(){
        return tipo;
    }

    public void setTipo(char tipo){
        tipo = Character.toUpperCase(tipo);
        if((tipo != 'C') && (tipo != 'D')){
            throw new IllegalArgumentException("argumento inválido, deveria ser ou D ou C");
        }
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
            if (valor < 0) {
                throw new IllegalArgumentException("Valor não pode ser inferior a zero.");
            }
            if((tipo == 'D') && (valor > conta.getSaldo())){
                throw new IllegalStateException("Valor superior ao saldo da conta.");
            }
        this.valor = valor;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public void setConfirmada(boolean confirmada) {
        if(confirmada){
            this.conta.depositoDinheiro(valor);
        }
        this.confirmada = confirmada;
    }

}