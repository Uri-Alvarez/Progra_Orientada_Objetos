package Accounts;

import java.util.HashMap;

public interface AccountInterface {
    void createAccount(String name, String email, String phoneNumber, double initialBalance) throws AccountCreationException;
    String getAccountNumber();
    boolean setEmail(String email) throws AccountException;
    boolean setPhoneNumber(String phoneNumber) throws AccountException;
    boolean setName(String name) throws AccountException;
    double getBalance();
    double withdraw(double amount) throws AccountException;
    double transfer(double amount, String concept) throws AccountException;
    String consultTransaction(String Id) throws AccountException;
}
