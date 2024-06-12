import java.util.Scanner;

import Figures.Ellipse;
import Figures.Triangle;
import Shapes.Shape;
import SubFigures.Circle;
import SubFigures.Rectangle;
import SubFigures.Square;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelect a shape to calculate area and perimeter:");
            System.out.println("1. Circle");
            System.out.println("2. Ellipse");
            System.out.println("3. Triangle");
            System.out.println("4. Rectangle");
            System.out.println("5. Square");
            System.out.println("6. Exit");

            int menu = scanner.nextInt();
            if (menu == 6) {
                break;
            }
            Shape shape = null;

            switch (menu) {
                case 1:
                    System.out.print("Enter radius: ");
                    double radius = scanner.nextDouble();
                    shape = new Circle(radius);
                    break;
                case 2:
                    System.out.print("Enter major axis: ");
                    double majorAxis = scanner.nextDouble();
                    System.out.print("Enter minor axis: ");
                    double minorAxis = scanner.nextDouble();
                    shape = new Ellipse(majorAxis, minorAxis);
                    break;
                case 3:
                    System.out.print("Enter side 1: ");
                    double side1 = scanner.nextDouble();
                    System.out.print("Enter side 2: ");
                    double side2 = scanner.nextDouble();
                    System.out.print("Enter side 3: ");
                    double side3 = scanner.nextDouble();
                    shape = new Triangle(side1, side2, side3);
                    break;
                case 4:
                    System.out.print("Enter base: ");
                    double length = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    double width = scanner.nextDouble();
                    shape = new Rectangle(length, width);
                    break;
                case 5:
                    System.out.print("Enter side: ");
                    double side = scanner.nextDouble();
                    shape = new Square(side);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            if (shape != null) {
                System.out.println("Area: " + shape.getArea());
                System.out.println("Perimeter: " + shape.getPerimeter());
            }
        }

        scanner.close();
    }
}
