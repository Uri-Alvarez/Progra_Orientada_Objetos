package Accounts;

import java.util.UUID;

public class SavingsAccount extends AbstractAccount {
    private static final double MAX_WITHDRAWAL_LIMIT = 500;
    private static final int MAX_WITHDRAWALS = 2;
    private static final double INTEREST_RATE = 0.15;
    private int withdrawalsCount = 0;

    public SavingsAccount() {
        super(0, 0);
    }

    @Override
    public void createAccount(String name, String email, String phoneNumber, double initialBalance) throws AccountCreationException {
        try {
            setName(name);
            setEmail(email);
            setPhoneNumber(phoneNumber);
            setBalance(initialBalance);
            setAccountNumber(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 18));
        } catch (AccountException e) {
            throw new AccountCreationException(e.getMessage());
        }
    }

    @Override
    public double withdraw(double amount) throws AccountException {
        if (withdrawalsCount >= MAX_WITHDRAWALS || amount > MAX_WITHDRAWAL_LIMIT) {
            throw new AccountException("Withdrawal limit exceeded.");
        }
        setBalance(getBalance() - amount);
        addMovement(UUID.randomUUID().toString(), "withdrawal", "", amount);
        withdrawalsCount++;
        return amount;
    }

    @Override
    public double transfer(double amount, String concept) throws AccountException {
        throw new AccountException("Transfers not allowed on Savings Account.");
    }

    public double estimateInterest(int days) {
        return getBalance() * Math.pow(1 + INTEREST_RATE / 365, days);
    }
}
