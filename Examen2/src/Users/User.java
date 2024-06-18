package Users;

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
        if (!fullName.matches("^[a-zA-Z\\s]+$")) {
            throw new UserException("Invalid full name. It should contain no numbers and no special characters.");
        }
        this.fullName = fullName;
    }

    public void setAddress(String address) throws UserException {
        if (!address.matches(".*\\d{5}.*OAX$") && !address.matches(".*\\d{5}.*QROO$") &&
            !address.matches(".*\\d{5}.*MOR$") && !address.matches(".*\\d{5}.*QRO$") &&
            !address.matches(".*\\d{5}.*SIN$")) {
            throw new UserException("Invalid address. It must contain a 5-digit postal code and end with 'OAX', 'QROO', 'MOR', 'QRO', or 'SIN'.");
        }
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) throws UserException {
        if (!phoneNumber.matches("^\\+52\\d{10}$")) {
            throw new UserException("Invalid phone number. It must start with +52 and have exactly 10 digits after that.");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) throws UserException {
        if (!email.matches("^[\\w._%+-]+@gmail\\.com$")) {
            throw new UserException("Invalid email. It must be a @gmail.com email.");
        }
        this.email = email;
    }

    // Custom exception class
    public static class UserException extends Exception {
        public UserException(String message) {
            super(message);
        }
    }
}
