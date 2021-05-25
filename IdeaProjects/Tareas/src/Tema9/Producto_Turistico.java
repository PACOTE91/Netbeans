package Tema9;

import java.io.Serializable;

public abstract class Producto_Turistico implements Estadisticas, Serializable {
    String descripcion;
    int num_adultos;
    int num_ninos;
    static int total_productos_turisticos=0;

    public Producto_Turistico(String descripcion, int num_adultos, int num_ninos) {
        this.descripcion = descripcion;
        this.num_adultos = num_adultos;
        this.num_ninos = num_ninos;
        total_productos_turisticos ++;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNum_adultos() {
        return num_adultos;
    }

    public void setNum_adultos(int num_adultos) {
        this.num_adultos = num_adultos;
    }

    public int getNum_ninos() {
        return num_ninos;
    }

    public void setNum_ninos(int num_ninos) {
        this.num_ninos = num_ninos;
    }

    public static int getTotal_productos_turisticos() {
        return total_productos_turisticos;
    }

    abstract public double precio();

    @Override
    public String toString() {
        return "|| Producto Turistico: " +
                "Descripcion " + descripcion + '\'' +
                ",Numero adultos " + num_adultos +
                ",Numero niños " + num_ninos;
    }
}
