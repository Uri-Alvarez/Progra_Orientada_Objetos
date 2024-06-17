package Users;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String fullName;
    private String address;
    private String phoneNumber;
    private String email;

    // Constructor
    public User(String fullName, String address, String phoneNumber, String email) throws UserException {
        setFullName(fullName);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }

    // Getters
    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    // Setters with validation
    public void setFullName(String fullName) throws UserException {
        // Validate full name (no numbers and special characters)
        if (!fullName.matches("[a-zA-Z\\s]+")) {
            throw new UserException("Invalid full name format. Only alphabetic characters and spaces are allowed.");
        }
        this.fullName = fullName;
    }

    public void setAddress(String address) throws UserException {
        // Validate address format (Street Address, Neighborhood, City, 5-digit Postal Code OAX)
        if (!address.matches("[a-zA-Z\\\\s]+")) {
            throw new UserException("Invalid address format. It should be in the format: Street Address, Neighborhood, City, 5-digit Postal Code OAX.");
        }
        this.address = address;
    }


    public void setPhoneNumber(String phoneNumber) throws UserException {
        // Validate phone number format (+52 followed by 10 digits)
        if (!phoneNumber.matches("^\\+52\\d{10}$")) {
            throw new UserException("Invalid phone number format. It should start with +52 and be followed by 10 digits.");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) throws UserException {
        // Validate email format (must be a Gmail address)
        if (!email.endsWith("@gmail.com")) {
            throw new UserException("Invalid email format. Only @gmail.com addresses are allowed.");
        }
        this.email = email;
    }

    // Custom exception class for User validation
    public static class UserException extends Exception {
        public UserException(String message) {
            super(message);
        }
    }
}
