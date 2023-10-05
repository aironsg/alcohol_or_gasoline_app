package br.com.alcoholorgasolineapp.utils;

public class FuelUtil {

    public static double gasoline;
    public static double alcohol;

    public static double comparePrice(double priceGasoline, double priceAlcohol) {

        //preço ideial do etanal = 4.39
        double idealPrice = priceGasoline * 0.70;
        if (priceAlcohol <= idealPrice) {
            alcohol = priceAlcohol;
            return alcohol;
        } else {
            gasoline = priceGasoline;
            return gasoline;
        }


    }

    public static String bestFuel(double resultPrice) {
        if (resultPrice <= alcohol) {
            return "Melhor Combustivel para seu Carro é: Gasolina : ";
        } else {
            return "Melhor Combustivel para seu Carro é: Álcool : ";
        }
    }


}
