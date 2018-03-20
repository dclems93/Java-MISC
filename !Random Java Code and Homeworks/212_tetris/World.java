import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.util.Map; 

class World extends JComponent implements KeyListener, ActionListener {
  boolean validates(Map<String, Square> squares) {
    boolean answer = true;
    for (String key : squares.keySet()) {
      Square square = squares.get(key); 
      if (square != null) 
        if ( square.conflictsWith(ROWS, COLS) || background.conflictsWith(square) )
          answer = false; 
    }     
    // System.out.println( answer ); 
    return answer;  
  }
  public void keyPressed(KeyEvent e) {
    int keycode = e.getKeyCode();
    // System.out.println("Ouch. You have typed: " + ((char) keycode)); 
    switch (keycode) {
      case KeyEvent.VK_LEFT : // System.out.println("Left arrow key."); 
                              current.moveLeft(); this.repaint(); 
                              break; 
      case KeyEvent.VK_RIGHT: // System.out.println("Right arrow key."); 
                              current.moveRight(); this.repaint(); 
                              break; 
      case KeyEvent.VK_UP   : // System.out.println("Up arrow key."); 
                              current.rotateRight();  this.repaint();
                              break; 
      case KeyEvent.VK_DOWN : // System.out.println("Down arrow key."); 
                              current.rotateLeft();  this.repaint();
                              break; 
      case KeyEvent.VK_SPACE: // System.out.println("Down arrow key."); 
                              timer.setDelay(50); 
                              break; 
                              
      default               : // System.out.println("No arrow key."); 
                              break; 
    }
  }
  public void keyReleased(KeyEvent e) { } 
  public void keyTyped(KeyEvent e) { } 
  int count;
  Timer timer; 
  public void actionPerformed(ActionEvent e) {
    this.count += 1; 
    // System.out.println( "ActionEvent received: " + this.count );  
    if (current != null) {
      if (! current.moveDown()) {
        this.background.receive(current); 
        this.background.shrink(); 
        timer.setDelay(1000); // thanks to Jake and Thijs for catching this 
        current = Shape.randomShape(this);
        if (! this.validates(current.squares)) {
          current = null;
          timer.stop();
          System.out.println("Game over!"); 
        }
      }
    } else {
      timer.stop(); 
    }
    repaint();
  }
  Shape current; 
  BackGround background;
  World() {
    this.timer = new Timer(1000, this); 
    this.background = new BackGround(this);   
    this.current = Shape.randomShape(this);
    // this.background.get(1).set(2, new Square(this, Color.RED, 1, 2)); 
    // this.background.get(1).set(3, new Square(this, Color.RED, 1, 3)); 
  }
  void start() {
    this.timer.start();  
  }
  public void paintComponent(Graphics g) {
    this.background.draw(g); 
    if (current != null) 
      this.current.draw(g); 
  }
  static final int ROWS = 22;
  static final int COLS = 10; 
  int squareWidth() { return (int) getSize().getWidth() / World.COLS; }
  int squareHeight() { return (int) getSize().getHeight() / World.ROWS; }
}
