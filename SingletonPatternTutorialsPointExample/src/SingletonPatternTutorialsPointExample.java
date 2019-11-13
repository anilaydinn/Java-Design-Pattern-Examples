
public class SingletonPatternTutorialsPointExample {

	public static void main(String[] args) {
		
		//illegal construct
		//Compile Time Error: The constructor SingleObject() is not visible
		//SingleObject object = new SingleObject();
		
		//Get the only object avaible
		SingleObject object = SingleObject.getInstance();
		
		//show message
		object.showMessage();
	}
}
