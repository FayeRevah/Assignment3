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

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Assignment3
{

    public static void main(String[] args)
    {
        /*System.out.println("Deck Test");
        
        Deck testDeck = new Deck(2);
        int cardCount = testDeck.getTopCard() +1;
        while (cardCount > 0)
        {
            System.out.print(testDeck.dealCard() + "  /  ");
            cardCount--;
        }
        System.out.println("");
        System.out.println("");
        
        testDeck.init(2);
        testDeck.shuffle();
        cardCount = testDeck.getTopCard() +1;
        while (cardCount > 0)
        {
            System.out.print(testDeck.dealCard() + "  /  ");
            cardCount--;
        }
        System.out.println("");
        System.out.println("");
        
        testDeck.init(1);
        cardCount = testDeck.getTopCard() +1;
        while (cardCount > 0)
        {
            System.out.print(testDeck.dealCard() + "  /  ");
            cardCount--;
        }
        System.out.println("");
        System.out.println("");
        
        testDeck.init(1);
        testDeck.shuffle();
        cardCount = testDeck.getTopCard() +1;
        while (cardCount > 0)
        {
            System.out.print(testDeck.dealCard() + "  /  ");
            cardCount--;
        }
        System.out.println("");
        System.out.println("");*/

        Deck playDeck = new Deck(4);
        int deckSize = playDeck.getTopCard();
        int numPlayers;
        ArrayList<Hand> playersHands;
        boolean numPlayerGood = false;
        Scanner readIn = new Scanner(System.in);

        do
        {
            System.out.print("How many players? (1 - 10, please): ");
            numPlayers = readIn.nextInt();
            if (numPlayers > 0 && numPlayers < 11)
            {
                numPlayerGood = true;
            }
            if (!numPlayerGood)
            {
                System.out.println("Invalid input, please try again!");
            }
        } while (!numPlayerGood);

        playersHands = new ArrayList<>();
        for ( int p = 0; p < numPlayers; p++)
            playersHands.add(new Hand());

        for ( int dc = 6 ; dc > 0 ; dc-- )
            for ( Hand playerHand : playersHands )
                playerHand.takeCard(playDeck.dealCard());

        System.out.println("Here is the players hands from an unshuffled deck: ");
        for ( Hand playerHand : playersHands )
        {
            System.out.println(playerHand);
            System.out.println("");
        }
        
        System.out.println("");
        System.out.println("");
        
        playDeck.init(4);
        playDeck.shuffle();
        
        for ( Hand playerHand : playersHands )
            playerHand.resetHand();

        for ( int dc = 6 ; dc > 0 ; dc-- )
            for ( Hand playerHand : playersHands )
                playerHand.takeCard(playDeck.dealCard());

        System.out.println("Here is the players hands from a shuffled deck: ");
        for ( Hand playerHand : playersHands )
        {
            System.out.println(playerHand);
            System.out.println("");
        }
        
        /*Card test1 = new Card('A', Card.Suit.clubs);
        Card test2 = new Card('8', Card.Suit.hearts);
        Card test3 = new Card('K', Card.Suit.spades);
        Card test4 = new Card('J', Card.Suit.diamonds);
        Card test5 = new Card('4', Card.Suit.spades);
        
        Hand testHand = new Hand();
        testHand.takeCard(test1);
        testHand.takeCard(test2);
        testHand.takeCard(test3);
        testHand.takeCard(test4);
        testHand.takeCard(test5);
        
        System.out.println(testHand);*/

    }

}

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

    public static int MAX_CARDS = 50;
    private Card[] myCards;
    private int numCards;

    // Default Constructor
    public Hand()
    {
        myCards = new Card[MAX_CARDS];
        numCards = 0;
    }

    // Method that removes all cards from the Hand[] array
    public void resetHand()
    {
        myCards = new Card[MAX_CARDS];
        numCards = 0;
    }

    // This method adds cards to the next available position
    public boolean takeCard(Card card)
    {
        if (numCards >= MAX_CARDS)
        {
            return false;
        }
        else
        {
            myCards[numCards++] = card;
            //numCards++;
            return true;
        }
    }

    // This method returns and removes the card in the top position of the array
    public Card playCard()
    {
        Card card = myCards[numCards - 1];
        myCards[numCards - 1] = null;
        return card;
    }

    // This method is a stringizer that is used prior to displaying the entire hand
    public String toString()
    {
        String str = "Hand = ( ";
        if (numCards == 0)
        {
            str += "empty hand )";
        }
        else
        {
            for (int i = 0; i < numCards - 1; i++)
            {
                str += myCards[i] + ", ";
            }
            str += myCards[numCards - 1] + " )";
        }
        return str;
    }

    // Getter for numCards
    public int getNumCards()
    {
        return numCards;
    }

    // Accessor to inspect an individual card, returns erroFlag = true if k is bad
    public Card inspectCard(int k)
    {
        Card card;
        if (k <= numCards)
        {
            card = new Card('T', Card.Suit.spades);
        }
        else
        {
            card = myCards[k - 1];
        }
        return card;
    }
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
        init(1);
    }

    public Deck(int numPacks)
    {
        init(numPacks);
    }

    public void init(int numPacks)
    {
        allocateMasterPack();
        this.numPacks = numPacks;
        this.topCard = (52 * this.numPacks) - 1;

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
        int shufCount = 5 * (52 * numPacks);

        do
        {
            int cardA = rand.nextInt(split);
            int cardB = rand.nextInt(split) + split;

            Card temp = cards[cardA];
            cards[cardA] = cards[cardB];
            cards[cardB] = temp;

            shufCount--;
        } while (shufCount != 0);

    }

    public Card dealCard()
    {
        Card retVal = cards[topCard];
        cards[topCard] = null;
        if (topCard > 0)
        {
            topCard--;
        }
        return retVal;
    }

    public int getTopCard()
    {
        return topCard;
    }

    public Card inspectCard(int k)
    {
        return cards[k];
    }

    private static void allocateMasterPack()
    {
        if (masterPack == null)
        {
            masterPack = new Card[52];

            for (Card.Suit s : Card.Suit.values())
            {
                for (int x = 1; x < 14; x++)
                {
                    Card newCard;
                    int value = x % 14;
                    switch (value)
                    {
                        case 1:
                            newCard = new Card('A', s);
                            break;
                        case 10:
                            newCard = new Card('T', s);
                            break;
                        case 11:
                            newCard = new Card('J', s);
                            break;
                        case 12:
                            newCard = new Card('Q', s);
                            break;
                        case 13:
                            newCard = new Card('K', s);
                            break;
                        default:
                            newCard = new Card(Integer.toString(value).charAt(0), s);
                    }
                    if (s == Card.Suit.clubs)
                    {
                        masterPack[x - 1] = newCard;
                    }
                    else if (s == Card.Suit.diamonds)
                    {
                        masterPack[(x - 1) + 13]
                                = newCard;
                    }
                    else if (s == Card.Suit.hearts)
                    {
                        masterPack[(x - 1) + 26]
                                = newCard;
                    }
                    else
                    {
                        masterPack[(x - 1) + 39] = newCard;
                    }
                }
            }
        }
    }
}
