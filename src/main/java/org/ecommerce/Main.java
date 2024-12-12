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
        Cliente cliente = new Cliente("Brksedu");
        notifier.adicionarObservador(cliente);
        notifier.notificar("Novo produto disponível");

    }
}