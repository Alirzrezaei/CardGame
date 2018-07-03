package ueb07.cards;

/**
 * Interface of an object oriented list. Must be implemented by an EmptyElement
 * without any attributes and a ListElement with a card as payload and a
 * reference to the next element.
 *
 * @author klk
 */
public interface List {

    /**
     * Returns the payload of the element. A call to assert ensures that this
     * method is not called for the empty element.
     *
     * @return the payload of the element, null if the element is empty
     */
    Card getCard();

    /**
     * Returns the next element. A call to assert ensures that this method is
     * not called for the empty element.
     *
     * @return the next element, null if the element is empty
     */
    List getNext();

    /**
     * Determines if the list is empty
     *
     * @return true, if the list is empty
     */
    boolean isEmpty();

    /**
     * Determines the length of the list.
     *
     * @return the length of the list
     */
    int size();

    /**
     * Checks if the card exists in the list.
     *
     * @param card card to be searched
     * @return true, if the card is in the list
     */
    boolean contains(Card card);

    /**
     * Adds an element with the card in ordinal order. In the case of equality a
     * new element with the new card is inserted in front of the current
     * element.
     *
     * @param card cards to be added
     * @return new head of the list
     */
    List add(Card card);

    /**
     * Returns the card at the index, null if the index is not valid.
     *
     * @param idx index of the card to be returned
     * @return the card at the index, null, if the index is not valid
     */
    Card getCardAt(int idx);

    /**
     * Returns the first card in the list with the given value.
     *
     * @param value value of the desired card
     * @return the first card, that has the given value, null, if no cards of
     * this list have this value
     */
    Card getFirstCardWithValue(int value);

    /**
     * Removes the given card from the list, if it is in the list.
     *
     * @param card card to be removed
     * @return head of the list
     */
    List remove(Card card);

    /**
     * Removes the element at the given index. If the index is not valid,
     * nothing happens.
     *
     * @param idx index of the element that should be removed
     * @return new head of the list
     */
    List remove(int idx);

    /**
     * Returns the cards contained in the list in an array.
     *
     * @return the cards contained in the array
     */
    Card[] toArray();

    /**
     * Returns all elements of the list, seperatedy by a comma, without a comma
     * at the end.
     *
     * @return all elements of the list, seperatedy by a comma, without a comma
     * at the end
     */
    @Override
    String toString();
}
