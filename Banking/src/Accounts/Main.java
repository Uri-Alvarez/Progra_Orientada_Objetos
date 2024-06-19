package Accounts;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continueCreating = true;

        while (continueCreating) {
            try {
                System.out.println("Enter account type (1: Personal, 2: Savings, 3: Business): ");
                int accountType = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.println("Enter name: ");
                String name = scanner.nextLine();

                System.out.println("Enter email: ");
                String email = scanner.nextLine();

                System.out.println("Enter phone number: ");
                String phoneNumber = scanner.nextLine();

                System.out.println("Enter initial balance: ");
                double initialBalance = scanner.nextDouble();

                AbstractAccount account = null;

                switch (accountType) {
                    case 1:
                        account = new PersonalAccount();
                        break;
                    case 2:
                        account = new SavingsAccount();
                        break;
                    case 3:
                        account = new BusinessAccount();
                        break;
                    default:
                        System.out.println("Invalid account type.");
                        continue;
                }

                account.createAccount(name, email, phoneNumber, initialBalance);
                System.out.println("Account created successfully!");
                System.out.println(account);

            } catch (AccountCreationException e) {
                System.out.println("Account creation failed: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Do you want to create another account? (yes/no): ");
            String userResponse = scanner.next();
            if (!userResponse.equalsIgnoreCase("yes")) {
                continueCreating = false;
            }

            scanner.nextLine(); // Consume newline if needed
        }

        scanner.close();
    }
}
