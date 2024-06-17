package Packages;

import Users.User;

/**
 * Represents a mail item with additional information such as weight and description of the content.
 */
public class MailItem extends Package {
    // Additional attributes
    private double weight;       // Weight of the mail item
    private String description;  // Description of the content

    // Constructor
    public MailItem(User sender, User recipient, double weight, String description) {
        super(sender, recipient);
        this.weight = weight;
        this.description = description;
    }

    // Getters
    public double getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Estimates the cost of sending the mail item.
     * The cost is calculated based on the weight of the mail item.
     *
     * @return The estimated cost of the mail item.
     */
    @Override
    public double estimatePrice() {
        // Assuming we have a method to get the cost per kg based on the destination.
        // For simplicity, let's assume a flat rate of 3.0 USD per kg.
        double costPerKg = 3.0; 
        return weight * costPerKg;
    }
}
