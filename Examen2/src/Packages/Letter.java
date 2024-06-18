package Packages;

import Users.DistributionPoints;
import Users.User;

public class Letter extends Package {

    public Letter(User sender, User recipient, DistributionPoints destination) {
        super(sender, recipient, destination);
    }

    @Override
    public double estimatePrice() {
        return getDestination().getCostPerKg(); // Price for sending a 1kg letter
    }
}
