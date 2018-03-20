public class PizzaFactory{
  public Pizza makePizza(String newPizzaType){
    //Pizza newPizza = null;
    if(newPizzaType.equals("a")){
      return new CheesePizza();
    }
    else if(newPizzaType.equals("b")){
      return new VeggiePizza();
    }
    else if(newPizzaType.equals("c")){
      return new ChickenPizza(); 
    }
    else{ 
      return null;  
    }
          
  }
}