package Figures;

import Shapes.Shape;

public class Ellipse extends Shape {
	 private double majorAxis;
	 private double minorAxis;
	
	 public Ellipse(double majorAxis, double minorAxis) {
	     this.majorAxis = majorAxis;
	     this.minorAxis = minorAxis;
	 }
	
	 @Override
	 public int getNumberOfSides() {
	     return 1;
	 }
	
	 @Override
	 public double getArea() {
	     return Math.PI * majorAxis * minorAxis;
	 }
	
	 @Override
	 public double getPerimeter() {
	     return Math.PI*( (3*(majorAxis + minorAxis)) - (Math.sqrt((3*majorAxis + minorAxis) * (majorAxis + 3*minorAxis))));
	 }
}
