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


public class Assignment3 {

    public static void main(String[] args)
    {
        Deck testDeck = new Deck(3);
    }

}

class Card // Faye
{
    public Card()
    {
        //
    }
}

class Hand // Oswaldo
{
    public Hand()
    {
        //
    }
}

class Deck // Roderick
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
            System.out.println("master pack created");
        }
    }
}
