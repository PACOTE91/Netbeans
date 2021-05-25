package Tema9;

import java.io.Serializable;

public class Cliente implements Serializable {
    String nombre;
    String apellidos;
    int DNI;
    static int total_clientes=0;

    public Cliente(String nombre, String apellidos, int DNI) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        total_clientes++;
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

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public static int getTotal_clientes() {
        return total_clientes;
    }

    @Override
    public String toString() {
        return "|| Cliente: " +
                "Nombre " + nombre + '\'' +
                ", Apellido '" + apellidos + '\'' +
                ", DNI " + DNI;
    }
}
