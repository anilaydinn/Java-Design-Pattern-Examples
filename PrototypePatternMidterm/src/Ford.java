
public class Ford extends Car {
	
	private int kapi_sayisi;
	
	public Ford(String brand, int kapi_sayisi) {
		super(brand);
		this.kapi_sayisi = kapi_sayisi;
	}
	
	@Override
	public Car clone() throws CloneNotSupportedException{
		
		return (Ford)super.clone();
	}

	public String toString() {
		
		return getBrand() + " " + this.kapi_sayisi;
	}
}
