package WebApp;

public class Bluetooth extends Decorator {

	Mercedes mercedes;
	int price = 500;
	
	public Bluetooth(Mercedes mercedes){
		this.mercedes = mercedes;
	}
	
	public String makeCar(){
		return mercedes.makeCar() + addBluetooth();
	}
	
	public String addBluetooth(){
		return " with Bluetooth calling";
	}
	
	public int makePayment(){
		return mercedes.makePayment() + addBluetoothP();
	}
	
	public int addBluetoothP(){
		return price;
	}
	
}