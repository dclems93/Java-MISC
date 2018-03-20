package WebApp;

public abstract class Decorator implements Mercedes {

	Mercedes mercedes;
	
	public Decorator(){}
	
	public Decorator(Mercedes mercedes){
		this.mercedes = mercedes;
	}
	
	public String makeCar(){
		return mercedes.makeCar();
	}
	
	public int makePayment(){
		return mercedes.makePayment();
	}
		
}
