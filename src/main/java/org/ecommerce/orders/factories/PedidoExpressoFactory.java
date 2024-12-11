package org.ecommerce.orders.factories;

import org.ecommerce.orders.Pedido;

public class PedidoExpressoFactory extends PedidoFactory {
    @Override
    public Pedido criarPedido(String tipo) {
        return new Pedido(tipo) {
            @Override
            public void processar() {
                System.out.println(STR."Processando pedido expresso: \{tipo}");
            }
        };
    }
}