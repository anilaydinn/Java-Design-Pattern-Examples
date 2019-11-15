
public class Captain {

	private static Captain captain;
	
	private Captain() {
		
		
	}
	
	public static Captain getCaptain() {
		
		if(captain == null) {
			
			captain = new Captain();
			System.out.println("Captain elected your team!");
		}
		else{
			
			System.out.println("You have already captain your team!");
		}
		return captain;
	}
}
