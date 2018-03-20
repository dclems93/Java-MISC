package WebApp;

public class MercedesStore {
	
	Mercedes mercedes;
	String descrip;
	int price;

	public void makeOne(String type){
		
		if(type.equals("ModelOne")){
			mercedes = new ModelOne();
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
		
		if(type.equals("ModelTwo")){
			mercedes = new ModelTwo();
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
		
		if(type.equals("ModelThree")){
			mercedes = new ModelThree();
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
	}
	
	public void makeOneBonus(String type, String addition){
		
		if(type.equals("ModelOne") && addition.equals("Navigation")){
			mercedes = new Navigation(new ModelOne());
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
		
		if(type.equals("ModelOne") && addition.equals("Audio")){
			mercedes = new Audio(new ModelOne());
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
		
		if(type.equals("ModelOne") && addition.equals("Bluetooth")){
			mercedes = new Bluetooth(new ModelOne());
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
		
		if(type.equals("ModelTwo") && addition.equals("Navigation")){
			mercedes = new Navigation(new ModelTwo());
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
		
		if(type.equals("ModelTwo") && addition.equals("Audio")){
			mercedes = new Audio(new ModelTwo());
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
		
		if(type.equals("ModelTwo") && addition.equals("Bluetooth")){
			mercedes = new Bluetooth(new ModelTwo());
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
		
		if(type.equals("ModelThree") && addition.equals("Navigation")){
			mercedes = new Navigation(new ModelThree());
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
		
		if(type.equals("ModelThree") && addition.equals("Audio")){
			mercedes = new Audio(new ModelThree());
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
		
		if(type.equals("ModelThree") && addition.equals("Bluetooth")){
			mercedes = new Bluetooth(new ModelThree());
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
		
		else{
			System.out.println("Invalid car");
		}
		
	}
	
	public void makeTwoBonus(String type, String addOne, String addTwo){
		
		if(type.equals("ModelOne") && addOne.equals("Navigation") && addTwo.equals("Audio")){
			mercedes = new Audio(new Navigation(new ModelOne()));
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
		
		if(type.equals("ModelOne") && addOne.equals("Navigation") && addTwo.equals("Bluetooth")){
			mercedes = new Bluetooth(new Navigation(new ModelOne()));
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
		
		if(type.equals("ModelOne") && addOne.equals("Audio") && addTwo.equals("Bluetooth")){
			mercedes = new Audio(new Bluetooth(new ModelOne()));
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
		
		if(type.equals("ModelTwo") && addOne.equals("Navigation") && addTwo.equals("Audio")){
			mercedes = new Audio(new Navigation(new ModelTwo()));
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
		
		if(type.equals("ModelTwo") && addOne.equals("Navigation") && addTwo.equals("Bluetooth")){
			mercedes = new Bluetooth(new Navigation(new ModelTwo()));
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
		
		if(type.equals("ModelTwo") && addOne.equals("Audio") && addTwo.equals("Bluetooth")){
			mercedes = new Audio(new Bluetooth(new ModelTwo()));
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
		
		if(type.equals("ModelThree") && addOne.equals("Navigation") && addTwo.equals("Audio")){
			mercedes = new Audio(new Navigation(new ModelThree()));
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
		
		if(type.equals("ModelThree") && addOne.equals("Navigation") && addTwo.equals("Bluetooth")){
			mercedes = new Bluetooth(new Navigation(new ModelThree()));
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
		
		if(type.equals("ModelThree") && addOne.equals("Audio") && addTwo.equals("Bluetooth")){
			mercedes = new Audio(new Bluetooth(new ModelThree()));
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
		
	}
	
	public void makeThreeBonus(String type){
		
		if(type.equals("ModelOne")){
			mercedes = new Bluetooth(new Audio(new Navigation(new ModelOne())));
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
		
		if(type.equals("ModelTwo")){
			mercedes = new Bluetooth(new Audio(new Navigation(new ModelTwo())));
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
		
		if(type.equals("ModelThree")){
			mercedes = new Bluetooth(new Audio(new Navigation(new ModelThree())));
			descrip = mercedes.makeCar();
			price = mercedes.makePayment();
		}
	}
	
}



