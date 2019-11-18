package asdas;

import java.util.ArrayList;
import java.util.HashMap;

public class asdasd {

	public static void main(String[] args) {
		
		ArrayList<Araba> listem = new ArrayList<Araba>();
		
		Araba araba1 = new Araba(4, "Mavi");
		Araba araba2 = new Araba(2, "Yeşil");
		Araba araba3 = new Araba(6, "Kırmızı");
		Araba araba4 = new Araba(2, "Aqua");
		Araba araba5 = new Araba(3, "Beyaz");
		Araba araba6 = new Araba(5, "Siyah");
		
		listem.add(araba1);
		listem.add(araba2);
		listem.add(araba3);
		listem.add(araba4);
		listem.add(araba5);
		listem.add(araba6);
		
		for(Araba car : listem) {
			
			System.out.println(car.toString());
		}
	}
}

class Araba{
	
	private int kapi;
	private String color;
	
	public Araba(int kapi,String color) {
		
		this.kapi = kapi;
		this.color = color;
	}

	public int getKapi() {
		return kapi;
	}

	public void setKapi(int kapi) {
		this.kapi = kapi;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		
		return this.color + " " + this.kapi;
	}
	
}
