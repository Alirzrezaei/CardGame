package ueb07.cards;

/**
 * Cards of the 4 suits from seven to ace, lowest value and suit first.
 *
 * @author Gerit
 */
public enum Card {
    SEVEN_CLUBS(7), SEVEN_DIAMONDS(7), SEVEN_HEARTS(7), SEVEN_SPADES(7),
    EIGHT_CLUBS(8), EIGHT_DIAMONDS(8), EIGHT_HEARTS(8), EIGHT_SPADES(8),
    NINE_CLUBS(9), NINE_DIAMONDS(9), NINE_HEARTS(9), NINE_SPADES(9),
    TEN_CLUBS(10), TEN_DIAMONDS(10), TEN_HEARTS(10), TEN_SPADES(10),
    JACK_CLUBS(11), JACK_DIAMONDS(11), JACK_HEARTS(11), JACK_SPADES(11),
    QUEEN_CLUBS(12), QUEEN_DIAMONDS(12), QUEEN_HEARTS(12), QUEEN_SPADES(12),
    KING_CLUBS(13), KING_DIAMONDS(13), KING_HEARTS(13), KING_SPADES(13),
    ACE_CLUBS(14), ACE_DIAMONDS(14), ACE_HEARTS(14), ACE_SPADES(14);

    /**
     * the value of the card
     */
    private final int value;

    /**
     * construct a card with a value and a suit
     *
     * @param value value of the card
     */
    Card(int value) {
        this.value = value;
    }

    /**
     * gets the value of the card
     *
     * @return the value of the card
     */
    public int getValue() {
        return value;
    }

    /**
     * gets the highest value
     *
     * @return the highest value
     */
    public static int getHighestValue() {
        return Card.values()[Card.values().length - 1].getValue();
    }

    /**
     * gets next card
     *
     * @return next card, null if this is the card with the highest ordinality
     */
    public Card getNext() {
        return this.ordinal() == Card.values().length - 1
                ? null
                : Card.values()[this.ordinal() + 1];
    }

    /**
     * checks whether the other card has the same value
     *
     * @param other card to compare with
     * @return true, if the other card has the same value, false otherwise
     */
    public boolean hasSameValue(Card other) {
        return other != null && this.value == other.value;
    }

    /**
     * checks whether the other card has the same value
     *
     * @param value to compare with
     * @return true, if this card has the given value, false otherwise
     */
    public boolean hasSameValue(int value) {
        return this.value == value;
    }

    /**
     * checks if this card has a higher value than other
     *
     * @param other card to compare with
     * @return true, if this card has a higher value than other or other == null
     */
    public boolean hasHigherValue(Card other) {
        return other == null || compareCardByValue(other) > 0;
    }

    /**
     * checks if this is a card with a lower value than the given card
     *
     * @param other card to compare with
     * @return true, if this is a card with a lower value than the given card
     */
    public boolean hasLowerValue(Card other) {
        return other != null && compareCardByValue(other) < 0;
    }

    /**
     * checks if this card has a higher value than value
     *
     * @param value value to compare with
     * @return true, if this card has a higher value than value
     */
    public boolean hasHigherValue(int value) {
        return getValue() > value;
    }

    /**
     * checks if this is a card with the highest value
     *
     * @return true if this is a card with the highest value
     */
    public boolean hasHighestValue() {
        return getValue() == getHighestValue();
    }

    /**
     * checks if this is an ace
     *
     * @return true, if this is an ace
     */
    public boolean isAce() {
        return this == ACE_HEARTS || this == ACE_DIAMONDS || this == ACE_SPADES || this == ACE_CLUBS;
    }

    /**
     * compares the cards by value. The cards are sorted by value and then by
     * suit. The suit is not relevant for this comparison. If other == null a
     * NullPointerException is thrown.
     *
     * @param other card to compare with
     * @return -1, if this value is lower than the others value 0, if this value
     * is the same as the others value +1, if this value is higher than the
     * others value
     */
    public int compareCardByValue(Card other) {
        if (this.value < other.value) {
            return -1;
        } else if (this.value > other.value) {
            return +1;
        } else {
            return 0;
        }
    }
}
