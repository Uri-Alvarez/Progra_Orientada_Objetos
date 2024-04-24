package Exam;

import java.util.Random;

public class Ticket {
	// Param Ticket class
    private String ticketId;
    private String flightId;
    private String userInfo;
    private String fecha;
    private double ticketPrice;
    
    //Constructor Ticket class
    public Ticket(String flightId, String userInfo, String fecha, double ticketPrice) {
        this.ticketId = generateTicketId();
        this.flightId = flightId;
        this.userInfo = userInfo;
        this.fecha = fecha;
        this.ticketPrice = ticketPrice;
    }

    //Method to generate a ticket
	private String generateTicketId() {
		Random random = new Random();
		int randomNumber = 0000 + random.nextInt(9999);
		return "RE-" + randomNumber;
	}

	//Getters y Setters
	 public String getTicketId() {
	        return ticketId;
	    }

	 public String getFlightId() {
	        return flightId;
	    }

	 public void setFlightId(String flightId) {
	        this.flightId = flightId;
	    }
	    
	 public String getUserInfo() {
	        return userInfo;
	    }

	 public void setUserInfo(String userInfo) {
	        this.userInfo = userInfo;
	    }

	 public String getFecha() {
	        return fecha;
	    }

	 public void setFecha(String fecha) {
	        this.fecha = fecha;
	    }
	    
	 public double getTicketPrice() {
	        return ticketPrice;
	    }

	 public void setTicketPrice(double ticketPrice) {
	        this.ticketPrice = ticketPrice;
	 }
	 
}


