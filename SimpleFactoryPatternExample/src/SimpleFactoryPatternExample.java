import java.util.Scanner;

public class SimpleFactoryPatternExample {

	public static void main(String[] args) {
		
		System.out.println("***Simple Factory Pattern Demo***\n");
		
		Animal prefferedType = null;
		
		SimpleFactory simpleFactory = new SimpleFactory();
		
		//The code that will vary based on users preference.
		prefferedType = simpleFactory.createAnimal();
		
		//The codes that do not change frequently
		//These animals can speak and prefer to do some spesific actions.
		prefferedType.speak();
		prefferedType.preferredAction();
	}
}

interface Animal{
	
	void speak();
	void preferredAction();
}

class Dog implements Animal{
	
	@Override
	public void speak() {
		
		System.out.println("Dog says: Bow-Wow.");
	}
	
	@Override
	public void preferredAction() {
		
		System.out.println("Dogs prefer barking...");
	}
}

class Tiger implements Animal{
	
	@Override
	public void speak() {
		
		System.out.println("Tiger says: Halum");
	}
	
	@Override
	public void preferredAction() {
		
		System.out.println("Tigers prefer hunting...");
	}
}

class SimpleFactory{
	
	public Animal createAnimal() {
		
		Animal intendedAnimal = null;
		System.out.println("Enter your choice ( 0 for Dog, 1 for Tiger)");
		
		Scanner input = new Scanner(System.in);
		int choice = Integer.parseInt(input.nextLine());
		
		System.out.println("You have entered :" + choice);
		
		switch(choice) {
			
		case 0:
			intendedAnimal = new Dog();
			break;
		
		case 1:
			intendedAnimal = new Tiger();
			break;
		
		default:
			System.out.println("You must enter either 0 or 1");
			throw new IllegalArgumentException("Your choice tries to create an unknown Animal");
		}
		
		return intendedAnimal;
	}
}
