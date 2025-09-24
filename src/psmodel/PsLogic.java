package psmodel;

import cardutils.Card;
import cardutils.Deck;
import cardutils.Pile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PsLogic implements IPsLogic {

    private final Deck deck;
    private final List<Pile> piles;
    private Card nextCard;
    private int cardCount;

    public PsLogic(){
        this.deck = new Deck();
        this.piles = new ArrayList<>(5);
        for(int i = 0; i < 5 ; i++){
            piles.add(new Pile());
        }
    }

    public void initNewGame(){
        deck.fill();
        deck.shuffleCards();
        for(int i = 0; i < piles.size(); i++){
            piles.get(i).clear();
        }
        nextCard = null;
        cardCount = 0;
    }

    public int getCardCount(){
        return cardCount;
    }

    public Card pickNextCard(){
        if(nextCard != null){
            throw new IllegalStateException("Place the current card first!");
        }
        if(cardCount >= 25){
            throw new IllegalStateException("Game is over!");
        }
        nextCard = deck.dealCard();
        return nextCard;
    }

    public void addCardToPile(int pileIndex){
        if(nextCard == null){
            throw new IllegalStateException("Draw a card first!");
        }
        if(pileIndex < 0 || pileIndex > piles.size()){
            throw new IndexOutOfBoundsException("Invalid pile index: " + pileIndex);
        }
        Pile target = piles.get(pileIndex);
            if(target.getSize() >= 5){
                throw new IllegalStateException("Pile " + pileIndex + " is full!");
            }

        target.add(nextCard);
        nextCard = null;
        cardCount++;
    }

    public List<Pile> getPiles(){
        List<Pile> copies = new ArrayList<>();
       for(Pile original : piles){
           copies.add(new Pile(original));
       }
        return Collections.unmodifiableList(copies);
    }

    public boolean isGameOver(){
        return cardCount == 25;
    }

    public int getPoints(){
        int points = 0;
        for(Pile p: piles){
            if(!p.isEmpty()){
                PokerCombo combo = PokerHands.getPokerCombo(p);
                points += PokerHands.pointsFor(combo);
            }
        }
        return points;
    }

    @Override
    public String toString() {
        return "PsLogic{" +
                "deck=" + deck +
                ", piles=" + piles +
                ", nextCard=" + nextCard +
                ", cardCount=" + cardCount +
                '}';
    }
}