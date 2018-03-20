import java.awt.*; 

class SquareShape extends Shape {
  SquareShape(int row, int column, World world) {
    super(row, column, world); 
    this.color = new Color(204, 102, 204);  
    this.rotations = new int[][][] {
      { { 1, 1}, 
        { 1, 1} }, 
      { { 1, 1}, 
        { 1, 1} }, 
      { { 1, 1}, 
        { 1, 1} }, 
      { { 1, 1}, 
        { 1, 1} }
    };
    this.squares = createMap(row, column); 
  }
}