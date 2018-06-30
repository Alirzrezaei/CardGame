package ueb07.cards;

import java.util.Arrays;

/**
 * The cards of one player are stored in a list of type list.
 *
 * @author klk
 */
public class Pack {

    /**
     * reference to the head of the list
     */
    private List list;

    /**
     * Intitializes the list of the head with an empty element.
     */
    public Pack() {
        //TODO insert code
        this.list = new EmptyElement();
    }

    /**
     * Create a pack with the given cards in the list.
     *
     * @param cards cards to be included in the list
     */
    public Pack(Card[] cards) {
        assert (this != null);
        assert (cards != null) : "There is no cards";
        this.addElementArray(cards);
    }

    /**
     * Returns the number of contained cards.
     *
     * @return number of cards
     */
    public int size() {
        //TODO insert code
        if (this.list == null) {
            return 0;
        } else {
            return list.size();
        }
    }

    /**
     * Determines if the card is contained in the pack.
     *
     * @param card card to be searched
     * @return true, if the card is in the pack
     */
    public boolean contains(Card card) {
        //TODO insert code
        if (this.list != null) {
            assert (card != null) : "The card has no value";
            return this.contains(card);
        } else {
            return false;
        }
    }

    /**
     * Adds a card.
     *
     * @param card card to be added
     */
    public void add(Card card) {
        assert (card != null) : "The card has no value";
        if (this.list == null) {
            this.list = new ListElement(card);
        } else {
            this.list.add(card);
        }

    }

    /**
     * Returns the first card.
     *
     * @return card with the lowest value
     */
    public Card getFirstCard() {
        assert (this != null);
        if (this.getCardAt(0) == null) {
            return null;

        } else {
            return this.list.getFirstCardWithValue(getCardAt(0).getValue());
        }
    }

    /**
     * Returns the card at the index
     *
     * @param idx index of the card to be returned
     * @return the card at the idx, null if idx is not valid
     */
    public Card getCardAt(int idx) {
        if (this.list != null) {
            return this.list.getCardAt(idx);
        } else {
            return null;
        }
    }

    /**
     * Returns the smallest card with this value.
     *
     * @param value value of the card to be searched
     * @return smallest card with this value, null if no card with this value
     * exists
     */
    public Card getCardWithValue(int value) {
        if (this.list != null) {
            return this.list.getFirstCardWithValue(value);
        } else {
            return null;
        }
    }

    /**
     * Returns all cards that have the given value.
     *
     * @param value value of the cards to be searched
     * @return all cards with this value, an empty array if no cards with this
     * value exist
     */
    public Card[] getCardsWithValue(int value) {
        //if (value >= 7 && value <= 14) {
        Card[] values = new Card[this.size()];
        if (this.list != null) {
            for (int i = 0; i < this.size(); i++) {
                values[i] = this.getCardAt(i);
            }
        }
        return values;
    }

    /**
     *
     * Returns the smallest card from the pack that has a higher value.
     *
     * @param value value to be surpassed
     * @return the smallest card in the pack, that has a higher value, null if
     * no card with a higher value exists
     */
    public Card getCardWithValueHigherThan(int value) {
        
       return null;
    }

    /**
     * Removes a card, if it is contained.
     *
     * @param card card to be removed
     */
    public void remove(Card card) {
        //TODO insert code
    }

    /**
     * Removes a card at the index if it is valid.
     *
     * @param idx index of the card to be removed
     */
    public void removeAt(int idx) {
        //TODO insert code
    }

    /**
     * Removes each one of the card that is contained.
     *
     * @param cards cards to be removed
     */
    public void remove(Card[] cards) {
        //TODO insert code
    }

    /**
     * Returns all contained cards in an array.
     *
     * @return all cards of the pack in an array
     */
    public Card[] toArray() {
        //TODO insert code        
        return null;
    }

    @Override
    public String toString() {
        //TODO insert code        
        return null;
    }

    private void addElementArray(Card[] cards) {
        for (int i = 0; i < cards.length; i++) {
            this.add(cards[i]);
        }

    }
}
