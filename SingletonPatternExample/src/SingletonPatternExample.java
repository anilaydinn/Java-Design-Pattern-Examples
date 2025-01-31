
//We cannot extend Captain class. The constructor is private in this case.
//class B extends Captain{} //error

public class SingletonPatternExample {

	public static void main(String[] args) {
		
		System.out.println("***Singleton Pattern Demo***\n");
		System.out.println("Trying to make a captain for your team:");
		
		//Constructor is private. We cannot use "new" here.
		//Captain c3 = new Captain();//error
		
		Captain captain1 = Captain.getCaptain();
		System.out.println("Trying to make another captain for your team:");
		
		Captain captain2 = Captain.getCaptain();
		
		if(captain1 == captain2) {
			
			System.out.println("captain1 and captain2 are same instance.");
		}
		
		Captain.CaptainDerived derived = captain1.new CaptainDerived();
	}
}

//final class
class Captain{
	
	private static Captain captain;
	
	//We make the constructor private to prevent the use of "new"
	static int numberOfInstance = 0;
	
	private Captain() {
		
		numberOfInstance++;
		System.out.println("Number of instances at this moment = " + numberOfInstance);
	}
	
	public static synchronized Captain getCaptain() {
		
		//Lazy initialization
		if(captain == null) {
			
			captain = new Captain();
			System.out.println("New captain is elected for your team.");
		}
		else {
			
			System.out.print("You already have a captain for your team.");
			System.out.println("Send him for the toss.");
		}
		
		return captain;
	}
	
	//A non-static nested class (inner class)
	public class CaptainDerived extends Captain{
		
		//Some code
	}
}


