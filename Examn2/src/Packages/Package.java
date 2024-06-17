package Packages;

import java.time.LocalDateTime;

import Users.User;

/**
 * Represents the most abstract type of package, either a letter or a package.
 * This class is intended to be extended by more specific types of packages.
 */
public abstract class Package {
    // Attributes
    private User sender;    // Who is sending the package?
    private User recipient; // Who gets the package?

    // Constructor
    public Package(User sender, User recipient) {
        this.sender = sender;
        this.recipient = recipient;
    }

    // Getters
    public User getSender() {
        return sender;
    }

    public User getRecipient() {
        return recipient;
    }

    // Setters
    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    /**
     * Returns a java date time of the estimated time of arrival of the package.
     * Uses the current time and adds the estimated delivery time.
     *
     * @param deliveryHours The estimated delivery time in hours.
     * @return The estimated arrival time as a LocalDateTime object.
     */
    public LocalDateTime getEstimateArrival(double deliveryHours) {
        LocalDateTime currentTime = LocalDateTime.now(); // Get the current time
        return currentTime.plusHours((long) deliveryHours); // Add the estimated delivery time
    }

    /**
     * Abstract method to estimate the cost of the package.
     * Implementations will define how the cost is calculated.
     * - For a package, the cost is multiplied by the weight of the package.
     * - For a letter, the cost is just the price of sending a 1kg package.
     *
     * @return The estimated cost of the package.
     */
    public abstract double estimatePrice();
}
