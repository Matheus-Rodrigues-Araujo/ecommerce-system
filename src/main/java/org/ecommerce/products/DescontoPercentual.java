package org.ecommerce.products;

public class DescontoPercentual extends PromocaoDecorator {
    private double percentual;

    public DescontoPercentual(Produto produto, double percentual) {
        super(produto);
        this.percentual = percentual;
    }

    @Override
    public double getPreco() {
        return produto.getPreco() * (1 - percentual / 100);
    }
}
