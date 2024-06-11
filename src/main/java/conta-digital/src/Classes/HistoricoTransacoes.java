package Classes;

import Enums.TipoTransacaoEnum;

import java.time.LocalDateTime;

public class HistoricoTransacoes {
    private LocalDateTime data;
    private TipoTransacaoEnum tipo;
    private double valor;
    private String descricao;

    public HistoricoTransacoes(LocalDateTime data, TipoTransacaoEnum tipo, double valor, String descricao) {
        this.data = data;
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public TipoTransacaoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacaoEnum tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
