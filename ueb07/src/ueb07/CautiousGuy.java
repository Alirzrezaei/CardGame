package ueb07;

import ueb07.cards.Card;

/**
 * This class always chooses the minimum number of cards required
 *
 * @author ite102770
 */
public class CautiousGuy extends Player {

    /**
     * default constructor
     *
     * @param name name of the player
     */
    public CautiousGuy(String name) {
        super(name);
    }

    /**
     * recieves the name and the cards of the player
     *
     * @param name name of the player
     * @param cards on the pack of the player
     */
    public CautiousGuy(String name, Card[] cards) {
        super(name, cards);
    }

    /**
     * Returns all the cards a player want to play. These cards are removed from
     * his/her pack. If a player cannot play any card, an empty array is
     * returned. If he does not have any cards left null is returned.
     *
     * @param cardsToTop card(s) that has to be surpassed
     * @return all cards that the player wants to play, an empty array if he
     * cannto play any card, null if he does not have any cards left *
     */
    @Override
    public Card[] choose(Card[] cardsToTop) {

        Card[] card = null;
        int counter = 0;
        int cardValue;
        int hasEnough;
        Card playerCard;
        if (cardsToTop != null && super.getPackSize() > 0) {
            Card[] temp = new Card[cardsToTop.length];
            cardValue = cardsToTop[0].getValue();
            int j = 0;
            card = new Card[cardsToTop.length];
            while (j < super.getPackSize() && counter < cardsToTop.length) {
                playerCard = super.getPack().getCardAt(j);
                if (super.getPack().getCardAt(j).hasHigherValue(cardValue)) {
                    hasEnough = hasEnoughCard(playerCard, cardValue);//number of same value in the pack
                    if (hasEnough >= cardsToTop.length && playerCard != null && playerCard.getValue()
                            == super.getPack().getCardAt(j).getValue()) {
                        temp[counter] = super.getPack().getCardAt(j);
                        counter++;
                        j++;
                    } else {
                        j = j + hasEnough;
                    }
                } else {
                    j++;
                }
            }
            card = new Card[counter];
            for (int k = 0; k < counter; k++) {
                card[k] = temp[k];
                super.getPack().remove(card[k]);
            }
            return card;
        } else if (super.getPackSize() > 0) {
            card = new Card[1];
            card[0] = super.getPack().getCardAt(0);
            super.getPack().removeAt(0);
            return card;
        }
        return null;

    }

    /**
     * returns the number of same value with the given card in the pack
     *
     * @param card is the given card
     * @return number of same value in pack
     */
    private int hasEnoughCard(Card card, int value) {
        int hasCard = 0;
        for (int i = 0; card != null && i < super.getPack().size(); i++) {
            if (super.getPack().getCardAt(i).hasSameValue(card)) {
                hasCard++;
            }
        }
        return hasCard;
    }

    @Override
    public String toString() {
        return "" + this.getName() + ": " + this.getPack().toString();
    }
}
