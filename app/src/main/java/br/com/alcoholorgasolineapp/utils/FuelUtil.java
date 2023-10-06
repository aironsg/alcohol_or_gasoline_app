package br.com.alcoholorgasolineapp.utils;

public class FuelUtil {

    public static double gasoline;
    public static double alcohol;

    public static String comparePrice(double priceGasoline, double priceAlcohol) {

        //preço ideial do etanal = 4.39
        alcohol = priceAlcohol;
        gasoline = priceGasoline;
        double idealPrice = gasoline * 0.70;
        if(alcohol <= idealPrice){
            return "Melhor Combustivel para seu Carro é: Álcool";
        }else{
            return "Melhor Combustivel para seu Carro é: Gasolina";
        }

    }




}
