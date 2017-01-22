/* ==================================================================
*
*   PROGRAM NAME:
*       Assignment3 - Deck of Cards
*
*   Description:
*	Here
*
*   Classes:
*       Card, Hand, Deck
*
*   Parameters:
*       1. none
*
*   Additional Files:
*
*   Created:
*       2017/01/18
*
*   Author/s:
*       Roderick Burkhardt, Oswaldo Minez, Faiga Revah
*
* ==================================================================*/

import java.util.Random;


// Faye
class Card
{
    // Suit enum of possible suits for cards

    public enum Suit
    {
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
        if (errorFlag == true)
        {
            return "[Invalid card]";
        }
        return value + " of " + suit;
    }

    // sets the values of the card
    // uses private method isValid() to determine if values are appropriate
    // then sets errorFlag based on return of isValid()
    public boolean set(char value, Suit suit)
    {
        if (isValid(value, suit))
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
        if (value == card.value && suit == card.suit)
        {
            return true;
        }
        return false;
    }

    // private method to validate data
    // only checks for validity of value
    private boolean isValid(char value, Suit suit)
    {
        if ((value >= '2' && value <= '9')
                || value == 'T' || value == 't'
                || value == 'A' || value == 'a'
                || value == 'J' || value == 'j'
                || value == 'K' || value == 'k'
                || value == 'Q' || value == 'q')
        {
            return true;
        }
        return false;
    }
}

class Hand //Oswaldo
{

}

class Deck //Roderick
{

    public final int MAX_CARDS = 312; // max 6 decks of 52 cards

    private static Card[] masterPack;
    private Card[] cards;

    int topCard;
    int numPacks;

    public Deck()
    {
        allocateMasterPack();
        this.numPacks = 1;
        init(this.numPacks);
    }

    public Deck(int numPacks)
    {
        allocateMasterPack();
        this.numPacks = numPacks;
        init(this.numPacks);
    }

    public void init(int numPacks)
    {
        cards = new Card[52 * numPacks];

        for (int pack = 0; pack < numPacks; pack++)
        {
            for (int card = 0; card < masterPack.length; card++)
            {
                cards[(52 * pack) + card] = masterPack[card];
            }
        }
    }

    public void shuffle()
    {
        int split = cards.length / 2;
        Random rand = new Random();

        for (int shufTurn = 0; shufTurn < 5; shufTurn++)
        {
            for (int card = 0; card <= split;)
            {
                int shuffleCard = rand.nextInt(3);
                Card temp = cards[card + shuffleCard];
                cards[card + shuffleCard] = cards[card];
                cards[card] = temp;

                card += shuffleCard;
            }
        }

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
        if (masterPack == null)
        {
            masterPack = new Card[52];
            
            for (Card.Suit s : Card.Suit.values())
                
            /*for (int x = 0; x < masterPack.length; x++)
            {
                int enumChange = 0;
                if (x % 26 == 0)
                {
                    enumChange++;
                }

                masterPack[x] = new Card();
            }*/
            System.out.println("master pack created");
        }
    }
}
