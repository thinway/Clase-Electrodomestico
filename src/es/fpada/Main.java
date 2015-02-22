package es.fpada;

import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.00");
        Electrodomestico lavadora = new Electrodomestico(545.90,"Azul",'e', 105.67);

        System.out.println("Mi lavadora:");
        System.out.println(lavadora);
        System.out.println("PVP: "+df.format(lavadora.precioFinal())+" €");
    }
}
