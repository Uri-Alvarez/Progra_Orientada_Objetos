package Accounts;

import java.util.UUID;

public class BusinessAccount extends AbstractAccount {
    private static final double MIN_BALANCE = 5000;
    private static final double OPEN_FEE = 100;
    private static final double MAINTENANCE_FEE = 50;

    public BusinessAccount() {
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
        if (getBalance() - amount < MIN_BALANCE) {
            throw new AccountException("Withdrawal would result in balance falling below minimum required.");
        }
        setBalance(getBalance() - amount);
        addMovement(UUID.randomUUID().toString(), "withdrawal", "", amount);
        return amount;
    }

    @Override
    public double transfer(double amount, String concept) throws AccountException {
        if (!BusinessCategory.isValidCategory(concept)) {
            throw new AccountException("Invalid business transaction category.");
        }
        if (getBalance() - amount < MIN_BALANCE) {
            throw new AccountException("Transfer would result in balance falling below minimum required.");
        }
        setBalance(getBalance() - amount);
        addMovement(UUID.randomUUID().toString(), "transfer", concept, amount);
        return amount;
    }
}

enum BusinessCategory {
    PAYMENTS, MAINTENANCE, SUPPLIES, SALARIES, RENT, UTILITIES, ADVERTISING, RESEARCH, INSURANCE, TAXES;

    public static boolean isValidCategory(String category) {
        try {
            BusinessCategory.valueOf(category.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
