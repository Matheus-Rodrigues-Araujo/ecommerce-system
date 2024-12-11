package org.ecommerce.notifications;

public class Cliente implements Observador {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String mensagem) {
        System.out.println(STR."Notificação para \{nome}:\{mensagem}");
    }

}
