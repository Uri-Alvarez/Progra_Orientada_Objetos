package Exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Flight {
	// Param Flight class
	private String flightId;
    private int numberSits = 40;
    private double ticketPrice;
    private String dateTime;
    private String gate;
    private Map<String, Ticket> selledTickets = new HashMap<>();
    enum destination {
        MX, UK, US, FR, ES, IT, CH, JP
    }
    
    
    //Constructor Flight class
    public Flight(destination origin, destination destination, String dateTime) {
        this.flightId = origin.name() + destination.name() + "-" + generateRandomNumber(0000, 9999);
        this.ticketPrice = generateRandomPrice();
        this.dateTime = dateTime;
        this.gate = generateGate();
    }

    private int generateRandomNumber(int min, int max) {
	        Random random = new Random();
	        return random.nextInt(max - min + 1) + min;
			}

    private double generateRandomPrice() {
        return generateRandomNumber(1000, 2000);
    }
    
    private String generateGate() {
        int number = generateRandomNumber(1, 9);
        return "Gate" + "-" + number;
    }

}
