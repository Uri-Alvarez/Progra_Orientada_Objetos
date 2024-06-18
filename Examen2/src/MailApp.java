import java.time.LocalDateTime;
import java.util.Scanner;

import Users.User;
import Packages.Package;
import Packages.Letter;
import Packages.MailItem;
import Users.DistributionPoints;

public class MailApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Sender Information:");
            User sender = createUser(scanner);

            System.out.println("Recipient Information:");
            User recipient = createUser(scanner);

            System.out.println("Is this a letter or a package? (Enter 'letter' or 'package'):");
            String type = scanner.nextLine().trim().toLowerCase();

            DistributionPoints destination = getDestination(scanner);

            if (destination == null) {
                System.out.println("Invalid destination. The package cannot be sent.");
                return;
            }

            Package mailItem;
            if (type.equals("letter")) {
                mailItem = new Letter(sender, recipient, destination);
            } else if (type.equals("package")) {
                System.out.println("Enter the weight of the package in kg:");
                double weight = Double.parseDouble(scanner.nextLine().trim());

                System.out.println("Enter the description of the package:");
                String description = scanner.nextLine().trim();

                mailItem = new MailItem(sender, recipient, destination, weight, description);
            } else {
                System.out.println("Invalid type. Please enter 'letter' or 'package'.");
                return;
            }

            System.out.println("Estimated arrival time: " + mailItem.getEstimateArrival());
            System.out.println("Estimated cost: $" + mailItem.estimatePrice());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static User createUser(Scanner scanner) throws User.UserException {
        System.out.println("Enter full name:");
        String fullName = scanner.nextLine().trim();

        System.out.println("Enter address:");
        String address = scanner.nextLine().trim();

        System.out.println("Enter phone number:");
        String phoneNumber = scanner.nextLine().trim();

        System.out.println("Enter email:");
        String email = scanner.nextLine().trim();

        return new User(fullName, address, phoneNumber, email);
    }

    private static DistributionPoints getDestination(Scanner scanner) {
        System.out.println("Enter destination (OAX, QROO, MOR, QRO, SIN):");
        String destinationCode = scanner.nextLine().trim().toUpperCase();

        for (DistributionPoints point : DistributionPoints.values()) {
            if (point.getCode().equals(destinationCode)) {
                return point;
            }
        }
        return null;
    }
}
