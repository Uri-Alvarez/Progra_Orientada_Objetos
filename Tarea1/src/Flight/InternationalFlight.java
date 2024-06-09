package Flight;

import java.util.Random;

import Tickets.Ticket;
import Users.User;

import java.util.ArrayList;
import java.util.List;

public class InternationalFlight extends Flight {
    private List<String> seats;

    public InternationalFlight(Destinations destination) {
        super(Destinations.CDMX, destination); // Se asume que todos los vuelos internacionales salen de CDMX
        initializeSeats();
    }

    private void initializeSeats() {
        seats = new ArrayList<>();
        // Lógica para inicializar los asientos de un vuelo internacional
        // Por ejemplo:
        for (char row = 'A'; row <= 'F'; row++) {
            for (int num = 1; num <= 10; num++) {
                seats.add(row + "-" + String.format("%02d", num)); // Agregar asiento en formato A-01, A-02, etc.
            }
        }
    }

    @Override
    public void displayFlightMap() {
        System.out.println("Flight Map for International Flight to " + getDestination() + ":");
        for (String seat : seats) {
            System.out.print("|" + seat + "| "); // Mostrar el mapa de asientos
        }
        System.out.println();
    }

    @Override
    public String bookTicket(String seatNumber, User user) {
        // Lógica para reservar un ticket en un vuelo internacional
        // Por ejemplo:
        if (seats.contains(seatNumber)) {
            seats.remove(seatNumber);
            return "RE-" + (int) (Math.random() * 1000); // ID de ticket generado aleatoriamente
        } else {
            return null; // Si el asiento no está disponible
        }
    }

    @Override
    public Ticket getTicketById(String ticketId) {
        // Implementación para obtener un ticket por ID, si es necesario
        return null;
    }
}
