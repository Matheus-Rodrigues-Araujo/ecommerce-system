package org.ecommerce.products;

public class DescontoPercentual extends PromocaoDecorator {
    private final double percentual;

    public DescontoPercentual(Produto produto, double percentual) {
        super(produto);
        this.percentual = percentual;
    }

    @Override
    public double getPreco() {
        double precoComDesconto = produto.getPreco() * (1 - percentual / 100);
        System.out.println("C/Desconto Percentual:" + precoComDesconto);
        return precoComDesconto;
    }
}
