
//The common interface

public interface ModifiedBuilder {

	/*
	 	All these method return type is ModifiedBuilder.
	 	This will help us to apply method chaining
	 */
	
	ModifiedBuilder startUpOperations(String startUpMessage);
	ModifiedBuilder buildBody(String bodyType);
	ModifiedBuilder insertWheels(int noOfWheels);
	ModifiedBuilder addHeadlights(int noOfHeadlights);
	ModifiedBuilder endOperations(String endOperationsMessage);
	
	//Combine the parts and make the final product.
	ProductClass cosntructCar();
	
	//Optional method:To get the already constructed object.
	ProductClass getConstructedCar();
}
