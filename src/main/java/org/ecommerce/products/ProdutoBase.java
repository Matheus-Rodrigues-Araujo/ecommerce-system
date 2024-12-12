package org.ecommerce.products;

public class ProdutoBase extends Produto {
    public ProdutoBase(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double getPreco() {
        System.out.println("Preço Base: " + preco);
        return preco;
    }
}