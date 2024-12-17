package org.ecommerce.orders.factories;

import org.ecommerce.orders.Pedido;
import org.ecommerce.orders.TipoPedido;

public class PedidoFactoryManager {
    public static Pedido criarPedido(TipoPedido tipo, String descricao) {
        PedidoFactory factory;

        // Decide qual fábrica utilizar com base no tipo do pedido
        switch (tipo) {
            case PADRAO:
                factory = new PedidoPadraoFactory();
                break;
            case EXPRESSO:
                factory = new PedidoExpressoFactory();
                break;
            default:
                throw new IllegalArgumentException("Tipo de pedido desconhecido.");
        }

        // Cria o pedido utilizando a fábrica escolhida
        return factory.criarPedido(descricao);
    }
}
