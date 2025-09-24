package psmodel;

import cardutils.Pile;
import cardutils.Rank;
import cardutils.Suit;

public class PokerHands {

    private PokerHands(){};

    public static PokerCombo getPokerCombo(Pile pile){
        if (isFourOfAKind(pile)) {
            return PokerCombo.FOUR_OF_A_KIND;
        }
        if (isFlush(pile)) {
            return PokerCombo.FLUSH;
        }
        if (isThreeOfAKind(pile)) {
            return PokerCombo.THREE_OF_A_KIND;
        }
        switch (countPairs(pile)) {
            case 2:
                return PokerCombo.TWO_PAIR;
            case 1:
                return PokerCombo.PAIR;
            default:
                return PokerCombo.NONE;
        }
    }

    private static int countPairs(Pile p){
        int pairs = 0;
        for(Rank r: Rank.values()){
            if(p.noOfRank(r) == 2) {
                pairs++;
            }
        }
        return pairs;
    }

    private static boolean  isThreeOfAKind(Pile p){
        for(Rank r: Rank.values()){
            if(p.noOfRank(r) == 3){
                return true;
            }
        }
        return false;
    }

    private static boolean isFourOfAKind(Pile p){
        for(Rank r: Rank.values()){
            if(p.noOfRank(r) == 4){
                return true;
            }
        }
        return false;
    }

    private static boolean isFlush(Pile p){
        for(Suit s: Suit.values()){
            if(p.noOfSuit(s) == 5){
                return true;
            }
        }
        return false;
    }

    public static int pointsFor(PokerCombo combo) {
         switch (combo) {
            case NONE:
                return 0;
            case PAIR:
                return 1;
            case TWO_PAIR:
                return 2;
            case THREE_OF_A_KIND:
                return 3;
            case FLUSH:
                return 5;
            case FOUR_OF_A_KIND:
                return 10;
            default:
                return 0;
        }
    }
}
