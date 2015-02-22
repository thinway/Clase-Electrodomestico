package es.fpada;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Created by thinway on 12/2/15.
 */
public class Electrodomestico {
    private double precio_base;
    private String color;
    private char letraEnergia;
    private double peso;

    /**
     * Constructor por defecto. Inicializa los valores a:
     *  - Precio Base: 100.00 €
     *  - Color: "Blanco"
     *  - Letra Energia: F
     *  - Peso: 5.0 kg
     */
    public Electrodomestico(){
        this.setPrecio_base(100.0);
        this.setColor("Blanco");
        this.setLetraEnergia('F');
        this.setPeso(5.0);
    }

    /**
     * Constructor con dos parámetros: precioBase y peso.
     *
     * @param precio_base Precio base del electrodoméstico (€)
     * @param peso  Peso del electrodoméstico (Kg)
     */
    public Electrodomestico(double precio_base, double peso){
        this.setPrecio_base(precio_base);
        this.setColor("Blanco");
        this.setLetraEnergia('F');
        this.setPeso(peso);
    }

    /**
     * Constructor con todos los atributos de la clase.
     *
     * @param precio_base Precio base del electrodoméstico (€)
     * @param color
     * @param letraEnergia
     * @param peso Peso del electrodoméstico (Kg)
     */
    public Electrodomestico(double precio_base, String color, char letraEnergia, double peso){
        setPrecio_base(precio_base);
        setColor(color);
        setLetraEnergia(letraEnergia);
        setPeso(peso);
    }

    // Getters

    /**
     * Getter del precio base.
     *
     * @return Precio base del objeto
     */
    public double getPrecio_base() {
        return precio_base;
    }

    /**
     * Getter del color.
     *
     * @return Color del objeto.
     */
    public String getColor() {
        return color;
    }

    /**
     * Getter de la letra de eficiencia energética.
     *
     * @return Eficiencia energética del objeto.
     */
    public char getLetraEnergia() {
        return letraEnergia;
    }

    public double getPeso() {
        return peso;
    }

    // Setters

    /**
     * Establece el precio base del electrodoméstico.
     *
     * @param precio_base Precio base del electrodoméstico en euros.
     */
    public void setPrecio_base(double precio_base) {
        // Se comprueba que el precio sea positivo para asignarlo
        if (precio_base >= 0.0){
            this.precio_base = precio_base;
        }else{
            this.precio_base = 100.0;
        }
    }

    /**
     * Establece el color del electrodoméstico. Solo se admitirán los
     * colores blanco, negro, rojo, azul y gris.
     * En caso de asignar un color no admitido se asignará el 'BLANCO'.
     *
     * @param color Color del electrodoméstico.
     */
    public void setColor(String color) {
        String colores[] = {"blanco", "negro", "rojo", "azul", "gris"};

        if ( Arrays.asList(colores).contains(color.toLowerCase()) ){
            this.color = color.toUpperCase();
        } else {
            this.color = "BLANCO";
        }
    }

    /**
     * Establece la letra de eficiencia energética del electrodoméstico.
     * Solo se admitirán las letras 'A', 'B', 'C', 'D', 'E' y 'F'
     * En caso de querer asignar una letra no admitida se asignará la letra 'F'.
     *
     * @param letraEnergia eficiencia energética del electrodoméstico.
     */
    public void setLetraEnergia(char letraEnergia) {
        // Se crea una cadena con las letras posibles de eficiencia energética
        String valoresPosibles = "ABCDEF";

        // Se comprueba si la letra que se quiere asignar está dentro de la cadena
        // de caracteres posibles. Si no es así se asigna la letra 'A'
        if ( valoresPosibles.indexOf(Character.toUpperCase(letraEnergia)) > 0 ){
            this.letraEnergia = Character.toUpperCase(letraEnergia);
        } else {
            this.letraEnergia = 'F';
        }
    }

    /**
     * Establece el peso del electrodoméstico.
     *
     * @param peso Peso del electrodoméstico en Kg.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    /**
     * Imprime el estado de un objeto.
     */
    public String toString(){
        // Se establece un objeto DecimalFormat para formatear el precio y peso
        // con dos decimales.
        DecimalFormat df = new DecimalFormat("#.00");

        // Observar cómo se utiliza el objeto Decimal Format junto con el método
        // format para generar la salida
        return "Precio Base: "+df.format(this.precio_base)+" €"
                +"\nColor: "+this.color
                +"\nConsumo : "+this.letraEnergia
                +"\nPerso : "+df.format(this.peso)+" Kg";
    }

    /**
     * Calcula el precio final del electrodoméstico en base a su letra de eficiencia
     * energética y su peso según las reglas descritas en el enunciado del ejercicio.
     *
     * @return double Precio final del electronoméstico
     */
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

    /**
     * Comprueba si un objeto tiene la letra de eficiencia energética facilitada
     * como parámetro.
     *
     * @param elec letra de eficiencia energética
     *
     * @return boolean Verdadero si coincide con el parámetro. Falso en caso contrario.
     */
    public boolean equals(Electrodomestico elec){
        if (this.getLetraEnergia() == elec.getLetraEnergia() ) {
            return true;
        }else{
            return false;
        }
    }
}
