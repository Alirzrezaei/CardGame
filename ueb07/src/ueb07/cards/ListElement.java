package ueb07.cards;

/**
 *
 * This class implements the interface list with attribute type card and the
 * next with the type List.
 *
 * @author ite102770
 */
public class ListElement implements List {

    private Card value;
    private List next;

    /**
     * default constructor
     */
    ListElement() {

    }

    /**
     * Construct the listElement with the given value in the list
     *
     * @param value
     */
    ListElement(Card value) {
        this.value = value;   
        this.next = null;
    }

    /**
     * Construct the listElement with the given value in the list
     *
     * @param value
     */
    ListElement(Card value, List next) {
        this.value = value;
        this.next = next;
    }

    /**
     * setting the given card
     *
     * @param value
     */
    private void setValue(Card value) {
        this.value = value;
    }

    /**
     * setting the next of the given list
     *
     * @param next
     */
    private void setNext(List next) {
        this.next = next;
    }

    /**
     * Returns the payload of the element. A call to assert ensures that this
     * method is not called for the empty element.
     *
     * @return the payload of the element, null if the element is empty
     */
    @Override
    public Card getCard() {
        assert (this != null);
        return this.value;
    }

    /**
     * Returns the next element. A call to assert ensures that this method is
     * not called for the empty element.
     *
     * @return the next element, null if the element is empty
     */
    @Override
    public List getNext() {
        assert (this != null);
        //assert(this.next != null);
        return this.next;
    }

    /**
     * Determines if the list is empty
     *
     * @return true, if the list is empty
     */
    @Override
    public boolean isEmpty() {
        assert (this != null);
        return false;
    }

    /**
     * Determines the length of the list.
     *
     * @return the length of the list
     */
    @Override
    public int size() {
        assert (this.value != null) : "There is not element in our list";  
        if (this.next == null) {
            return 1;
        } else {
            return 1 + this.next.size();
        }
    }

    /**
     * Checks if the card exists in the list.
     *
     * @param card card to be searched
     * @return true, if the card is in the list //if the type of the specified
     * element is incompatible with this list (optional)
     */
    @Override
    public boolean contains(Card card) {
        assert (card != null) : "The card has no value";
        if (this.getCard() == card) {
            return true;
        } else if (this.next != null) {
            return this.next.contains(card);
        } else {
            return false;
        }
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
        assert (card != null);
        assert (this != null);
        if (card.ordinal() <= this.value.ordinal()) {
            ListElement newElement = new ListElement(card);
            newElement.setNext(this);
            return newElement;
        } else if (this.next == null) {//card is greater than this
            ListElement newElement = new ListElement();
            newElement.setValue(card);
            this.next = newElement;
            return this;
        } else {
            this.next = this.next.add(card);
            return this;
        }
    }

    /**
     * Returns the card at the index, null if the index is not valid.
     *
     * @param idx index of the card to be returned
     * @return the card at the index, null, if the index is not valid
     * //IndexOutOfBoundsException - if the index is out of range (index < 0 || index
     * >= size())
     */
    @Override
    public Card getCardAt(int idx) {
        if (idx == 0) {
            return this.value;
        } else if (idx > 0 && idx < this.size() && this.next != null) {
            return this.next.getCardAt(idx - 1);
        } else {
            return null;
        }
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
        if (value >= 7 && value <= 14) {
            if (this.value.getValue() == value) {
                return this.value;
            } else if (this.next != null) {
                return this.next.getFirstCardWithValue(value);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Removes the given card from the list, if it is in the list.
     *
     * @param card card to be removed
     * @return head of the list
     */
    @Override
    public List remove(Card card) {//????
        assert (card != null); // need?
        if (this.value == card) {
            return this.next;
        } else {
            this.next = this.next.remove(card);
            return this;
        }
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
        return remove(this.getCardAt(idx));
    }

    /**
     * Returns the cards contained in the list in an array.
     *
     * @return the cards contained in the array
     */
    @Override
    public Card[] toArray() {
        Card[] values = new Card[this.size()];
        if (!isEmpty()) {
            for (int i = 0; i < values.length; i++) {
                values[i] = this.getCardAt(i);
            }
        }
        return values;
    }

    /**
     * Returns all elements of the list, seperatedy by a comma, without a comma
     * at the end.
     *
     * @return all elements of the list, seperatedy by a comma, without a comma
     * at the end
     */
    @Override
    public String toString() {//print with coma at the end 
        if(this.next == null){
            return ""+ this.getCard();
        }
        else
        return this.getCard() + ", " + this.next.toString();
    

    }

}
