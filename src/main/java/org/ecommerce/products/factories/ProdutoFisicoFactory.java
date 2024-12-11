package org.ecommerce.products.factories;

import org.ecommerce.products.Produto;
import org.ecommerce.products.ProdutoBase;

public class ProdutoFisicoFactory extends ProdutoFactory {
    @Override
    public Produto criarProduto(String nome, double preco) {
        return new ProdutoBase(nome, preco);
    }
}
