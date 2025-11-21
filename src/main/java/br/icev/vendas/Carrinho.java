package br.icev.vendas;

import br.icev.vendas.excecoes.QuantidadeInvalidaException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Carrinho {
    private Map<Produto, Integer> itens;

    public Carrinho() {
        this.itens = new HashMap<>();
    }

    public void adicionar(Produto produto, int quantidade) throws QuantidadeInvalidaException {
        if (quantidade <= 0) {
            throw new QuantidadeInvalidaException("Quantidade inválida.");
        }
        int atual = itens.getOrDefault(produto, 0);
        itens.put(produto, atual + quantidade);
    }

    public void removerItem(Produto produto) {
        itens.remove(produto);
    }

    public Map<Produto, Integer> getItens() {
        return itens;
    }

    public BigDecimal getSubtotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Map.Entry<Produto, Integer> entry : itens.entrySet()) {
            Produto p = entry.getKey();
            int qtd = entry.getValue();
            BigDecimal valorItem = p.getPrecoUnitario().multiply(new BigDecimal(qtd));
            total = total.add(valorItem);
        }
        return total.setScale(2, RoundingMode.HALF_UP);
    }

    public int getTotalItens() {
        int total = 0;
        for (int qtd : itens.values()) {
            total += qtd;
        }
        return total;
    }

    public BigDecimal getTotalCom(PoliticaDesconto politica) {
        BigDecimal subtotal = getSubtotal();
        BigDecimal totalComDesconto = politica.aplicar(subtotal);

        // --- CORREÇÃO: Se o total for negativo, retorna ZERO ---
        if (totalComDesconto.compareTo(BigDecimal.ZERO) < 0) {
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        }

        return totalComDesconto.setScale(2, RoundingMode.HALF_UP);
    }

    public void limpar() {
        itens.clear();
    }
}