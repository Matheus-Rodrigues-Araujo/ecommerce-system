package org.ecommerce.shipping;

public class CalculadorFrete {
    private EstrategiaFrete estrategiaFrete;

    public void setEstrategiaFrete(EstrategiaFrete estrategiaFrete) {
        this.estrategiaFrete = estrategiaFrete;
    }

    public double calcular(double distancia, double peso){
        return estrategiaFrete.calcularFrete(distancia, peso);
    }

}
