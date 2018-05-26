import java.awt.*;
import javax.swing.*;
public class View extends JPanel{
   private int width = 300;
   private int name_pos;
   private String cards1 = "";
   private String cards2 = "";
   private String pile1 = "";
   private String pile2 = "";
   private String winner = "";
   private String name = "";
  
   //the constructor
   public View(String s){
      name_pos = 20;
      name = s.toUpperCase();//player1 name
      JFrame frame = new JFrame("War Game");
      frame.setVisible(true);
      frame.setSize(3*width/2,width);//frame size
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit game  
      frame.getContentPane().add(this);
      //frame.setLocationRelativeTo(null);  // *** this will center your app ***
    }
    
   /*paintComponent prints each method of these class in a graphical window
   *@param g, the pen to draw
   */
   public void paintComponent(Graphics g){
      //paint background with white color
      g.setColor(Color.white);  
      g.fillRect(0,0,3*width/2,width);
      //paint players names
      g.setColor(Color.black);
      g.drawString(name, name_pos, name_pos);
      g.drawString("COMPUTER", width - 4*name_pos, name_pos);
      //paint cards
      g.setColor(Color.gray);
      g.drawString(cards1,name_pos, 2*name_pos);
      g.drawString(cards2,width - 4*name_pos, 2*name_pos);
      //paint amounts of each pile
      g.setColor(Color.BLUE);
      g.drawString(pile1, name_pos,5*name_pos);
      g.drawString(pile2, width - 4*name_pos, 5*name_pos);
      //paint winners' name
      g.setColor(Color.red);
      g.drawString(winner,width - 9*name_pos , width - 4*name_pos);
      
    }

    //this method gets player1's card - repaint for each
    public void paintString1(String message){
        cards1 = message;
        this.repaint();
      }
    //this method gets computer's card
    public void paintString2(String message){
        cards2 = message;
        this.repaint();
      }
    //paintWinner gets the name of the winner
    public void paintWinner(String message){
        winner = message;
        this.repaint();
      }
    //paintpile1 gets the amount of cards player1 has won  
    public void paintpile1(String p1){
        pile1 = p1;
        this.repaint();
      }
    //paintpile1 gets the amount of cards computer has won
    public void paintpile2(String p2){
        pile2 = p2;
        this.repaint();
      }
    
}