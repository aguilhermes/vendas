package br.icev.vendas;

import br.icev.vendas.excecoes.QuantidadeInvalidaException;
import br.icev.vendas.excecoes.SemEstoqueException;
import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<String, Integer> produtos;

    public Estoque() {
        this.produtos = new HashMap<>();
    }

    public void adicionarEstoque(String codigo, int quantidade) throws QuantidadeInvalidaException {
        if (quantidade <= 0) {
            throw new QuantidadeInvalidaException("Quantidade inválida.");
        }
        int atual = produtos.getOrDefault(codigo, 0);
        produtos.put(codigo, atual + quantidade);
    }

    // Método que já tínhamos
    public void removerProduto(Produto produto, int quantidade)
            throws SemEstoqueException, QuantidadeInvalidaException {
        reservar(produto.getCodigo(), quantidade);
    }

    // --- MÉTODO NOVO EXIGIDO PELOS TESTES ---
    public void reservar(String codigo, int quantidade) throws SemEstoqueException, QuantidadeInvalidaException {
        if (quantidade <= 0) {
            throw new QuantidadeInvalidaException("Quantidade inválida.");
        }

        int atual = produtos.getOrDefault(codigo, 0);

        if (atual < quantidade) {
            throw new SemEstoqueException("Estoque insuficiente.");
        }
        produtos.put(codigo, atual - quantidade);
    }

    public int getDisponivel(String codigo) {
        return produtos.getOrDefault(codigo, 0);
    }
}