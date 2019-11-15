
public class BridgePatternModifiedExample {

	public static void main(String[] args) {
		
		System.out.println("***Adapter Pattern Modified Example***\n");
		
		Rectangle rectangle = new Rectangle(20, 10);
		
		System.out.println("Area of Rectangle is : " + rectangle.calculateAreaOfRectangle() + " square unit.");
		
		Triangle triangle = new Triangle(10, 5);
		
		System.out.println("Area of Triangle is : " + triangle.calculateAreaOfTriangle() + " square unit.");
		
		RectInterface adapter = new TriangleAdapter(triangle);
		
		//Passing a Triangle instead of a Rectangle
		System.out.println("Area of Triangle using the triangle adapter is : " + );
	}
}

interface RectInterface{
	
	void aboutRectangle();
	double calculateAreaOfRectangle();
}

class Rectangle implements RectInterface{
	
	public double length;
	public double width;
	
	public Rectangle(double length,double width) {
		
		this.width = width;
		this.length = length;
	}
	
	@Override
	public void aboutRectangle() {
		
		System.out.println("Rectangle object with lengh: " + this.length + " unit and width : " + this.width + " unit.");
	}
	
	@Override
	public double calculateAreaOfRectangle() {
		
		return length * width;
	}
}

interface TriInterface{
	
	void aboutTriangle();
	double calculateAreaOfTriangle();
}

class Triangle implements TriInterface{
	
	public double base;
	public double height;
	
	public Triangle(double base, double height) {
		
		this.base = base;
		this.height = height;
	}
	
	@Override
	public void aboutTriangle() {
		
		System.out.println("Triangle object with base: " + this.base + " unit and height " + this.height + " unit.");
	}
	
	@Override
	public double calculateAreaOfTriangle() {
		
		return 0.5 * base * height;
	}
}

/*
 	TriangleAdapter is implementing RectInterface.
 	So, it needs to implement all to methods defined
 	in the target interface.
 */

class TriangleAdapter implements RectInterface{
	
	Triangle triangle;
	
	public TriangleAdapter(Triangle t) {
		
		this.triangle = t;
	}
	
	@Override
	public void aboutRectangle() {
		
		triangle.aboutTriangle();
	}
	
	@Override
	public double calculateAreaOfRectangle() {
		
		return triangle.calculateAreaOfTriangle();
	}
}




