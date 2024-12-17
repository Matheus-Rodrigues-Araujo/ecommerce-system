package org.ecommerce;

import org.ecommerce.notifications.Cliente;
import org.ecommerce.notifications.ProdutoNotifier;
import org.ecommerce.orders.Pedido;
import org.ecommerce.orders.TipoPedido;
import org.ecommerce.orders.factories.PedidoFactoryManager;
import org.ecommerce.products.FreteGratis;
import org.ecommerce.products.Produto;
import org.ecommerce.products.ProdutoBase;
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
        Pedido pedidoPadrao = PedidoFactoryManager.criarPedido(TipoPedido.PADRAO, produto.getNome());
        pedidoPadrao.processar();
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
