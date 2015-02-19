package es.fpada;

import java.text.DecimalFormat;

/**
 * Created by thinway on 12/2/15.
 */
public class Electrodomestico {
    private double precio_base;
    private String color;
    private char letraEnergia;
    private double peso;

    public Electrodomestico(){
        precio_base = 100.0;
        color = "Blanco";
        letraEnergia = 'F';
        peso = 5.0;
    }

    public Electrodomestico(double precio_base, double peso){
        this.precio_base = precio_base;
        color = "Blanco";
        letraEnergia = 'F';
        this.peso = peso;
    }

    public Electrodomestico(double precio_base, String color, char letraEnergia, double peso){
        setPrecio_base(precio_base);
        setColor(color);
        setLetraEnergia(letraEnergia);
        setPeso(peso);
    }

    public double getPrecio_base() {
        return precio_base;
    }

    public String getColor() {
        return color;
    }

    public char getLetraEnergia() {
        return letraEnergia;
    }

    public double getPeso() {
        return peso;
    }

    public void setPrecio_base(double precio_base) {

        this.precio_base = precio_base;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setLetraEnergia(char letraEnergia) {
        this.letraEnergia = letraEnergia;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00");

        return "Precio Base: "+df.format(this.precio_base)+" €"
                +"\nColor: "+this.color
                +"\nConsumo : "+this.letraEnergia
                +"\nPerso : "+df.format(this.peso)+" Kg";
    }

    public double precioFinal() {
        double precioFinal = this.precio_base;

        switch (letraEnergia) {
            case 'A':
                precioFinal += 100;
                break;
            case 'B':
                precioFinal += 80;
                break;
            case 'C':
                precioFinal += 60;
                break;
            case 'D':
                precioFinal += 50;
                break;
            case 'E':
                precioFinal += 30;
                break;
            case 'F':
                precioFinal += 10;
                break;
            default:
        }

        if (peso >= 0 && peso <= 19) {
            precioFinal += 10;
        }else if ( peso >= 20 && peso <= 49) {
            precioFinal += 50;
        }else if ( peso >= 50 && peso <=79 ) {
            precioFinal += 80;
        }else if ( peso >= 80 ){
            precioFinal += 100;
        }

        return precioFinal;
    }

    public boolean equals(Electrodomestico elec){
        if (this.getLetraEnergia() == elec.getLetraEnergia() ) {
            return true;
        }else{
            return false;
        }
    }
}
