public class Venta_Tienda implements Estadisticas{
    private String nombre_tienda;
    private Trabajador currante;
    private double total_ventas;

    public Venta_Tienda(String nombre_tienda, Trabajador currante, double total_ventas) {
        this.nombre_tienda = nombre_tienda;
        this.currante = currante;
        this.total_ventas = total_ventas;
    }


    public String getNombre_tienda() {
        return nombre_tienda;
    }

    public void setNombre_tienda(String nombre_tienda) {
        this.nombre_tienda = nombre_tienda;
    }

    public Trabajador getCurrante() {
        return currante;
    }

    public void setCurrante(Trabajador currante) {
        this.currante = currante;
    }

    public double getTotal_ventas() {
        return total_ventas;
    }

    public void setTotal_ventas(double total_ventas) {
        this.total_ventas = total_ventas;
    }

    // La valoración va desde 0 a 10
    // cada 40 € vendidos es 1 punto de valoración
    // con un máximo de 10 puntos de valoración
    @Override
    public double valorar() {
        double valor = 0;

        valor = total_ventas / 40;

        if (valor > 10)
            valor = 10;

        return valor;
    }

    @Override
    public double coste() {
        return currante.getSalario();
    }

    @Override
    public String toString() {
        return "Venta_Tienda{" +
                "nombre_tienda='" + nombre_tienda + '\'' +
                ", currante=" + currante +
                ", total_ventas=" + total_ventas +
                '}';
    }
}
