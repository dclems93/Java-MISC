package WebApp;


public class Navigation extends Decorator {

	Mercedes mercedes;
	int price = 1000;
	
	public Navigation(Mercedes mercedes){
		this.mercedes = mercedes;
	}
	
	public String makeCar(){
		return mercedes.makeCar() + addNavigation();
	}
	
	public String addNavigation(){
		return " with navigation capabilities";
	}
	
	public int makePayment(){
		return mercedes.makePayment() + addNavigationP();
	}
	
	public int addNavigationP(){
		return price;
	}
	
}