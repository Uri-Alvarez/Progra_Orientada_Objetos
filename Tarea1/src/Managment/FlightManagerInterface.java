package Managment;

import Tickets.Ticket;
import Tickets.TicketException;
import Users.User;
import Users.UserException;

public interface FlightManagerInterface {
    User createUser() throws UserException;
    void displayFlightDashboard();
    String buyTicket(String flightId, String seatNumber, User user) throws TicketException;
    Ticket retrieveFlightDetails(String ticketId) throws TicketException;
}
