package org.ecommerce;

import org.ecommerce.products.DescontoPercentual;
import org.ecommerce.products.FreteGratis;
import org.ecommerce.products.Produto;
import org.ecommerce.products.ProdutoBase;

public class Main {
    public static void main(String[] args) {
        Produto produto = new ProdutoBase("PS5", 3000.00);
        produto = new DescontoPercentual(produto, 5);
        produto = new FreteGratis(produto);
        produto.getPreco();
    }
}