package org.ecommerce.shipping;

public class FretePorPesoStrategy implements EstrategiaFrete {
    @Override
    public double calcularFrete(double distancia, double peso){
        return peso * 0.8;
    }
}
