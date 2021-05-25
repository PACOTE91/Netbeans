package Tema9;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class Ticket implements Estadisticas, Serializable {

    int numero_ticket_actual;
    Date fecha_ticket;
    Cliente cliente_ticket;
    Producto_Turistico paquete_turistico [];
    static int total_tickets=0;

    public Ticket(Cliente cliente_ticket, Producto_Turistico[] paquete_turistico) {
        total_tickets++;
        numero_ticket_actual = total_tickets;
        fecha_ticket = new Date();
        this.cliente_ticket = cliente_ticket;
        this.paquete_turistico = paquete_turistico;

    }



    public int getNumero_ticket_actual() {
        return numero_ticket_actual;
    }

    public void setNumero_ticket_actual(int numero_ticket_actual) {
        this.numero_ticket_actual = numero_ticket_actual;
    }

    public Date getFecha_ticket() {
        return fecha_ticket;
    }

    public void setFecha_ticket(Date fecha_ticket) {
        this.fecha_ticket = fecha_ticket;
    }

    public Cliente getCliente_ticket() {
        return cliente_ticket;
    }

    public void setCliente_ticket(Cliente cliente_ticket) {
        this.cliente_ticket = cliente_ticket;
    }

    public Producto_Turistico[] getPaquete_turistico() {
        return paquete_turistico;
    }

    public void setPaquete_turistico(Producto_Turistico[] paquete_turistico) {
        this.paquete_turistico = paquete_turistico;
    }

    public static int getTotal_tickets() {
        return total_tickets;
    }

    public static void setTotal_tickets(int total_tickets) {
        Ticket.total_tickets = total_tickets;
    }

    public double precio() {
        double total=0;

        for(Producto_Turistico producto:paquete_turistico){
            if(producto!=null)
                total+=producto.precio();
        }

        return total;
    }


    @Override
    public String toString(){
        return"|| Ticket: "+
                "Número de ticket: "+numero_ticket_actual+
                ", Fecha del ticket: "+fecha_ticket+
                ", Datos cliente: "+cliente_ticket+
                ", Paquete Turistico Contratado"+ Arrays.toString(paquete_turistico);
    }
}
