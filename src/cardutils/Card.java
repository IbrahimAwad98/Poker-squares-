package cardutils;

public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Rank getRank(){
        return rank;
    }

    public Suit getSuit(){
        return suit;
    }

    public int getRankValue(){
        return rank.getValue();
    }

    public int getSuitValue(){
        return suit.ordinal();
    }

    @Override
    public String toString() {
        return rank.toString() + suit.getSymbol();
    }
}