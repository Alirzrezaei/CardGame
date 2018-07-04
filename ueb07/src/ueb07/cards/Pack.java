package ueb07.cards;

import java.util.Arrays;
import ueb07.cards.*;

/**
 * The class Pack, which as an attribute has the reference to a list. After
 * creating a Pack, the reference references an EmptyElement. The cards of one
 * player are stored in a list of type list.
 *
 * @author klk
 */
public class Pack {

    /**
     * reference to the head of the list
     */
    private List list = new EmptyElement();

    /**
     * Intitializes the list of the head with an empty element.
     */
    public Pack() {
        this.list = new EmptyElement();
    }

    /**
     * Create a pack with the given cards in the list.
     *
     * @param cards cards to be included in the list
     */
    public Pack(Card[] cards) {
        assert (cards != null) : "There is no cards";
        this.addElementArray(cards);
    }

    /**
     * Returns the number of contained cards.
     *
     * @return number of cards
     */
    public int size() {
        //if (this.list != null) {
        return this.list.size();
        //} else {
        //   return 0;
        // }
        //return this.list.size();
    }

    /**
     * Determines if the card is contained in the pack.
     *
     * @param card card to be searched
     * @return true, if the card is in the pack
     */
    public boolean contains(Card card) {
        return this.list.contains(card);

    }

    /**
     * Adds a card.
     *
     * @param card card to be added
     */
    public void add(Card card) {
        assert (card != null) : "The card has no value";
        list = list.add(card);
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

        Card[] values = null;
        int j = 0;
        if (this.list != null && value >= 7 && value <= 14) {
            for (int i = 0; i < this.size(); i++) {
                if (this.getCardAt(i).hasSameValue(value)) {
                    j++;
                }
            }
            values = new Card[j];
            j = 0;
            for (int i = 0; i < this.size(); i++) {
                if (this.getCardAt(i).hasSameValue(value)) {
                    values[j] = this.getCardAt(i);
                    j++;
                }
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
        Card card = null;
        if (this.list != null) {
            for (int i = 0; i < this.size() && card == null; i++) {
                if (this.getCardAt(i).hasHigherValue(value)) {
                    card = this.getCardAt(i);
                }
            }
        }
        return card;
    }

    /**
     * Removes a card, if it is contained.
     *
     * @param card card to be removed
     */
    //TODO write a test where you create a pack with 3 elements, remove one that is not in there
    public void remove(Card card) {
        assert (card != null);
        assert (this.list != null);
        list = this.list.remove(card);
    }

    /**
     * Removes a card at the index if it is valid.
     *
     * @param idx index of the card to be removed
     */
    public void removeAt(int idx) {
        assert (this.list != null);
        this.list = this.list.remove(idx);
    }

    /**
     * Removes each one of the card that is contained.
     *
     * @param cards cards to be removed
     */
    public void remove(Card[] cards) {
        assert (cards != null) : "The array is null";
        for (int i = 0; i < cards.length; i++) {
            if (this.list.contains(cards[i])) {
                this.list = this.list.remove(cards[i]);
            }
        }
    }

    /**
     * Returns all contained cards in an array.
     *
     * @return all cards of the pack in an array
     */
    public Card[] toArray() {
        return this.list.toArray();

    }

    /**
     * return all contained cards in single line
     *
     * @return return list of cards
     */
    @Override
    public String toString() {
        return this.list.toString();
    }

    /**
     * add element on array to list
     *
     * @param cards is given array
     */
    private void addElementArray(Card[] cards) {
        for (int i = 0; i < cards.length; i++) {
            list = list.add(cards[i]);
        }

    }
}
