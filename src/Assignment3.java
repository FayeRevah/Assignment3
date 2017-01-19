//Faye
class Card
{
   public enum Suit {
     clubs, diamonds, hearts, spades;
   }
   
   private char value;
   private Suit suit;
   private boolean errorFlag;
  
   public Card(char value, Suit suit)
   {
      set(value, suit);
   }
   
   public Card()
   {
      set('A', Suit.spades);
   }
   
   public String toString()
   {
      if(errorFlag == true)
         return "[Invalid card]";
      return value + " of " + suit;
   }
   
   public boolean set(char value, Suit suit)
   {
      if(isValid(value, suit))
      {
         this.value = value;
         this.suit = suit;
         errorFlag = false;
         return true;
      }
      errorFlag = true;
      return false;
   }
   
   public boolean getErrorFlag()
   {
      return errorFlag;
   }
   
   public Suit getSuit()
   {
      return suit;
   }
   
   public char getValue()
   {
      return value;
   }
   
   public boolean equals(Card card)
   {
      if(value == card.value && suit == card.suit)
         return true;
      return false;
   }
   
   private boolean isValid(char value, Suit suit)
   {
      if((value >= '2' && value <= '9') || 
            value == 'T' || value == 't' ||
            value == 'A' || value == 'a' ||
            value == 'J' || value == 'j' ||
            value == 'K' || value == 'k' || 
            value == 'Q' || value == 'q')
         return true;
      return false;
   }
}

//Roderick
class Deck
{
   
}

//Oswaldo
class Hand
{
   
}

public class Assignment3
{
   //Roderick
   public static void main(String[] args)
   {
      Card card1 = new Card();
      Card card2 = new Card('J', Card.Suit.hearts);
      Card card3 = new Card('L', Card.Suit.diamonds);
      
      card1.set('A', Card.Suit.spades);
      System.out.println(card1.toString());
      System.out.println(card2.toString());
      System.out.println(card3.toString());
      
   }

}
