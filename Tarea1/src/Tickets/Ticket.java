package Tickets;

import Users.User;

public class Ticket {
    private String id;
    private String flightId;
    private String seatNumber;
    private User user;

    public Ticket(String id, String flightId, String seatNumber, User user) {
        this.id = id;
        this.flightId = flightId;
        this.seatNumber = seatNumber;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + id + ", Flight ID: " + flightId + ", Seat Number: " + seatNumber + ", Passenger: " + user.getFullName();
    }
}
