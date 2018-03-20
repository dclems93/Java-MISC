import java.util.*;
import java.awt.*;

class BackGround extends ArrayList<ArrayList<Square>> {
  boolean conflictsWith(Square square) {
    int row = square.row, col = square.column; 
    return null != this.get(row).get(col); 
  }
  World world; 
  BackGround(World world) {
     int rows = world.ROWS;
     int cols = world.COLS;
     for (int i = 0; i < rows; i++) {
       ArrayList<Square> row = new ArrayList<Square>(); 
       for (int j = 0; j < cols; j++) {
         row.add(null); 
       }
       this.add(row); 
     }
  }
  void draw(Graphics g) {
    for (ArrayList<Square> row : this)
      for (Square square : row)
        if (square != null) 
          square.draw(g); 
  }
  void receive(Shape current) {
    Map<String, Square> squares = current.squares; 
    for (String key : squares.keySet()) {
      Square square = squares.get(key); 
      if (square != null) { 
        int row = square.row, col = square.column; 
        this.get(row).set(col, square); 
      }
    }
  }
  int shrink() {
    int total = 0; 
    for (int i = this.size()-1; i >= 0; i--) {
      int sum = 0; 
      for (int j = 0; j < this.get(i).size(); j++) {
        if (this.get(i).get(j) != null) 
          sum += 1; 
      }
      if (sum == this.get(i).size()) {
        total += 1; 
        ArrayList<Square> row = new ArrayList<Square>(); 
        for (int j = 0; j < this.get(i).size(); j++) {
          row.add(null);  
        }
        this.remove(i); 
        this.add(0, row); 
        for (int line = i; line >= 0; line--) {
          for (int j = 0; j < this.get(line).size(); j++) {
            Square square = this.get(line).get(j); 
            if (square != null) 
              square.row = line; 
          }
        }
        i += 1; 
      }
    }
    return total; 
  }
}