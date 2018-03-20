import java.util.Scanner;

public class JacksPizza{
  
  public static void main(String[] args){
    
    Pizza newPizza = null;
    PizzaFactory pf = new PizzaFactory();
    
    Scanner s = new Scanner(System.in);
    
    System.out.println("What type of pizza would you like to order? Enter corresponding letter:");
    System.out.println("a. cheese  b. veggie c. chicken");
    String newType = s.nextLine();
    
    System.out.println("What would you like for your first topping?");
    System.out.println("a. onions b. tomatoes c. peppers d. none");
    String newToppingone = s.nextLine();
    
    System.out.println("What would you like for your second topping?");
    System.out.println("a. onions b. tomatoes c. peppers d. none");
    String newToppingtwo = s.nextLine();
    
    System.out.println("What would you like for your third topping?");
    System.out.println("a. onions b. tomatoes c. peppers d. none");
    String newToppingthree = s.nextLine();
    
    newPizza = pf.makePizza(newType);
    newPizza.updateToppings(newToppingone, newToppingtwo, newToppingthree);
    newPizza.updatePrice();
    newPizza.reportPizza();
   
    
    
    
    
    
    
                         
    
  }
}
