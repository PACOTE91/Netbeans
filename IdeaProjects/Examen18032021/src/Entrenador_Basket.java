//package com.company;
// No cambies el código de esta clase, no modiques ni añadas nada
// solo puedes cambiar el package para tu proyecto de Intellj IDEA, NetBeans o Eclipse

public class Entrenador_Basket extends Seleccion_Basket {
    private int partidos_ganados, partidos_perdidos;

    public Entrenador_Basket(String nombre, String apellidos, int edad, int partidos_ganados, int partidos_perdidos) {
        super(nombre, apellidos, edad);
        this.partidos_ganados = partidos_ganados;
        this.partidos_perdidos = partidos_perdidos;
    }

    public int getPartidos_ganados() {
        return partidos_ganados;
    }

    public void setPartidos_ganados(int partidos_ganados) {
        this.partidos_ganados = partidos_ganados;
    }

    public int getPartidos_perdidos() {
        return partidos_perdidos;
    }

    public void setPartidos_perdidos(int partidos_perdidos) {
        this.partidos_perdidos = partidos_perdidos;
    }

    @Override
    public String toString() {
        return super.toString() +" .Entrenador_Basket{" +
                "partidos_ganados=" + partidos_ganados +
                ", partidos_perdidos=" + partidos_perdidos +
                "} ";
    }

    @Override
    // la valoración del entrenador se calcula teniendo en cuenta los partido ganados y perdidos
    // se obtiene una valoración de 0 a 100
    public double valorar() {
        double ganados = partidos_ganados;
        double perdidos = partidos_perdidos;
        return ganados/(ganados+perdidos)*100.0;
    }
}
// No cambies el código de esta clase, no modiques ni añadas nada
// solo puedes cambiar el package para tu proyecto de Intellj IDEA, NetBeans o Eclipse
