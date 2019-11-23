
public class ProxyPatternExample {

	public static void main(String[] args) {
		
		System.out.println("***Proxy Pattern Demo***\n");
		Proxy px = new Proxy();
		
		px.doSomeWork();
	}
}

//Abstract class Subject
abstract class Subject{
	
	public abstract void doSomeWork();
}

//ConcreteSubject Class
class ConcreteSubject extends Subject{
	
	@Override
	public void doSomeWork() {
		
		System.out.println("doSomeWork() inside ConcreteSubject is invoked.");
	}
}

/*
	Proxy Class: It will try to invoke the doSomeWork()
	of a ConcreteSubject instance
*/

class Proxy extends Subject{
	
	static Subject cs;
	
	@Override 
	public void doSomeWork() {
		
		System.out.println("Proxy call happening now...");
		
		//Lazy initialization: We'll not instantiate until the method is called
		if(cs == null) {
			
			cs = new ConcreteSubject();
		}
		cs.doSomeWork();
	}
}
