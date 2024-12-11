package org.ecommerce.products.factories;

import org.ecommerce.products.Produto;

public abstract class ProdutoFactory {
    public abstract Produto criarProduto(String nome, double preco);
}
