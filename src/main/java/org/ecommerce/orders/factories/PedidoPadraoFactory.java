package org.ecommerce.orders.factories;

import org.ecommerce.orders.Pedido;

public class PedidoPadraoFactory extends PedidoFactory {
    @Override
    public Pedido criarPedido(String descricao) {
        return new Pedido(descricao) {
            @Override
            public void processar() {
                System.out.println("Pedido PADRÃO: " + descricao);
                System.out.println("Prazo de entrega: 7 dias.");
                System.out.println("Processando o pedido com entrega padrão...");
            }
        };
    }
}
