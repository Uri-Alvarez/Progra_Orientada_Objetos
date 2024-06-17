package Packages;

import Users.User;

/**
 * Represents a letter with no additional information needed other than the sender and recipient.
 */
public class Letter extends Package {
    // Constructor
    public Letter(User sender, User recipient) {
        super(sender, recipient);
    }

    /**
     * Estimates the cost of sending a letter.
     * The cost is the same as sending a 1kg package.
     *
     * @return The estimated cost of the letter.
     */
    @Override
    public double estimatePrice() {
        // Assuming a default cost per kg for letters, for example 5.0 USD.
        return 5.0; 
    }
}
