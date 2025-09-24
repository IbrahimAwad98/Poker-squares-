package cardutils;
import java.util.ArrayList;
import java.util.Collections;


public class Deck {

    private final ArrayList<Card> theCards;
    private static final ArrayList<Card> protoDeck = new ArrayList<>();

    static{
        for(Suit s : Suit.values()){
            for(Rank r: Rank.values()){
                protoDeck.add(new Card(s,r));
            }
        }
    }

    public Deck(){
        theCards = new ArrayList<>();
        fill();
    }

    public void fill(){
        theCards.clear();
        theCards.addAll(protoDeck);
    }

    public int getSize(){
        return theCards.size();
    }

    public boolean isEmpty(){
        return theCards.isEmpty();
    }

    public Card dealCard(){
        if(theCards.isEmpty())
        {
            throw new IllegalStateException("Deck is empty!");
        }
        return theCards.remove(getSize() - 1);
    }

    public void shuffleCards(){
        Collections.shuffle(theCards);
    }

    @Override
    public String toString() {
        return theCards.toString();
    }
}