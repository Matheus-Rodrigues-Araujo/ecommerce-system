package org.ecommerce.orders;

public abstract class Pedido {
    protected String tipo;

    public Pedido(String tipo){
        this.tipo = tipo;
    }

    public abstract void processar();
}
