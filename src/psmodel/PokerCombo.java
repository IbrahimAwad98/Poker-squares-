package psmodel;

public enum PokerCombo {
    NONE,
    PAIR,
    TWO_PAIR,
    THREE_OF_A_KIND,
    FLUSH,
    FOUR_OF_A_KIND;

    public String toString() {
        return name().replace('_', ' ');
    }
}
