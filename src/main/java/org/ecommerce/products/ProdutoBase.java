package org.ecommerce.products;

class ProdutoBase extends Produto {
    public ProdutoBase(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double getPreco() {
        return preco;
    }
}