package Accounts;

import java.util.HashMap;
import java.util.regex.Pattern;

public abstract class AbstractAccount implements AccountInterface {
    private String name;
    private String email;
    private String phoneNumber;
    private double balance;
    private String accountNumber;
    private double accountLimit;
    private double openFee;
    private double maintenanceFee;
    protected HashMap<String, HashMap<String, Object>> movements = new HashMap<>();

    public AbstractAccount(double openFee, double maintenanceFee) {
        this.openFee = openFee;
        this.maintenanceFee = maintenanceFee;
    }

    @Override
    public boolean setEmail(String email) throws AccountException {
        if (Pattern.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", email)) {
            this.email = email;
            return true;
        } else {
            throw new AccountException("Invalid email format.");
        }
    }

    @Override
    public boolean setPhoneNumber(String phoneNumber) throws AccountException {
        if (Pattern.matches("^\\+?[0-9]{10,13}$", phoneNumber)) {
            this.phoneNumber = phoneNumber;
            return true;
        } else {
            throw new AccountException("Invalid phone number format.");
        }
    }

    @Override
    public boolean setName(String name) throws AccountException {
        if (name != null && !name.isEmpty()) {
            this.name = name;
            return true;
        } else {
            throw new AccountException("Name cannot be empty.");
        }
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String consultTransaction(String Id) throws AccountException {
        if (movements.containsKey(Id)) {
            return movements.get(Id).toString();
        } else {
            throw new AccountException("Transaction ID not found.");
        }
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    protected void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    protected void addMovement(String id, String type, String concept, double amount) {
        HashMap<String, Object> movement = new HashMap<>();
        movement.put("type", type);
        movement.put("concept", concept);
        movement.put("amount", amount);
        movements.put(id, movement);
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + "\nName: " + name + "\nEmail: " + email + "\nPhone Number: " + phoneNumber + "\nBalance: " + balance;
    }
}
