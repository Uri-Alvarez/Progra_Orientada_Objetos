package Packages;

import java.time.LocalDateTime;

import Users.DistributionPoints;
import Users.User;

public abstract class Package {
    private User sender; // Who is sending the package?
    private User recipient; // Who gets the package?
    private DistributionPoints destination;

    // Constructor
    public Package(User sender, User recipient, DistributionPoints destination) {
        this.sender = sender;
        this.recipient = recipient;
        this.destination = destination;
    }

    // Getters
    public User getSender() {
        return sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public DistributionPoints getDestination() {
        return destination;
    }

    /**
     * Returns a java date time of the estimate time of arrival of the package.
     * Hint: use the now method from java time to get the current time and the plus methods
     * to add an offset to the current time
     */
    public LocalDateTime getEstimateArrival() {
        return LocalDateTime.now().plusHours((long) destination.getArrivalTime());
    }

    /**
     * Estimates the cost of the package.
     * If we are sending a package, the cost is multiplied by the weight of the package.
     * If we are sending a letter, the cost is just the price of sending a 1kg package.
     * @example: Sending a package of 5kg to QROO = 5 * 3.70
     */
    public abstract double estimatePrice();
}
