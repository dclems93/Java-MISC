public class RectangleShape extends GraphicsObject{
  
  int width;
  int height;
  String color;
  String name;
  int area;
  int volume;
  int perimeter;
  
  
 public RectangleShape(String name, int width, int height, String color){
   this.width = width; 
   this.height = height;
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
                         + this.color + " Rectangle with an area of "
                        + this.area + ", a volume of " +
                       this.volume + ", and a Perimeter of "
                         + this.perimeter);
    
  }
  public void ObjArea(){
    this.area = this.width * this.height;
    
  }
  
  public void ObjVolume(){
    this.volume = this.width * this.height * this.width;
  }
  public void Perimeter(){
    this.perimeter = this.width + this.width + this.height + this.height;
    
  }
  
}