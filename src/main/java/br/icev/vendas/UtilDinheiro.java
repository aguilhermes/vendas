// Conteúdo de UtilDinheiro.java (Implementação Completa)
package br.icev.vendas;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class UtilDinheiro {

    private UtilDinheiro() {
        // Construtor privado para evitar instanciação.
    }

    // O método deve retornar double, não BigDecimal, conforme o esperado pelos
    // testes
    public static double arredondar(double valor) {
        // 1. Cria um BigDecimal a partir do valor double.
        BigDecimal bd = new BigDecimal(valor);

        // 2. Define a escala para 2 (duas casas decimais) e o modo de arredondamento.
        // RoundingMode.HALF_UP é o mais comum para arredondamento bancário.
        bd = bd.setScale(2, RoundingMode.HALF_UP);

        // 3. Retorna o valor como double.
        return bd.doubleValue();
    }
}