import java.awt.*; 

class SShape extends Shape {
  SShape(int row, int column, World world) {
    super(row, column, world); 
    this.color = new Color(102, 204, 102);  
    this.rotations = new int[][][] {
      { { 0, 1, 1}, 
        { 1, 1, 0}, 
        { 0, 0, 0}},
      { { 0, 1, 0}, 
        { 0, 1, 1}, 
        { 0, 0, 1}},
      { { 0, 0, 0}, 
        { 0, 1, 1}, 
        { 1, 1, 0}},
      { { 1, 0, 0}, 
        { 1, 1, 0}, 
        { 0, 1, 0}}
    };
    this.squares = createMap(row, column); 
  }
}