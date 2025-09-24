package cardutils;
import java.util.ArrayList;
import java.util.List;

public class Pile {

    private final ArrayList<Card> pileCards;

    public Pile(){
        pileCards = new ArrayList<>();
    }

    public Pile(Pile other){
        this.pileCards = new ArrayList<>(other.getCards());
    }

    public int getSize(){
        return pileCards.size();
    }

    public boolean isEmpty(){
        return pileCards.isEmpty();
    }

    public void clear(){
        pileCards.clear();
    }

    public void add(Card c){
        pileCards.add(c);
    }

    public void add(List<Card> cards){
        pileCards.addAll(cards);
    }

    public Card get(int position){
        if(position < 0 || position >= pileCards.size()){
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return pileCards.get(position);
    }

    public List<Card> getCards(){
        return new ArrayList<>(pileCards);
    }

    public Card remove(int position){
        if(position < 0 || position >= pileCards.size()){
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return pileCards.remove(position);
    }

    public boolean remove(Card c){
        return pileCards.remove(c);
    }

    public boolean remove(List<Card> cards) {
        return pileCards.removeAll(cards);
    }

    public boolean contains(Card c){
        return pileCards.contains(c);
    }

    public int noOfSuit(Suit suit){
        int count = 0;
        for(Card c : pileCards){
            if(c.getSuit() == suit){
                count++;
            }
        }
        return count;
    }

    public int noOfRank(Rank rank) {
        int count = 0;
        for (Card c : pileCards) {
            if (c.getRank() == rank) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "Pile (" + getSize() + " cards): " + pileCards.toString();
    }
}