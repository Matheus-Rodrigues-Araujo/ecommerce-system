package org.ecommerce.products;

public class FreteGratis extends PromocaoDecorator {
    public FreteGratis(Produto produto) {
        super(produto);
    }

    @Override
    public double getPreco() {
        System.out.println("*** Frete grátis disponível ***");
        return produto.getPreco();
    }

}
