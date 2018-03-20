import java.awt.*; 

class LShape extends Shape {
  LShape(int row, int column, World world) {
    super(row, column, world); 
    this.color = new Color(102, 204, 204); 
    this.rotations = new int[][][] {
      { { 1, 0, 0}, 
        { 1, 0, 0}, 
        { 1, 1, 0}},
      { { 1, 1, 1}, 
        { 1, 0, 0}, 
        { 0, 0, 0}},
      { { 0, 1, 1}, 
        { 0, 0, 1}, 
        { 0, 0, 1}},
      { { 0, 0, 0}, 
        { 0, 0, 1}, 
        { 1, 1, 1}}
    };
    this.squares = createMap(row, column); 
  }
}