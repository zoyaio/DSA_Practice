package blackJack;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;

public class Player
{
   private ArrayList<Card> hand;
   private int winCount;

   public Player ()
   {
      winCount = 0;
      hand = new ArrayList<Card>();
   }

   public Player (int score)
   {
      winCount = score;
      hand = new ArrayList<Card>();
   }

   public void addCardToHand( Card temp )
   {
      hand.add(temp);
   }

   public void resetHand( )
   {
      hand = new ArrayList<Card>();
   }

   public void setWinCount( int numwins )
   {
      winCount = numwins;
   }

   public void incrementWins(  )
   {
      winCount ++;
   }

   public int getWinCount() { return winCount; }

   public int getHandSize() { return hand.size(); }

   public int getHandValue()
   {
      int sum = 0;
      for (Card car : hand) {
         sum += car.getValue();
      }
      return sum;

   }

   public  boolean  hit( )
   {

     if (getHandValue() < 17) {
        return true;
     }
     return false;
   }

   public String toString()
   {
//      String handstr = "";
//      for (String )
      return String.format("Hand Value :: %d \nHand Size :: %d \nCards in hand :: %s",
              getHandValue(), getHandSize(), hand.toString());
   }
}