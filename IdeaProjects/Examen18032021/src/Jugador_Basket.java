//package com.company;
// No cambies el código de esta clase, no modiques ni añadas nada
// solo puedes cambiar el package para tu proyecto de Intellj IDEA, NetBeans o Eclipse

public class Jugador_Basket extends Seleccion_Basket {
    private int dorsal;
    private int puntos_anotados;
    private int rebotes;
    private int asistencias;
    private String puesto;

    public Jugador_Basket(String nombre, String apellidos, int edad, int dorsal, int puntos_anotados, int rebotes, int asistencias, String puesto) {
        super(nombre, apellidos, edad);
        this.dorsal = dorsal;
        this.puntos_anotados = puntos_anotados;
        this.rebotes = rebotes;
        this.asistencias = asistencias;
        this.puesto = puesto;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getPuntos_anotados() {
        return puntos_anotados;
    }

    public void setPuntos_anotados(int puntos_anotados) {
        this.puntos_anotados = puntos_anotados;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getRebotes() {
        return rebotes;
    }

    public void setRebotes(int rebotes) {
        this.rebotes = rebotes;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    @Override
    public String toString() {
        return super.toString() + " .Jugador_Basket{" +
                "dorsal=" + dorsal +
                ", puntos_anotados=" + puntos_anotados +
                ", rebotes=" + rebotes +
                ", asistencias=" + asistencias +
                ", puesto='" + puesto + '\'' +
                "} ";
    }

    @Override
    // la valoración es la suma de los puntos, rebotes y asistencias
    public double valorar() {
        return puntos_anotados+rebotes+asistencias;
    }
}

// No cambies el código de esta clase, no modiques ni añadas nada
// solo puedes cambiar el package para tu proyecto de Intellj IDEA, NetBeans o Eclipse
