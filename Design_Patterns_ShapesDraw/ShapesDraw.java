public class ShapesDraw{
  
  public static void main(String[] args){
    
    SquareShape Square1 = new SquareShape("Square1", 5 , "red");
    Square1.Draw();
    SquareShape Square2 = new SquareShape("Square2", 7 , "green");
    Square2.Draw();
    RectangleShape Rectangle1 = new RectangleShape("Rectangle1", 7 , 5 , "blue");
    Rectangle1.Draw();
    RectangleShape Rectangle2 = new RectangleShape("Rectangle2", 10 , 7 , "black");
    Rectangle2.Draw();
    
    
  }
  
}