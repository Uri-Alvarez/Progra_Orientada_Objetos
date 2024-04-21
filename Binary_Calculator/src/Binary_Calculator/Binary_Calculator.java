package Binary_Calculator;

import java.util.Scanner;

public class Binary_Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Binary Calculator");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Binary to Hex and Octal");
        System.out.println("3. Exit");
        System.out.print("Type a number to select an option: ");
        
        int option = scanner.nextInt();
        
        switch (option) {
            case 1 -> {
                System.out.print("Enter first binary number: "); 
                String bin1 = scanner.next();
                System.out.print("Enter second binary number: ");
                String bin2 = scanner.next();
                addBinary(bin1, bin2);
            }
            case 2 -> {
                System.out.print("Enter the binary number to reduce: ");
                String bin1 = scanner.next();
                System.out.print("Enter the binary number to subtract: ");
                String bin2 = scanner.next();
                subtractBinary(bin1, bin2);
            }
            case 3 -> {
                System.out.print("Enter a number for conversion: ");
                String numeroBinario = scanner.next();
                convert(numeroBinario);
            }
            default -> System.out.println("Invalid option. Try again.");
        }

        scanner.close();
    }//End Main

    private static void addBinary(String bin1, String bin2) {
        /*Converts a text string representing a binary number to its integer numerical equivalent and converts it to a float number.
        The "parseInt" method, which is 2, indicates that the string should be interpreted as a number in binary base.
        */
        float num1 = Integer.parseInt(bin1, 2);
        float num2 = Integer.parseInt(bin2, 2);
        float add = num1 + num2;
        System.out.println("Result of addition: " + add);
    }//End "addBinary" method

    private static void subtractBinary(String bin1, String bin2) {
        float num1 = Integer.parseInt(bin1, 2);
        float num2 = Integer.parseInt(bin2, 2);
        float subtract = num1 - num2;
        System.out.println("Result of addition: " + subtract);
    }//End "subtractBinary" method

    private static void convert(String numeroBinario) {
        int numero = Integer.parseInt(numeroBinario, 2);
        String hex = Integer.toHexString(numero); //Converts an integer to a hexadecimal representation and the result is a text string.
        String oct = Integer.toOctalString(numero); //Converts an integer to an octal base representation and the result is a text string.
        System.out.println("Hexadecimal: " + hex);
        System.out.println("Octal: " + oct);
    }//End "Convert" method
}//End "Binary_Calculator" class
