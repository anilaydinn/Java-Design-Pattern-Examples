
public abstract class Shape implements Cloneable {

	private String id;
	protected String type;
	
	abstract void draw();
	
	public String getType() {
		
		return this.type;
	}
	
	public String getId() {
		
		return this.id;
	}
	
	public void setId(String id) {
		
		this.id = id;
	}
	
	public Object clone() {
		
		Object clone = null;
		
		try {
			
			clone = super.clone();
		}
		catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
		}
		
		return clone;
	}
}
