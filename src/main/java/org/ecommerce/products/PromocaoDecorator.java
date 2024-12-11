package org.ecommerce.products;

abstract class PromocaoDecorator extends Produto {
    protected Produto produto;

    public PromocaoDecorator(Produto produto) {
        super(produto.nome, produto.preco);
        this.produto = produto;
    }
}
