package Flight;

import Tickets.Ticket;
import Tickets.TicketException;
import Users.User;

public abstract class Flight {
    private String id;
    private Destinations origin;
    private Destinations destination;
    private double ticketPrice;

    public Flight(Destinations origin, Destinations destination) {
        this.origin = origin;
        this.destination = destination;
        generateId();
        generateTicketPrice();
    }

    private void generateId() {
        // Generate a unique ID for the flight (can be based on origin and destination)
        this.id = origin.toString().substring(0, 3) + "-" + destination.toString().substring(0, 3) + "-" + (int) (Math.random() * 1000);
    }

    private void generateTicketPrice() {
        // Generate a random ticket price
        this.ticketPrice = Math.round((300 + Math.random() * 500) * 100.0) / 100.0; // Random price between $300 and $800
    }

    public String getId() {
        return id;
    }

    public Destinations getOrigin() {
        return origin;
    }

    public Destinations getDestination() {
        return destination;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    // Método abstracto para mostrar el mapa de asientos
    public abstract void displayFlightMap();

    // Método abstracto para reservar un ticket
    public abstract String bookTicket(String seatNumber, User user) throws TicketException;

    // Método abstracto para obtener un ticket por ID
    public abstract Ticket getTicketById(String ticketId);
}
