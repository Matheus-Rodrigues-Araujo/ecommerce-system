package org.ecommerce.shipping;

public class FreteGratisStrategy implements EstrategiaFrete {
    @Override
    public double calcularFrete(double distancia, double peso){
        return 0;
    }
}
