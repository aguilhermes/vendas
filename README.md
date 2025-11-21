# 🛒 Sistema de Vendas (Java + JUnit 5)

Este projeto consiste na implementação de um sistema de backend para um e-commerce simples, focado na lógica de negócios, validações e precisão monetária. O desenvolvimento foi guiado por testes unitários (**TDD**) utilizando **JUnit 5**.

![Java](https://img.shields.io/badge/Java-17%2B-orange)
![JUnit 5](https://img.shields.io/badge/Tests-JUnit%205-green)
![Maven](https://img.shields.io/badge/Build-Maven-blue)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen)

## 📋 Sobre o Projeto

O objetivo principal foi aplicar conceitos de **Programação Orientada a Objetos (POO)** e garantir a qualidade do código através de testes automatizados. O sistema gerencia produtos, controle de estoque, carrinho de compras com cálculo de descontos e processamento de pedidos.

### 🚀 Principais Funcionalidades

* **Gestão de Produtos:** Cadastro com validação rigorosa de preços (evita valores negativos ou nulos).
* **Controle de Estoque:** Adição e baixa de itens, com verificação de disponibilidade e reserva (thread-safe logic).
* **Carrinho de Compras:**
    * Adição e remoção de itens.
    * Cálculo de subtotal e total.
    * Aplicação de regras de desconto via interface (Strategy Pattern).
* **Precisão Financeira:** Uso extensivo de `BigDecimal` e `RoundingMode.HALF_UP` para evitar erros de arredondamento em cálculos monetários.
* **Tratamento de Erros:** Exceções personalizadas (`QuantidadeInvalidaException`, `SemEstoqueException`) para regras de negócio.

## 🛠️ Tecnologias Utilizadas

* **Java:** Linguagem principal.
* **JUnit 5:** Framework de testes unitários.
* **Maven:** Gerenciamento de dependências e build.
* **VS Code:** IDE de desenvolvimento.

## 📂 Estrutura do Projeto

O projeto segue a arquitetura padrão do Maven:

```text
src/
├── main/java/br/icev/vendas/
│   ├── excecoes/          # Exceções personalizadas (SemEstoque, etc.)
│   ├── Carrinho.java      # Lógica do carrinho de compras
│   ├── Estoque.java       # Controle de inventário
│   ├── Produto.java       # Entidade de produto
│   ├── Pedido.java        # Representação do pedido final
│   ├── UtilDinheiro.java  # Utilitário para arredondamento (BigDecimal)
│   └── ...
└── test/java/br/icev/vendas/
    ├── CarrinhoTeste.java
    ├── CheckoutTeste.java
    └── ...

    🧪 Testes
O projeto foi validado com uma suíte de testes automatizados que cobrem os principais cenários de uso e casos de borda.

Para executar os testes via terminal (com Maven instalado):

Bash

mvn test
🧠 Aprendizados
Durante o desenvolvimento deste projeto, foram reforçados conceitos importantes:

POO e Encapsulamento: Proteção dos estados dos objetos (Produto, Estoque).

Java Math: Importância de usar BigDecimal para dinheiro em vez de double.

Testes Unitários: Desenvolvimento guiado por testes para garantir que cada componente funcione isoladamente.

Clean Code: Organização de código legível e tratamento adequado de exceções.

Desenvolvido por Antonio Guilherme Santos da Silva, José Roberto de Araújo sousa, Octavio Alves Freire.


    