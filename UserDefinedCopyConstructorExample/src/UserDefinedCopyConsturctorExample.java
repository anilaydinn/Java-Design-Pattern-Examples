
public class UserDefinedCopyConsturctorExample {
	
	public static void main(String[] args) {
		
		System.out.println("***User defined copy constructor example in Java***\n");
		
		Student student1 = new Student(1, "John");
		
		System.out.println("The detail of Student1 is as follows:");
		student1.displayDetails();
		
		System.out.println("\nCopying student1 to student2 now");
		//Invoking the user-defined copy constructor
		Student student2 = new Student(student1);
		
		System.out.println("The detail of Student2 is as follows:");
		student2.displayDetails();
	}
}
