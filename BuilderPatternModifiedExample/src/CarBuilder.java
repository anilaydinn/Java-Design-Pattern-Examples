import java.util.HashMap;

public class CarBuilder implements ModifiedBuilder {

	private String startupMessage = "Start building the product."; //Default start-up message
	private String bodyType = "Steel"; //Default body
	private int noOfWheels = 4; //Default number of wheels
	private int noOfHeadlights = 2; //Default number of headlights
	//Default finish up message
	private String endOperationsMessage = "Product creation completed.";
	
	ProductClass product;

	@Override
	public ModifiedBuilder startUpOperations(String startUpMessage) {
		
		this.startupMessage = startUpMessage;
		return this;
	}

	@Override
	public ModifiedBuilder buildBody(String bodyType) {
		
		this.bodyType = bodyType;
		return this;
	}

	@Override
	public ModifiedBuilder insertWheels(int noOfWheels) {
		
		this.noOfWheels = noOfWheels;
		return this;
	}

	@Override
	public ModifiedBuilder addHeadlights(int noOfHeadlights) {
		
		this.noOfHeadlights = noOfHeadlights;
		return this;
	}

	@Override
	public ModifiedBuilder endOperations(String endOperationsMessage) {
		
		this.endOperationsMessage = endOperationsMessage;
		return this;
	}

	@Override
	public ProductClass cosntructCar() {
		
		product = new ProductClass(this.startupMessage,this.bodyType,this.noOfWheels,this.noOfHeadlights,this.endOperationsMessage);
		return product;
	}

	@Override
	public ProductClass getConstructedCar() {
		
		return product;
	}
}
