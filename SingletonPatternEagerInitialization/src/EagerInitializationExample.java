
class Captain{
	
	//Early initialization
	private static final Captain captain = new Captain();
	
	//We make the constructor private to prevent the use of "new"
	private Captain() {
		
		System.out.println("A captain is elected for your team.");
	}
	
	//Global point of access. The method getCaptain() is public static method
	public static Captain getCaptain() {
		
		System.out.println("You have a captain for your team.");
		return captain;
	}
	
	public static void dummyMethod() {
		
		System.out.println("It is a dummy method");
	}
}

public class EagerInitializationExample {
	
	public static void main(String[] args) {
		
		System.out.println("***Singleton Pattern Demo With Eager Initialization***\n");
		Captain.dummyMethod();
	}
}
