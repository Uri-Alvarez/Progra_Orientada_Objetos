package Figures;

import Shapes.Shape;

public abstract class Quadrilateral extends Shape {
	 private double side1;
	 private double side2;
	 private double side3;
	 private double side4;
	
	 public Quadrilateral(double side1, double side2, double side3, double side4) {
	     this.side1 = side1;
	     this.side2 = side2;
	     this.side3 = side3;
	     this.side4 = side4;
	 }
	
	 @Override
	 public int getNumberOfSides() {
	     return 4;
	 }
	
	 @Override
	 public double getPerimeter() {
	     return side1 + side2 + side3 + side4;
	 }
}
