package br.icev.vendas;

import java.math.BigDecimal;
import java.util.Map;

public class Pedido {
    public enum Status {
        PAGO
    }

    // Atributos para guardar as informações
    private Map<String, Integer> itensPorCodigo;
    private BigDecimal totalPago;
    private String codigoAutorizacao;
    private Status status;

    // Construtor: Recebe os dados e guarda nos atributos
    public Pedido(Map<String, Integer> itensPorCodigo, BigDecimal totalPago,
            String codigoAutorizacao, Status status) {
        this.itensPorCodigo = itensPorCodigo;
        this.totalPago = totalPago;
        this.codigoAutorizacao = codigoAutorizacao;
        this.status = status;
    }

    // Getters: Apenas retornam os valores armazenados

    public BigDecimal getTotalPago() {
        return totalPago;
    }

    public String getCodigoAutorizacao() {
        return codigoAutorizacao;
    }

    public Status getStatus() {
        return status;
    }

    // Retorna a quantidade de um item específico pelo código
    public int getQuantidadeItem(String codigo) {
        return itensPorCodigo.getOrDefault(codigo, 0);
    }
}