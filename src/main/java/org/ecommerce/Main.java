package org.ecommerce;

import org.ecommerce.notifications.Cliente;
import org.ecommerce.notifications.ProdutoNotifier;
import org.ecommerce.orders.Pedido;
import org.ecommerce.orders.factories.PedidoExpressoFactory;
import org.ecommerce.orders.factories.PedidoFactory;
import org.ecommerce.products.DescontoPercentual;
import org.ecommerce.products.FreteGratis;
import org.ecommerce.products.Produto;
import org.ecommerce.products.ProdutoBase;
import org.ecommerce.shipping.CalculadorFrete;
import org.ecommerce.shipping.FretePorDistanciaStrategy;

public class Main {
    public static void main(String[] args) {
        Produto produto = new ProdutoBase("PS5", 3000.00);
        produto = new DescontoPercentual(produto, 5);
        System.out.println("C/Desconto: " + produto.getPreco());

        CalculadorFrete calculadorFrete = new CalculadorFrete();
        calculadorFrete.setEstrategiaFrete(new FretePorDistanciaStrategy());
        System.out.println("Custo de frete: " + calculadorFrete.calcular(100,2));

        PedidoFactory pedidoFactory = new PedidoExpressoFactory();
        Pedido pedido = pedidoFactory.criarPedido("Expresso");
        pedido.processar();

        ProdutoNotifier notifier = new ProdutoNotifier();

        Cliente cliente1 = new Cliente("Brksedu");
        Cliente cliente2 = new Cliente("Davi Jones");
        Cliente cliente3 = new Cliente("GameplayRJ");
        Cliente cliente4 = new Cliente("Michael Jackson");
        Cliente cliente5 = new Cliente("Kratos");

        notifier.adicionarObservador(cliente1);
        notifier.adicionarObservador(cliente2);
        notifier.adicionarObservador(cliente3);
        notifier.adicionarObservador(cliente4);
        notifier.adicionarObservador(cliente5);

        notifier.notificar("Novo produto disponível");

    }
}