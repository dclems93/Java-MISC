package WebApp;


public class ModelTwo implements Mercedes {

	int price = 70000;
			
	public String makeCar(){
		return "A Model Two Mercedes";
	}
	
	public int makePayment(){
		return price;
	}
	
}