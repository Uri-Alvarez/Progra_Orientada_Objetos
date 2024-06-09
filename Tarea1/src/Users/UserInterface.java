package Users;

public interface UserInterface {
    String getFullName();
    void setFullName(String fullName) throws UserException;
    
    String getEmail();
    void setEmail(String email) throws UserException;
    
    String getPhoneNumber();
    void setPhoneNumber(String phoneNumber) throws UserException;
    
    String getCountry();
    void setCountry(String country) throws UserException;
}
