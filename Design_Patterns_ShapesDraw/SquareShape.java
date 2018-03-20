public class SquareShape extends GraphicsObject{
  
  int width;
  String color;
  String name;
  int area;
  int volume;
  int perimeter;
  
  
 public SquareShape(String name, int width, String color){
   this.width = width; 
   this.SetName(name);
   this.ObjArea();
   this.ObjVolume();
   this.Perimeter();
   FillColor(color);
  
  }
 
 void SetName(String name){
  this.name = name; 
 }
  
  void FillColor(String color){
    this.color = color;
    
  }
  public void Draw(){
    System.out.println( "The object " + this.name + " is a " 
                         + this.color + " Square with an area of "
                        + this.area + ", a volume of " +
                       this.volume + ", and a Perimeter of "
                         + this.perimeter);
    
  }
  public void ObjArea(){
    this.area = this.width * this.width;
    
  }
  
  public void ObjVolume(){
    this.volume = this.width * this.width * this.width;
  }
  public void Perimeter(){
    this.perimeter = this.width * 4;
    
  }
  
}