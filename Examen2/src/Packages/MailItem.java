package Packages;

import Users.DistributionPoints;
import Users.User;

public class MailItem extends Package {
    private double weight; // Weight of the mail item in kilograms
    private String description; // Description of the content

    public MailItem(User sender, User recipient, DistributionPoints destination, double weight, String description) {
        super(sender, recipient, destination);
        this.weight = weight;
        this.description = description;
    }

    @Override
    public double estimatePrice() {
        return weight * getDestination().getCostPerKg();
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
}
