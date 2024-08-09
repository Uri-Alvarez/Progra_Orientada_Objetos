package Accounts;

import java.util.UUID;

public class PersonalAccount extends AbstractAccount {
    private static final double MAX_WITHDRAWAL_LIMIT = 500;
    private static final double MIN_BALANCE = 200;
    private static final double OPEN_FEE = 2;
    private static final double MAINTENANCE_FEE = 10;

    public PersonalAccount() {
        super(OPEN_FEE, MAINTENANCE_FEE);
    }

    @Override
    public void createAccount(String name, String email, String phoneNumber, double initialBalance) throws AccountCreationException {
        try {
            if (initialBalance < MIN_BALANCE + OPEN_FEE + MAINTENANCE_FEE) {
                throw new AccountCreationException("Initial balance is not sufficient.");
            }
            setName(name);
            setEmail(email);
            setPhoneNumber(phoneNumber);
            setBalance(initialBalance - OPEN_FEE - MAINTENANCE_FEE);
            setAccountNumber(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 18));
        } catch (AccountException e) {
            throw new AccountCreationException(e.getMessage());
        }
    }

    @Override
    public double withdraw(double amount) throws AccountException {
        if (amount > MAX_WITHDRAWAL_LIMIT || getBalance() - amount < MIN_BALANCE) {
            throw new AccountException("Withdrawal amount exceeds limit or minimum balance requirement.");
        }
        setBalance(getBalance() - amount);
        addMovement(UUID.randomUUID().toString(), "withdrawal", "", amount);
        return amount;
    }

    @Override
    public double transfer(double amount, String concept) throws AccountException {
        if (amount > MAX_WITHDRAWAL_LIMIT || getBalance() - amount < MIN_BALANCE) {
            throw new AccountException("Transfer amount exceeds limit or minimum balance requirement.");
        }
        setBalance(getBalance() - amount);
        addMovement(UUID.randomUUID().toString(), "transfer", concept, amount);
        return amount;
    }
}
