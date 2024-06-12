package SubFigures;

import Figures.Quadrilateral;

public class Rectangle extends Quadrilateral {
	 private double length;
	 private double width;
	
	 public Rectangle(double length, double width) {
	     super(length, width, length, width);
	     this.length = length;
	     this.width = width;
	 }
	
	 @Override
	 public double getArea() {
	     return length * width;
	 }
}
