import javax.swing.*;
/**War_Manager class the main class of aplication */
public class War_Manager{
  public static void main(String[] args){
     CardDeck deck = new CardDeck();
     WarController controller;
     
     String play = JOptionPane.showInputDialog("Do you want to play WAR?").toUpperCase();
     if(play.equals("OK") || play.equals("YES") || play.equals("")){
        
        String s = JOptionPane.showInputDialog("Player 1. Type your name: ");
        
        View view = new View(s);
  
        controller = new WarController(s,deck,view);
        controller.game();
        
      }
     else{ 
        System.exit(0);//exit the game if user doesn't want to play
      }
   }
  
}