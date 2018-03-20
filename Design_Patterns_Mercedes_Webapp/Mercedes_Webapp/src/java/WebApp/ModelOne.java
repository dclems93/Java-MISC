package WebApp;


public class ModelOne implements Mercedes {

	int price = 50000;
			
	public String makeCar(){
		return "A Model One Mercedes";
	}
	
	public int makePayment(){
		return price;
	}
	
}