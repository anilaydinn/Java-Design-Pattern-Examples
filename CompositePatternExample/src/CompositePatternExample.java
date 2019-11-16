import java.util.ArrayList;
import java.util.List;

public class CompositePatternExample {
	
	/*
 	Principal is on top of college.
 	HOD -Maths and Comp. Sc directly reports to him
 	Teachers of Computer Sc. directly reports to HOD-CSE
 	Teachers of Mathematics directly reports to HOD-Maths
	 */
	
	public static void main(String[] args) {
		
		System.out.println("***Composite Pattern Demo***");
		
		//2 teachers other than HOD works in Mathematics department
		Employee mathTeacher1 = new Employee("Math Teacher-1", "Maths");
		Employee mathTeacher2 = new Employee("Math Teacher-2", "Maths");
		
		//teachers other than HOD works in Computer Sc. Department
		Employee cseTeacher1 = new Employee("CSE Teacher-1", "Computer Sc.");
		Employee cseTeacher2 = new Employee("CSE Teacher-2", "Computer Sc.");
		Employee cseTeacher3 = new Employee("CSE Teacher-3", "Computer Sc.");
		
		//The College has 2 Head of Departments-One from Mathematics, One from Computer Sc.
		CompositeEmployee hodMaths = new CompositeEmployee("Mr. S.Das(HOD-Maths)", "Maths");
		CompositeEmployee hodCompSc = new CompositeEmployee("Mr. V.Sarcar(HOD-CSE)", "Computer Sc.");
		
		//Principal of the college
		CompositeEmployee principal = new CompositeEmployee("Dr. S.Som(Principal)", "Planning-Supervising-Managing");
		
		//Teachers of Mathematics directly reports to HOD-Maths
		hodMaths.addEmployee(mathTeacher1);
		hodMaths.addEmployee(mathTeacher2);
		
		//Teachers of Computer Sc. directly reports to HOD-CSE
		hodCompSc.addEmployee(cseTeacher1);
		hodCompSc.addEmployee(cseTeacher2);
		hodCompSc.addEmployee(cseTeacher3);
		
		
		//Principal is on top of college. HOD -Maths and Comp. Sc directly reports to him.
		principal.addEmployee(hodMaths);
		principal.addEmployee(hodCompSc);
		
		/*
		 	Printing the leaf-nodes and branches in the same way i.e in each case, we are calling PrintStructures() method
		 */
		
		System.out.println("\nTesting the structure of a Principal object");
		
		//Prints the complete structure
		principal.printStructure();
		
		System.out.println("At present Principal has control over " + principal.getEmployeeCount() + " number of employees.");
		
		System.out.println("\nTesting the structure of a HOD-CSE object:");
		
		//Prints the details of Computer Sc, department
		hodCompSc.printStructure();
		
		System.out.println("At present HOD-CSE has control over " + hodCompSc.getEmployeeCount() + " number of employees.");
		
		System.out.println("\nTesting the structure of a HOD-Maths object:");
		
		//Prints the details of Mathematics department
		hodMaths.printStructure();
		
		System.out.println("At the present HOD-Maths has control over " + hodMaths.getEmployeeCount() + " number of employees.");
		
		//Leaf node
		System.out.println("\nTesting the structure of a leaf node:");
		
		mathTeacher1.printStructure();
		
		System.out.println("A present Math Teacher-1 has control over " + mathTeacher1.getEmployeeCount() + " number of employees.");
		
		/*
		 	Suppose, one computer teacher is leaving now from the organization
		 */
		hodCompSc.removeEmployee(cseTeacher2);
		System.out.println("\nAfter CSE Teacher-2 resigned, the organization has following members:");
		principal.printStructure();
		
		System.out.println("At present Principal has control over " + principal.getEmployeeCount() + " number of employees.");
		System.out.println("At present HOD-CSE has control over " + hodCompSc.getEmployeeCount() + " number of employees.");
		System.out.println("At present HOD-Maths has control over " + hodMaths.getEmployeeCount() + " number of employees.");
	}
}

interface IEmployee{
	
	void printStructure();
	int getEmployeeCount();
}

class CompositeEmployee implements IEmployee{
	
	//private static int emloyeeCount = 0;
	private int employeeCount = 0;
	
	private String name;
	private String dept;
	
	//The container for child objects
	private List<IEmployee> controls;
	
	//Constructor
	public CompositeEmployee(String name, String dept) {
	
		this.name = name;
		this.dept = dept;
		controls = new ArrayList<IEmployee>();
	}
	
	public void addEmployee(IEmployee e) {
		
		controls.add(e);
	}
	
	public void removeEmployee(IEmployee e) {
		
		controls.remove(e);
	}
	
	@Override 
	public void printStructure() {
		
		System.out.println("\t" + this.name + " works in " + this.dept);
		
		for(IEmployee e : controls) {
			
			e.printStructure();
		}
	}
	
	@Override
	public int getEmployeeCount() {
		
		employeeCount = controls.size();
		
		for(IEmployee e : controls) {
			
			employeeCount += e.getEmployeeCount();
		}
		return employeeCount;
	}
}

class Employee implements IEmployee{
	
	private String name;
	private String dept;
	private int employeeCount = 0;
	
	//Constructor
	public Employee(String name, String dept) {
	
		this.name = name;
		this.dept = dept;
	}
	
	@Override
	public void printStructure() {
		
		System.out.println("\t\t" + this.name + " works in " + this.dept);
	}
	
	@Override
	public int getEmployeeCount() {
		
		return employeeCount;
	}
}
