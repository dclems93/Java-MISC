import java.awt.*; 

class Square {
  World world; 
  Color color;
  Square(World world, Color color, int row, int col) {
    this.world = world; 
    this.color = color; 
    this.row = row; 
    this.column = col; 
  }
  int row, column; // distance to top left corner of World 
  void draw(Graphics g) {
    int width = world.squareWidth(), height = world.squareHeight(); 
    int x = this.column * width, y = this.row * height; 
    g.setColor(this.color); 
    g.fillRect(x, y, width, height); 
    g.setColor(Color.WHITE); 
    g.drawRect(x, y, width, height); 
    g.setColor(Color.BLACK); 
  }
  public String toString() {
    return "Square(" + row + ", " + column + ")";  
  }
  boolean conflictsWith(int rows, int cols) {
    return row < 0 || row >= rows || column < 0 || column >= cols;  
  }
}