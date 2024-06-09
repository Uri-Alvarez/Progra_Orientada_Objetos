package Users;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class User implements UserInterface {
	private String fullName;
    private String email;
    private String phoneNumber;
    private String country;

    public User(String fullName, String email, String phoneNumber, String country) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.country = country;
    }
	
    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public void setFullName(String fullName) throws UserException {
        if (!fullName.matches("^[a-zA-Z\\s]+$")) {
            throw new UserException("Full Name must not contain special characters or numbers.");
        }
        this.fullName = fullName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) throws UserException {
        if (!email.matches("^[\\w.-]+@gmail\\.com$")) {
            throw new UserException("Email must be of the form: myemail@gmail.com.");
        }
        this.email = email;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) throws UserException {
        if (!phoneNumber.matches("^\\+52\\d{10}$")) {
            throw new UserException("Phone Number must start with +52 and must have exactly 10 digits.");
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public void setCountry(String country) throws UserException {
        if (!country.equalsIgnoreCase("Mexico")) {
            throw new UserException("Country must be Mexico.");
        }
        this.country = country;
    }
}
