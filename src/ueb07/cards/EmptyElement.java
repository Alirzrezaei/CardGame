package ueb07.cards;

/**
 * This class implements the interface list with no attrinutes.
 *
 * @author Reyhan
 */
public class EmptyElement implements List {

    //TODO DONE implement according to JavaDoc
    /**
     * Returns the payload of the element. A call to assert ensures that this
     * method is not called for the empty element.
     *
     * @return the payload of the element, null if the element is empty
     */
    @Override
    public Card getCard() {
        assert(this != null);
        return null;
    }

    //TODO DONE implement according to JavaDoc
    /**
     * Returns the next element. A call to assert ensures that this method is
     * not called for the empty element.
     *
     * @return the next element, null if the element is empty
     */
    @Override
    public List getNext() {
        assert(this != null);
        return null;
    }

    /**
     * Dtermines if the list is empty
     *
     * @return true, if the list is empty
     */
    @Override
    public boolean isEmpty() {
        return true; 
    }

    /**
     * Determines the length of the list.
     *
     * @return the length of the list
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Checks if the card exists in the list.
     *
     * @param card card to be searched
     * @return true, if the card is in the list
     */
    @Override
    public boolean contains(Card card) {
        return false;
    }

    /**
     * Adds an element with the card in ordinal order. In the case of equality a
     * new element with the new card is inserted in front of the current
     * element.
     *
     * @param card cards to be added
     * @return new head of the list
     */
    @Override
    public List add(Card card) {
        return new ListElement(card);//???
    }

    /**
     * Returns the card at the index, null if the index is not valid.
     *
     * @param idx index of the card to be returned
     * @return the card at the index, null, if the index is not valid
     */
    @Override
    public Card getCardAt(int idx) {//????
        return null;
    }

    /**
     * Returns the first card in the list with the given value.
     *
     * @param value value of the desired card
     * @return the first card, that has the given value, null, if no cards of
     * this list have this value
     */
    @Override
    public Card getFirstCardWithValue(int value) {
        return null;
    }

    /**
     * Removes the given card from the list, if it is in the list.
     *
     * @param card card to be removed
     * @return head of the list
     */
    @Override
    public List remove(Card card) {
        return this;
    }

    /**
     * Removes the element at the given index. If the index is not valid,
     * nothing happens.
     *
     * @param idx index of the element that should be removed
     * @return new head of the list
     */
    @Override
    public List remove(int idx) {
        return this;
    }

    /**
     * Returns the cards contained in the list in an array.
     *
     * @return the cards contained in the array
     */
    @Override
    public Card[] toArray() {
        return new Card[]{};
    }

    /**
     * Returns all elements of the list, seperatedy by a comma, without a comma
     * at the end.
     *
     * @return all elements of the list, seperatedy by a comma, without a comma
     * at the end
     */
    //TODO String for empty list hsould be empty
    @Override
    public String toString() {
        return "";
    }
}
