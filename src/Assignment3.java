/* ==================================================================
*
*   PROGRAM NAME:
*       Assignment3 - Deck of Cards
*
*   Description:
*	Card:  A class like the one presented in the modules, but with a few
*       changes.
*       Hand:  A class that represents the cards held by a single player.
*       Deck:  A class that represents the source of the cards for dealing and, 
*       as the game progresses, the place from which players can receive new 
*       cards (say, as they pick cards "from the deck" or when future hands 
*       are to be dealt from the same deck).  Recall this picture, which 
*       relates the Deck to the various Hands that it creates through the 
*       process called "dealing".
*       
*       Notice that the char 'T' to describe the value 10. The Joker is ignored
*       as it is not need at this time.
*       
*       The dealer uses a Deck object to deal Hand objects to the players.  
*       The dealer may or may not be a player who gets a hand of his own 
*       (poker dealers in casinos don't receive a hand, but most other games 
*       involve the dealer getting a hand).
*       
*       Card: The Card class has two obvious members:  value (a char)  and suit 
*       (an enum).  But we add a new boolean, errorFlag, which can inform a 
*       client that a card is in an illegal state. We'll want the usual 
*       constructors, mutators, accessors and toString() methods for the class. 
*       We only allow standard cards, like ('A', clubs), ('9', hearts) and ('T',
*       diamonds), no jokers or other special cards.
*       
*       Hand:  As you can see, a Hand object usually contains several cards, so
*       we'll need an array of Card objects (myArray) as the principal member 
*       of the Hand class.  Since each game deals a different number of cards 
*       into its players hands, and even within a game the number of cards in a 
*       hand will increase or decrease, we must keep track of this with an int 
*       value (numCards).  We'll need constructors, mutators, etc., of course.  
*       We'll also want a way for the hand to receive a card (from the deck or 
*       somewhere else), and play a card (to the table or to another player).  
*       These two methods will be called takeCard() and playCard(), 
*       respectively.  Since this class has no information about the game being 
*       played, it always puts new cards received by takeCard() into the next 
*       available location of the array (index position numCards) and plays a 
*       card via playCard() from the highest occupied location (index position 
*       numCards - 1).  The client game application would somehow prepare this 
*       highest position with the correct card to be played before calling 
*       Hand's playCard() method.  This detail is not our concern.
*       
*       Deck: A Deck object is the source of all cards.  It's where the dealer 
*       gets cards to deal, and if a player takes an individual card after the 
*       deal, he takes it from the Deck object.  Naturally, the primary member 
*       here is an array of Card objects, much like Hand.  We'll call this 
*       member cards[].  A deck normally consists of a single pack of cards: 
*       52 cards (four suits of 13 values each).  However, some games use two, 
*       three or more packs.  If a card game requires two packs, then the deck 
*       will consist of two full 52-card packs:  104 cards.  (Many games throw 
*       away some cards before beginning.  For example Pinochle wants all cards 
*       with values 8-and-below to be taken out of the deck, but we will not 
*       trouble ourselves with this complexity.)  A newly instantiated deck 
*       will have a multiple of 52 cards and will contain all the standard 
*       cards, so the number of cards in a newly instantiated deck will be 52, 
*       104, 156, ...,  i.e., numPacks × 52.
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

        // do loop asks for the number of players from 1 to 10 and continues
        // looping through the process until the user inputs a number that is
        // 1 to 10
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

        // initalizes a playerdHands arrayList and than adds an empty hand for 
        // each player
        playersHands = new ArrayList<>();
        for ( int p = 0; p < numPlayers; p++)
            playersHands.add(new Hand());

        // fills each player hand with 6 cards from an unsuffled deck of cards.
        for ( int dc = 6 ; dc > 0 ; dc-- )
            for ( Hand playerHand : playersHands )
                playerHand.takeCard(playDeck.dealCard());

        // Displays the hands that were dealt to each player
        System.out.println("Here is the players hands from an unshuffled deck: ");
        for ( Hand playerHand : playersHands )
        {
            System.out.println(playerHand);
            System.out.println("");
        }
        
        System.out.println("");
        System.out.println("");
        
        playDeck.init(4); // re-initalizes the Deck
        playDeck.shuffle(); // Shuffles the cards in the deck
        
        // resets all the players hands to empty
        for ( Hand playerHand : playersHands )
            playerHand.resetHand();

        // deals out 6 cards to each player's hand from a deck that has been 
        // shuffled.
        for ( int dc = 6 ; dc > 0 ; dc-- )
            for ( Hand playerHand : playersHands )
                playerHand.takeCard(playDeck.dealCard());

        // Displays the players hands as they were dealth from a shuffled deck
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

    // A constructor that populates the arrays and assigns initial values to
    // members with the assistance of init()
    // Defaults to one pack of cards in the deck.
    public Deck()
    {
        init(1);
    }

    // A constructor that populates the arrays and assigns initial values to
    // members with the assistance of init(). This constructor is an overload
    // of the default constructor allowing for an parameter being set with the 
    // number of packs the deck will contain.
    // Takes one parameter, an int numPacks, that is used to to create a deck
    // of cards that is a combination of more than one pack
    public Deck(int numPacks)
    {
        init(numPacks);
    }

    // This public method initializes a deck of card according to the parameter
    // numPacks which is passed to it. This method calls on private method
    // allocateMasterPack() which sets the static array with 52 cards used to 
    // create each pack that is added to the Deck.
    // Here the private members numPacks and topCard are allso set accordingly.
    // The parameter int numPacks tells the method how many packs of cards are
    // to be added to the Deck from the masterPack.
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

    // This public method is used to randomly shuffle the cards within a deck
    // so that all card are out of sequence.
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

    // A public method that returns the card on the top of the deck replacing
    // its position in the array with a null, and moving the topCard private
    // member to the next card in the deck.
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

    // This is an accessor method used to retreive the position of the current
    // top card in the deck array.
    public int getTopCard()
    {
        return topCard;
    }
    
    // Accessor for an individual card. 
    //Returns a card with errorFlag = true if k is bad
    public Card inspectCard(int k)
    {
        if (cards[k].getErrorFlag())
            return cards[k];
        else
            return new Card();
        
    }
    
    // This private method is used to fill the masterPack array with 52 unique
    // cards, which can than be used to populate a deck as needed. This method
    // will only run when the first deck in the program is initialized. If the
    // masterPack array is not null the method simply end makeing no changes to
    // the masterPack array.
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

/*******************RUN 1*******************************************************
How many players? (1 - 10, please): 9
Here is the players hands from an unshuffled deck: 
Hand = ( K of spades, 4 of spades, 8 of hearts, Q of diamonds, 3 of diamonds, 7 of clubs )

Hand = ( Q of spades, 3 of spades, 7 of hearts, J of diamonds, 2 of diamonds, 6 of clubs )

Hand = ( J of spades, 2 of spades, 6 of hearts, T of diamonds, A of diamonds, 5 of clubs )

Hand = ( T of spades, A of spades, 5 of hearts, 9 of diamonds, K of clubs, 4 of clubs )

Hand = ( 9 of spades, K of hearts, 4 of hearts, 8 of diamonds, Q of clubs, 3 of clubs )

Hand = ( 8 of spades, Q of hearts, 3 of hearts, 7 of diamonds, J of clubs, 2 of clubs )

Hand = ( 7 of spades, J of hearts, 2 of hearts, 6 of diamonds, T of clubs, A of clubs )

Hand = ( 6 of spades, T of hearts, A of hearts, 5 of diamonds, 9 of clubs, K of spades )

Hand = ( 5 of spades, 9 of hearts, K of diamonds, 4 of diamonds, 8 of clubs, Q of spades )



Here is the players hands from a shuffled deck: 
Hand = ( J of clubs, 4 of clubs, 3 of clubs, 6 of diamonds, 3 of clubs, T of diamonds )

Hand = ( A of clubs, K of clubs, T of clubs, Q of diamonds, J of diamonds, K of spades )

Hand = ( J of spades, Q of hearts, T of hearts, 5 of diamonds, 3 of hearts, A of hearts )

Hand = ( 5 of hearts, 5 of clubs, 7 of clubs, T of spades, 5 of spades, 9 of spades )

Hand = ( 5 of hearts, 9 of diamonds, K of diamonds, 9 of hearts, K of clubs, J of spades )

Hand = ( 6 of clubs, 9 of spades, Q of clubs, 3 of diamonds, 4 of spades, A of diamonds )

Hand = ( 5 of hearts, Q of clubs, 4 of hearts, 7 of clubs, 6 of spades, Q of spades )

Hand = ( 7 of spades, 8 of diamonds, K of spades, 5 of hearts, 3 of diamonds, 8 of hearts )

Hand = ( 9 of diamonds, 4 of spades, 2 of diamonds, Q of spades, A of spades, 3 of clubs )
*******************************************************************************/



/*******************RUN 2*******************************************************
How many players? (1 - 10, please): 11
Invalid input, please try again!
How many players? (1 - 10, please): -1
Invalid input, please try again!
How many players? (1 - 10, please): 6
Here is the players hands from an unshuffled deck: 
Hand = ( K of spades, 7 of spades, A of spades, 8 of hearts, 2 of hearts, 9 of diamonds )

Hand = ( Q of spades, 6 of spades, K of hearts, 7 of hearts, A of hearts, 8 of diamonds )

Hand = ( J of spades, 5 of spades, Q of hearts, 6 of hearts, K of diamonds, 7 of diamonds )

Hand = ( T of spades, 4 of spades, J of hearts, 5 of hearts, Q of diamonds, 6 of diamonds )

Hand = ( 9 of spades, 3 of spades, T of hearts, 4 of hearts, J of diamonds, 5 of diamonds )

Hand = ( 8 of spades, 2 of spades, 9 of hearts, 3 of hearts, T of diamonds, 4 of diamonds )



Here is the players hands from a shuffled deck: 
Hand = ( T of clubs, 9 of clubs, T of spades, 4 of clubs, 5 of clubs, T of clubs )

Hand = ( 7 of clubs, T of spades, 5 of hearts, J of diamonds, 2 of diamonds, 3 of hearts )

Hand = ( 3 of spades, 3 of diamonds, 2 of spades, 2 of diamonds, Q of diamonds, 4 of diamonds )

Hand = ( 9 of diamonds, 6 of clubs, A of hearts, A of hearts, A of spades, 9 of hearts )

Hand = ( Q of diamonds, K of diamonds, 9 of hearts, T of clubs, 8 of diamonds, 5 of spades )

Hand = ( J of spades, J of diamonds, Q of hearts, 9 of hearts, 6 of hearts, Q of clubs )
*******************************************************************************/

