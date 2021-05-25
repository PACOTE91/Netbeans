//package com.company;

// No cambies el código de esta clase, no modiques ni añadas nada
// solo puedes cambiar el package para tu proyecto de Intellj IDEA, NetBeans o Eclipse

public abstract class Seleccion_Basket {
    private String nombre;
    private String apellidos;
    private int edad;

    public Seleccion_Basket(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Seleccion_Basket{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                '}';
    }

    // método abastracto que implementarán las clases que hereden de esta
    public abstract double valorar();
}

// No cambies el código de esta clase, no modiques ni añadas nada
// solo puedes cambiar el package para tu proyecto de Intellj IDEA, NetBeans o Eclipse
