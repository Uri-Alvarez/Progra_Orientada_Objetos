import java.util.Scanner;

import Managment.FlightManager;
import Tickets.Ticket;
import Tickets.TicketException;
import Users.User;
import Users.UserException;

public class Main {
    public static void main(String[] args) {
        FlightManager flightManager = new FlightManager();
        try {
            User user = flightManager.createUser();
            flightManager.displayFlightDashboard();
            System.out.println("Enter Flight ID to buy a ticket:");
            Scanner scanner = new Scanner(System.in);
            String flightId = scanner.nextLine();
            String ticketId = flightManager.buyTicket(flightId, "A-05", user);
            Ticket ticket = flightManager.retrieveFlightDetails(ticketId);
            System.out.println("Flight Details for Ticket ID " + ticketId + ":");
            System.out.println(ticket);
        } catch (UserException | TicketException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}