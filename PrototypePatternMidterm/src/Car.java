
public abstract class Car implements Cloneable {

	private String brand;
	
	public Car(String brand) {
		
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public Car clone() throws CloneNotSupportedException {
		
		return (Car)super.clone();
	}
	
	public abstract String toString();
}
