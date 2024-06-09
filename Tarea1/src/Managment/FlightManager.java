package Managment;

import Flight.Flight;
import Flight.DomesticFlight;
import Flight.InternationalFlight;
import Flight.PrivateFlight;
import Flight.Destinations;
import Tickets.Ticket;
import Tickets.TicketException;
import Users.User;
import Users.UserException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FlightManager implements FlightManagerInterface {
    private List<User> users;
    private List<Flight> flights;

    public FlightManager() {
        this.users = new ArrayList<>();
        this.flights = new ArrayList<>();
        initializeFlights();
    }
    
    private void initializeFlights() {
        Random random = new Random();
        
        // Initialize some example flights
        for (Destinations destination : Destinations.values()) {
            if (destination != Destinations.CDMX) {
                if (destination.getDistance() > 1000) {
                    flights.add(new InternationalFlight(destination));
                } else if (destination.getDistance() > 100) {
                    flights.add(new DomesticFlight(destination));
                } else {
                    flights.add(new PrivateFlight(destination));
                }
            }
        }
    }

    @Override
    public User createUser() throws UserException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Full Name:");
        String fullName = scanner.nextLine();
        System.out.println("Enter Email:");
        String email = scanner.nextLine();
        System.out.println("Enter Phone Number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter Country:");
        String country = scanner.nextLine();

        User newUser = new User(fullName, email, phoneNumber, country);
        users.add(newUser);
        return newUser;
    }

    @Override
    public void displayFlightDashboard() {
        System.out.println("| FLIGHT-ID | PRICE |");
        for (Flight flight : flights) {
            System.out.println("| " + flight.getId() + " | $" + flight.getTicketPrice() + " |");
        }
        System.out.println("+-----------------+");
    }

    @Override
    public String buyTicket(String flightId, String seatNumber, User user) throws TicketException {
        // Find the flight
        Flight selectedFlight = null;
        for (Flight flight : flights) {
            if (flight.getId().equals(flightId)) {
                selectedFlight = flight;
                break;
            }
        }
        if (selectedFlight == null) {
            throw new TicketException("Flight not found.");
        }

        // Show flight map
        System.out.println("Flight Map for " + selectedFlight.getId() + ":");
        selectedFlight.displayFlightMap();

        // Select seat
        System.out.println("Enter seat number (format: A-05):");
        // Validate seat number format using regex
        Scanner scanner = new Scanner(System.in);
        String inputSeatNumber = scanner.nextLine();
        if (!inputSeatNumber.matches("^[A-Z]-\\d{2}$")) {
            throw new TicketException("Invalid seat number format.");
        }

        // Purchase ticket
        String ticketId = selectedFlight.bookTicket(inputSeatNumber, user);
        System.out.println("Ticket purchased successfully. Your Ticket ID is: " + ticketId);
        return ticketId;
    }

    @Override
    public Ticket retrieveFlightDetails(String ticketId) throws TicketException {
        for (Flight flight : flights) {
            Ticket ticket = flight.getTicketById(ticketId);
            if (ticket != null) {
                return ticket;
            }
        }
        throw new TicketException("Ticket not found.");
    }
}
