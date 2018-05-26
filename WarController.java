// class WarController computes games logic part 
import javax.swing.*;
public class WarController{
   private String name = "";// player's 1(user) name
   public CardDeck cards;
   private int count1,count2;
   private String suit1,suit2,peace;
   private int pile1,pile2 = 0;
   public Card c1,c2;
   public View view;
   private int x = 2;//the value to add cards to the pile of the winner 
   private String gameover =" ";
   
   /*The constructor initializes it's parameters
   *@param n , the holds the name of palyer1
   *@param deck, calls the CardDeck class
   */
   public WarController(String n, CardDeck deck,View v){
       name = n;
       cards = deck;
       view = v;
     }
    
   /*game() method computes the game 
   *it does all the calculations to find the winner
   */
   public void game(){
      String winner = "Computer";
      boolean result = true;
      while(result){
      //play next round everytime user agree with it
      String round = JOptionPane.showInputDialog("Play next round , press the ok button");
      if(round == null || round.equals("no")){result = false;}
      //play the game
      if(cards.moreCards()){         
     
        c1 = cards.newCard();//Card c1 holds the method newCard() from class CardDeck
        c2 = cards.newCard();
        
        count1 = c1.getCount();//count1 gets the value of a card randomly picked 
        count2 = c2.getCount();
        suit1 = c1.getSuit();//suit1 gets the suit of that card (count1)
        suit2 = c2.getSuit();
        //draw the cards taken from each carddeck
        view.paintString1(getCard1()); 
        view.paintString2(getCard2());
        
      //compute the game winner
      if(count1 == count2){//WAR
         JOptionPane.showMessageDialog(null,"WAR");
         x += 2;
         game();//return to the game if cards are equal - play next round
       }
      else if(count1 == 1){
          pile1 = pile1 + x;
            x=2; 
            view.paintpile1(name + " has " + pile1 + " cards");//it's winning pile
       }
      else if(count2 == 1){
         pile2 = pile2 + x;
            x=2;
            view.paintpile2("Computer has " + pile2 + " cards");//it's winning pile
       }
      else if(count1 < count2){
        pile2 = pile2 + x;
            x=2;
            view.paintpile2("Computer has " + pile2 + " cards");
      } 
     else if(count2 < count1){
       pile1 = pile1 + x;
            x=2; 
            view.paintpile1(name + " has " + pile1 + " cards");
     }
       
      //determine who's the winner
      if(pile1 > pile2){winner = name;}//player1 is the winner
      
      
       }
      //if there's no more cards in the carddeck than the game is over
      else{
         //draw the winner's name
         view.paintWinner("The winner is " + winner);
      
         gameover = "Game over";
         JOptionPane.showMessageDialog(null,gameover);
         System.exit(0);
         
       }  
     }    
            
   }

   //this methods all return the suit and count of cards - player1
   public String getCard1(){
      String player1 = c1.countOf() + " " + suit1;
      return player1;
     }
   //this methods all return the suit and count of cards - computer
   public String getCard2(){return c2.countOf() + " " + suit2;}
    
}
