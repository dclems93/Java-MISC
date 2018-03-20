package WebApp;


public class ModelThree implements Mercedes {

	int price = 80000;
			
	public String makeCar(){
		return "A Model Three Mercedes";
	}
	
	public int makePayment(){
		return price;
	}
	
}