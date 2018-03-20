import java.awt.*; 

class MirroredLShape extends Shape {
  MirroredLShape(int row, int column, World world) {
    super(row, column, world); 
    this.color = new Color(218, 170, 0);  
    this.rotations = new int[][][] {
      { { 0, 1, 0}, 
        { 0, 1, 0}, 
        { 1, 1, 0}},
      { { 1, 0, 0}, 
        { 1, 1, 1}, 
        { 0, 0, 0}},
      { { 0, 1, 1}, 
        { 0, 1, 0}, 
        { 0, 1, 0}},
      { { 0, 0, 0}, 
        { 1, 1, 1}, 
        { 0, 0, 1}}
    };
    this.squares = createMap(row, column); 
  }
}