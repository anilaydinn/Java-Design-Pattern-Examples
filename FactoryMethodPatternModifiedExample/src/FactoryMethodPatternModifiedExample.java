
public class FactoryMethodPatternModifiedExample {

	public static void main(String[] args) {
		
		System.out.println("***Modified Factory Pattern Demo***\n");
		
		//Creating a Tiger Factory
		AnimalFactory tigerFactory = new TigerFactory();
		
		//Creating a tiger using factory Factory Method
		Animal aTiger = tigerFactory.makeAnimal();
		aTiger.speak();
		aTiger.preferredAction();
		
		//Creating a Dog Factory
		AnimalFactory dogFactory = new DogFactory();
		
		//Creating a tiger using the Factory Method
		Animal aDog = dogFactory.makeAnimal();
		aDog.speak();
		aDog.preferredAction();
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
		
		System.out.println("Dog prefer barking...\n");
	}
}

class Tiger implements Animal{
	
	@Override
	public void speak() {
		
		System.out.println("Tiger says: Halum.");
	}
	
	@Override
	public void preferredAction() {
		
		System.out.println("Tigers prefer hunting...\n");
	}
}

abstract class AnimalFactory{
	
	public Animal makeAnimal() {
		
		System.out.println("I am inside makeAnimal() of AnimalFactory. You cannot ignore my rules.");
		
		/*
		 	At this point, it doesn't know whether it will get a Dog or a Tiger. It will be decided by the subclasses i.e. DogFactory or 
		 	TigerFactory. But it knows that it will Speak and it will have preferred way of Action.
		 */
		Animal animal = createAnimal();
		animal.speak();
		animal.preferredAction();
		
		return animal;
	}
	
	/*
	 	Remember that the GoF definition says "....Factory method lets a class defer instantiation to subclasses."
	 	In our case, the following method will create a Tiger or Dog but at this 
	 	point it does not know whether it will get a Dog or a Tiger. This decision
	 	will be taken by the subclasses i.e. DogFactory or TigerFactory. So, in this implementation, the following 
	 	method is playing the role of a factory (of creation)
	 */
	
	public abstract Animal createAnimal();
}

class DogFactory extends AnimalFactory{
	
	public Animal createAnimal() {
		
		//Creating a Dog
		return new Dog();
	}
}

class TigerFactory extends AnimalFactory{
	
	public Animal createAnimal() {
		
		//Creating a Tiger
		return new Tiger();
	}
}

