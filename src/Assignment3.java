// Faye
class Card
{
   // Suit enum of possible suits for cards
   public enum Suit {
     clubs, diamonds, hearts, spades;
   }
   
   // private data members
   private char value;
   private Suit suit;
   private boolean errorFlag;
  
   // default constructor
   public Card()
   {
      set('A', Suit.spades);
   }
   
   // overloaded constructor that accepts a value and suit
   // calls on set() method to set the values
   public Card(char value, Suit suit)
   {
      set(value, suit);
   }
   
   // if no errors, returns a string with the card value and suit
   // if errorFlag is true, returns an error message
   public String toString()
   {
      if(errorFlag == true)
         return "[Invalid card]";
      return value + " of " + suit;
   }
   
   // sets the values of the card
   // uses private method isValid() to determine if values are appropriate
   // then sets errorFlag based on return of isValid()
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
   
   // accessor for errorFlag
   public boolean getErrorFlag()
   {
      return errorFlag;
   }
   
   // accessor for suit
   public Suit getSuit()
   {
      return suit;
   }
   
   // accessor for value 
   public char getValue()
   {
      return value;
   }
   
   // compares this object to another card. Determines if they are equal
   // based on value and suit
   public boolean equals(Card card)
   {
      if(value == card.value && suit == card.suit)
         return true;
      return false;
   }
   
   // private method to validate data
   // only checks for validity of value
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

class Deck //Roderick
{
   private static Card[] masterPack;
   private Card[] cards;
   
   int topCard;
   int numPacks;
   
   public Deck()
   {
      
   }
   
   public void init(int numPacks)
   {
      
   }
   
   public void shuffle()
   {
      
   }
   
   public Card dealCard()
   {
      return new Card();
   }
   
   public int getTopCard()
   {
      return topCard;
   }
   
   public Card inspectCar(int k)
   {
      return new Card();
   }
   
   private static void allocateMasterPack()
   {
      
   }
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
      //Testing card class
      Card card1 = new Card();
      Card card2 = new Card('J', Card.Suit.hearts);
      Card card3 = new Card('L', Card.Suit.diamonds);
      
      card1.set('A', Card.Suit.spades);
      System.out.println(card1.toString());
      System.out.println(card2.toString());
      System.out.println(card3.toString()); 
   }

}
