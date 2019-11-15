
public class BridgePatternDemo {

	public static void main(String[] args) {
		
		
	}
}

interface DrawAPI{
	
	void drawCircle(int radius, int x, int y);
}

class RedCircle implements DrawAPI{
	
	@Override
	public void drawCircle(int radius, int x, int y) {
		
		System.out.println("Red circle draw circle method.");
	}
}

class GreenCircle implements DrawAPI{
	
	@Override
	public void drawCircle(int radius, int x, int y) {
		
		System.out.println("Green circle draw circle method.");
	}
}

abstract class Shape{
	
	public DrawAPI drawAPI;
	
	public Shape(DrawAPI drawAPI) {
		
		this.drawAPI = drawAPI;
	}
	
	public abstract void draw(); 
	
}

class Circle extends Shape{
	
	private int x;
	private int y;
	private int radius;
	
	public Circle(DrawAPI drawAPI,int x, int y, int radius) {
		
		super(drawAPI);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	@Override
	public void draw() {
		
		drawAPI.drawCircle(radius,x,y);
	}
	
	
}