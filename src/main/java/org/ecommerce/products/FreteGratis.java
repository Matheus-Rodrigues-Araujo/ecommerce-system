package org.ecommerce.products;

public class FreteGratis extends PromocaoDecorator {
    public FreteGratis(Produto produto) {
        super(produto);
    }

    @Override
    public double getPreco() {
        return produto.getPreco();
    }

}
