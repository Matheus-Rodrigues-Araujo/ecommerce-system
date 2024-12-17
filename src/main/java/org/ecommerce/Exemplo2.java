package org.ecommerce;

import org.ecommerce.notifications.Cliente;
import org.ecommerce.notifications.ProdutoNotifier;
import org.ecommerce.products.FreteGratis;
import org.ecommerce.products.Produto;
import org.ecommerce.products.ProdutoBase;
import org.ecommerce.products.factories.ProdutoDigitalFactory;
import org.ecommerce.products.factories.ProdutoFactory;
import org.ecommerce.products.factories.ProdutoFisicoFactory;
import org.ecommerce.shipping.CalculadorFrete;
import org.ecommerce.shipping.FreteGratisStrategy;

public class Exemplo2 {
    public static void main(String[] args) {
        System.out.println("--------- DECORATOR --------");
        Produto produto = new ProdutoBase("Caneta Azul Bic", 6.00);
        produto = new FreteGratis(produto);
        produto.getPreco();

        System.out.println();

        System.out.println("--------- STRATEGY ---------");
        CalculadorFrete calculadorFrete = new CalculadorFrete();
        calculadorFrete.setEstrategiaFrete(new FreteGratisStrategy());
        System.out.println("Custo de frete: " + calculadorFrete.calcular(2, 0.05));

        System.out.println();

        System.out.println("--------- FACTORY ----------");
        // Factory de Produtos
        ProdutoFactory produtoFisicoFactory = new ProdutoFisicoFactory();
        ProdutoFactory produtoDigitalFactory = new ProdutoDigitalFactory();

        Produto produtoFisico = produtoFisicoFactory.criarProduto("Notebook Dell", 4500.00);
        Produto produtoDigital = produtoDigitalFactory.criarProduto("E-book Clean Code", 49.99);

        System.out.println("Produto 1: " + produtoFisico.getNome() + " - Preço: R$ " + produtoFisico.getPreco());
        System.out.println("Produto 2: " + produtoDigital.getNome() + " - Preço: R$ " + produtoDigital.getPreco());
        System.out.println();
        System.out.println("--------- OBSERVER ---------");

        ProdutoNotifier notifier = new ProdutoNotifier();

        Cliente cliente1 = new Cliente("Manuel Gomes");
        Cliente cliente2 = new Cliente("Gomes Manuel");

        notifier.adicionarObservador(cliente1);
        notifier.adicionarObservador(cliente2);

        notifier.notificar(produto.getNome() + " saiu para entrega");

    }
}
