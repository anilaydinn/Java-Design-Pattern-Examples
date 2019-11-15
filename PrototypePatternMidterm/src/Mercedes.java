
public class Mercedes extends Car {

	private int tekerlek_sayisi;
	
	public Mercedes(String brand,int tekerlek_sayisi) {
		
		super(brand);
		this.tekerlek_sayisi = tekerlek_sayisi;
	}
	
	public Car clone() throws CloneNotSupportedException{
		
		return (Mercedes)super.clone();
	}
	
	public String toString() {
		
		return getBrand()  + " " + this.tekerlek_sayisi;
	}
}
