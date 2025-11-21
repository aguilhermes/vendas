package br.icev.vendas;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {
    private String codigo;
    private String nome;
    private BigDecimal precoUnitario;

    public Produto(String codigo, String nome, BigDecimal precoUnitario) {
        // 1. Verifica se é nulo (Joga NullPointerException)
        if (precoUnitario == null) {
            throw new NullPointerException("Preço não pode ser nulo.");
        }

        // 2. Verifica se é negativo ou zero (Joga IllegalArgumentException)
        if (precoUnitario.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Preço inválido (deve ser maior que zero).");
        }

        this.codigo = codigo;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Produto produto = (Produto) o;
        return Objects.equals(codigo, produto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}