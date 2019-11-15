
public class Prototype {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Car ford = new Ford("Ford", 2);
		Car ford_copy = ford.clone();
		
		System.out.println(ford);
		System.out.println(ford_copy);
	}
}
