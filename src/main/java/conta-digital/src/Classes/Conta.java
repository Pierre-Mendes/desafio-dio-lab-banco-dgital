package Classes;

import Enums.TipoTransacaoEnum;
import Interfaces.ContaInterface;
import Validator.ContaValidator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Conta implements ContaInterface {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected ContaValidator contaValidator;
    private final List<HistoricoTransacoes> historicoTransacoes;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.contaValidator = new ContaValidator();
        this.historicoTransacoes = new ArrayList<>();
    }

    public void adicionarTransacao(HistoricoTransacoes transacao) {
        historicoTransacoes.add(transacao);
    }

    @Override
    public void sacar(double valor) {
        contaValidator.callValidate("saque", valor, saldo);
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        HistoricoTransacoes transacap = new HistoricoTransacoes(LocalDateTime.now(), TipoTransacaoEnum.DEPOSITO, valor, "Depósito realizado");
        adicionarTransacao(transacap);
        saldo += valor;
    }

    @Override
    public void transferir(double valor, ContaInterface contaDestino) {
        contaValidator.callValidate("transferencia", valor, saldo);
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato ===");
        for (HistoricoTransacoes transacao : historicoTransacoes) {
            System.out.println("Data: " + transacao.getData());
            System.out.println("Tipo: " + transacao.getTipo());
            System.out.println("Valor: " + transacao.getValor());
            System.out.println("Descrição: " + transacao.getDescricao());
            System.out.println();
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Numero: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }
}
