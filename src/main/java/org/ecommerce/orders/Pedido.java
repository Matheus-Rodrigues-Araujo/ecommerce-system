package org.ecommerce.orders;

public abstract class Pedido {
    protected String descrição;

    public Pedido(String descrição){
        this.descrição = descrição;
    }

    public abstract void processar();
}
