import javax.swing.*; 
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


class Game extends JFrame {
  
  int score;
  JLabel scoreLabel;
  Game() {
    
    //setLayout(new BorderLayout());
    

    
    JButton button = new JButton("Reset!");
    button.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button");
            }
        });      
    scoreLabel = new JLabel("Score: " + score);
    JPanel panel = new JPanel(new BorderLayout());
    panel.add(button, BorderLayout.SOUTH);
    panel.add(scoreLabel, BorderLayout.NORTH);

    World world = new World();
    world.start(); 
    panel.add(world, BorderLayout.CENTER);
    
    
    addKeyListener(world);
    this.setSize(200, 480);
    this.setVisible(true); 
    this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
    this.add(panel);
  }
  
  

  public static void main(String[] args) {
    Game game = new Game();  
  }
}