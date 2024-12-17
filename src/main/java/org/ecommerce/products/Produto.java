package org.ecommerce.products;

public abstract class Produto {
    protected String nome;
    protected double preco;

    protected Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome(){
        return nome;
    }

    public abstract double getPreco();
}
