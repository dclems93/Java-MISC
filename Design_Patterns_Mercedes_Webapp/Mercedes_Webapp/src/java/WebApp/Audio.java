package WebApp;

public class Audio extends Decorator {

	Mercedes mercedes;
	int price = 4000;
	
	public Audio(Mercedes mercedes){
		this.mercedes = mercedes;
	}
	
	public String makeCar(){
		return mercedes.makeCar() + addAudio();
	}
	
	public String addAudio(){
		return " with Audio capabilities";
	}
	
	public int makePayment(){
		return mercedes.makePayment() + addAudioP();
	}
	
	public int addAudioP(){
		return price;
	}
	
}