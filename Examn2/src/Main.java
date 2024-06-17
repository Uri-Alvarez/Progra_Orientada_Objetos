import java.util.Scanner;

public class Main {
    
    // Define allowed destination patterns for packages
    private static final String ALLOWED_DEST_PATTERN = ".*(OAX).*"; // Matches any address containing 'OAX'

    // Main method to run the application
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Collect user information
        System.out.println("Enter your details:");
        String senderPhone = promptUserInput(scanner, "Phone number:");
        String senderName = promptUserInput(scanner, "Name:");
        String senderAddress = promptUserInput(scanner, "Address:");
        String senderEmail = promptUserInput(scanner, "Email:");
        
        // Collect recipient information
        System.out.println("\nEnter recipient details:");
        String recipientPhone = promptUserInput(scanner, "Phone number:");
        String recipientName = promptUserInput(scanner, "Name:");
        String recipientAddress = promptUserInput(scanner, "Address:");
        String recipientEmail = promptUserInput(scanner, "Email:");
        
        // Determine if sending a letter or package
        System.out.println("\nChoose type of item to send:");
        System.out.println("1. Letter");
        System.out.println("2. Package");
        int itemType = Integer.parseInt(scanner.nextLine());
        
        if (itemType == 1) {
            // Sending a letter
            System.out.println("\nSending a letter...");
            System.out.println("Sender: " + senderName);
            System.out.println("Recipient: " + recipientName);
            System.out.println("Letter sent successfully.");
        } else if (itemType == 2) {
            // Sending a package
            System.out.println("\nSending a package...");
            double weight = Double.parseDouble(promptUserInput(scanner, "Enter package weight (kg):"));
            
            // Validate destination for package
            if (!isValidDestination(recipientAddress)) {
                System.out.println("Package cannot be sent to the specified destination.");
            } else {
                // Estimate arrival time and cost
                String estimatedArrival = estimateArrivalTime(recipientAddress);
                double estimatedCost = calculateShippingCost(weight);
                
                // Display shipping details
                System.out.println("\nShipping details:");
                System.out.println("Sender: " + senderName);
                System.out.println("Recipient: " + recipientName);
                System.out.println("Estimated arrival time: " + estimatedArrival);
                System.out.printf("Estimated shipping cost: $%.2f%n", estimatedCost);
                System.out.println("Package sent successfully.");
            }
        } else {
            System.out.println("Invalid choice. Please select 1 or 2.");
        }
        
        scanner.close();
    }
    
    // Helper method to prompt user input and handle exceptions
    private static String promptUserInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt + " ");
                return scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }
    
    // Method to validate if destination address is allowed for packages
    private static boolean isValidDestination(String address) {
        return address.matches(ALLOWED_DEST_PATTERN);
    }
    
    // Method to estimate arrival time based on predefined rules
    private static String estimateArrivalTime(String destinationAddress) {
        // Assume simple logic for demonstration
        return "3-5 business days"; // Example estimation
    }
    
    // Method to calculate shipping cost based on package weight
    private static double calculateShippingCost(double weight) {
        // Assume simple cost calculation for demonstration
        return 10 + (2 * weight); // Example cost
    }
}
