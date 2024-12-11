package org.ecommerce.shipping;

public class FretePorDistanciaStrategy implements  EstrategiaFrete {
    @Override
    public double calcularFrete(double distancia, double peso){
        return distancia * 1.2;
    }
}
