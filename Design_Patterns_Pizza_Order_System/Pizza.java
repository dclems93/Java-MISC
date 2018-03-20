public abstract class Pizza{
 private double price;
 private String toppingone;
 private String toppingtwo;
 private String toppingthree;
 private String pizzatype;
 private String location;
 
 
 // a type is one of : cheese, veggie, or chicken 
 public void setType(String type){
  pizzatype = type; 
 }
 
 public void setPrice(Double newPrice){
   price = newPrice;
 }
 
 public void updatePrice(){
   if(toppingone.equals("onion")){
    price += .60;
   }
   else if(toppingone.equals("tomato")){
     price += .70;
   }
   else if(toppingone.equals("peppers")){
     price += .80;
   }
   
   if(toppingtwo.equals("onion")){
    price += .60;
   }
   else if(toppingtwo.equals("tomato")){
     price += .70;
   }
   else if(toppingtwo.equals("peppers")){
     price += .80;
   }
   
   if(toppingthree.equals("onions")){
    price += .60;
   }
   else if(toppingthree.equals("tomatoes")){
     price += .70;
   }
   else if(toppingthree.equals("peppers")){
     price += .80;
   }
 }
 
 
 
  public void updateToppings(String topone, String toptwo, String topthree){
    if(topone.equals("a")){
      setToppingone("onions");
    }
    else if(topone.equals("b")){
      setToppingone("tomatoes");
    }
    else if(topone.equals("c")){
      setToppingone("peppers");
    }
    else if(topone.equals("d")){
      setToppingone("none");
    }
    
    if(toptwo.equals("a")){
      setToppingtwo("onions");
    }
    else if(toptwo.equals("b")){
      setToppingtwo("tomatoes");
    }
    else if(toptwo.equals("c")){
      setToppingtwo("peppers");
    }
    else if(toptwo.equals("d")){
      setToppingtwo("none");
    }
    
    
    if(topthree.equals("a")){
      setToppingthree("onions");
    }
    else if(topthree.equals("b")){
      setToppingthree("tomatoes");
    }
    else if(topthree.equals("c")){
      setToppingthree("peppers");
    }
    else if(topthree.equals("d")){
      setToppingthree("none");
    }
      
    }
 
 public void setLocation(String newLocation){
   location = newLocation;
 }
 
 public void reportPizza(){
   System.out.println("You ordered a " + pizzatype + " pizza with " + toppingone +
                       ", " + toppingtwo + ", " + toppingthree + " and the cost is "
                         + price );
 }
 
 public void setToppingone(String topping){
   toppingone = topping;
 }
 public String getToppingone(){
  return toppingone; 
 }
 
 
 public void setToppingtwo(String topping){
   toppingtwo = topping;
 }
 
 public String getToppingtwo(){
  return toppingtwo; 
 }
 
 
 public void setToppingthree(String topping){
   toppingthree = topping;
 }
 
 public String getToppingthree(){
  return toppingthree; 
 }
}