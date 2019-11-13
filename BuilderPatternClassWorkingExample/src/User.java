
public class User {

	private final String fname;
	private final String sname;
	private final int age;
	private final String phone;
	private final String address;
	private static UserBuilder userBuilder;
	
	public User(UserBuilder userBuilder) {
		
		this.fname = 
		this.sname = sname;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}
	
	public String getFname() {
		
		return this.fname;
	}
	
	public String getSname() {
		
		return this.sname;
	}
	
	public int getAge() {
		
		return this.age;
	}
	
	public String getPhone() {
		
		return this.phone;
	}
	
	public String getAddress() {
		
		return this.address;
	}

	@Override
	public String toString() {
		return "User: " + this.fname + " " + this.sname + " " + this.phone + " " + this.age + " " + this.address;
	} 
	
	
}

class Main{
	
	public static void main(String[] args) {
		
		
	}
}

class UserBuilder {

	private final String fname;
	private final String sname;
	private int age;
	private String phone;
	private String address;
	
	public UserBuilder(String fname, String sname) {
		
		this.fname = fname;
		this.sname = sname;
	}
	
	public UserBuilder age(int age) {
		
		this.age = age;
		return this;
	}
	
	public UserBuilder phone(String phone) {
		
		this.phone = phone;
		return this;
	}
	
	public UserBuilder address(String address) {
		
		this.address = address;
		return this;
	}
	
	public User build() {
		
		User user = new User(this);
		return user;
	}
	
	
	
}
