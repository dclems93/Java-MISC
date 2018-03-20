import java.awt.*; 
import java.util.*; 

abstract class Shape {
  void draw(Graphics g) {
    // System.out.println( this ); 
    for (String key : squares.keySet()) {
      Square square = squares.get(key); 
      if (square != null) 
        square.draw(g); 
    } 
  }
  
  Map<String, Square> squares; 
  
  Map<String, Square> createMap(int row, int column) {
    Map<String, Square> squares = new HashMap<String, Square>(); 
    int[][] matrix = this.rotations[this.rotation];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        // System.out.println( i + ", " + j ); 
        Square square = matrix[i][j] == 1 ? new Square(world, color, row + i, column + j) : null; 
        squares.put(i + ", " + j, square); 
      }
    }
    // System.out.println( squares + "" ); 
    return squares; 
  }
  
  World world; 
  int row, column;
  
  boolean moveDown() { 
    Map<String, Square> future = this.createMap(row + 1, column); 
    if (world.validates(future)) {
      this.squares = future; // also a few things
      // System.out.println( "I am going down." ); 
      this.row += 1; 
      return true; 
    } else {
      return false;  
    }
  } 

  boolean moveLeft() { 
    Map<String, Square> future = this.createMap(row, column-1); 
    if (world.validates(future)) {
      this.squares = future; 
      this.column -= 1; 
      return true; 
    } else {
      return false;  
    }
  } 

  boolean moveRight() { 
    Map<String, Square> future = this.createMap(row, column+1); 
    if (world.validates(future)) {
      this.squares = future; 
      this.column += 1; 
      return true; 
    } else {
      return false;  
    }
  } 
  
  Color color;
  Shape(int row, int column, World world) {
    this.row = row; 
    this.column = column; 
    this.world = world;
    this.squares = new HashMap<String, Square>(); 
  }

  int rotation;

  void rotateRight() { // thanks to Thijs and Jake for catching this 
    int oldRotation = this.rotation;
    this.rotation = (this.rotation + 1) % 4;
    Map<String, Square> future = this.createMap(row, column);
    if (!world.validates(future)) {
      this.rotation = oldRotation;
    } else {
      this.squares = future;
    }
  }

  void rotateLeft() {
    int oldRotation = this.rotation;
    this.rotation = (this.rotation + 3) % 4;
    Map<String, Square> future = this.createMap(row, column);
    if (!world.validates(future)) {
      this.rotation = oldRotation;
    } else {
      this.squares = future;
    }
  }

  int[][][] rotations; 
  
  static Shape randomShape(World world) {
    int which = (int)(Math.random() * 7 + 1); 
    // which = 12;
    switch (which) {
      case 1 : return new SquareShape   (0, world.COLS/2, world);  
      case 2 : return new LShape        (0, world.COLS/2, world);
      case 3 : return new SShape        (0, world.COLS/2, world); 
      case 4 : return new ZShape        (0, world.COLS/2, world);
      case 5 : return new MirroredLShape(0, world.COLS/2, world);
      case 6 : return new LineShape     (0, world.COLS/2, world);
      default: return new TShape        (0, world.COLS/2, world);
    }
  }
  
}
