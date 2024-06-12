package SubFigures;

import Figures.Ellipse;

public class Circle extends Ellipse {
	 private double radius;
	
	 public Circle(double radius) {
	     super(radius, radius);
	     this.radius = radius;
	 }
	
	 @Override
	 public double getArea() {
	     return Math.PI * radius * radius;
	 }
	
	 @Override
	 public double getPerimeter() {
	     return 2 * Math.PI * radius;
	 }
}
