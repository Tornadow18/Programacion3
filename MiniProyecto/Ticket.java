package MiniProyecto;

public class Ticket {
    private Funcion funcion;
    private Asiento asiento;
    private double precio;

    public Ticket(Funcion funcionTicket, Asiento asientoTicket, double precioTicket) {
        funcion = funcionTicket;
        asiento = asientoTicket;
        precio = precioTicket;
    }

    public String toString() {
        return "Ticket: " + funcion.getPelicula().getNombre() + " | Sala: " + funcion.getSala().getNumero() +
               " | Asiento: " + asiento.getFila() + asiento.getNumero() + " | Precio: $" + precio;
    }
}