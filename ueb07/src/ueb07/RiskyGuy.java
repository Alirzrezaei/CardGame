package ueb07;

import ueb07.cards.Card;

/**
 * This class is similar to the cautiousGuy. if there are multiple cards
 * available of the card you can be played, all of these will be selected
 *
 * @author ite102770
 */
public class RiskyGuy extends Player {
    final String prefix = "R";
    /**
     * assign the given name to the name in the parent.
     *
     * @param name
     */
    public RiskyGuy(String name) {
        super(name);
    }

    /**
     * assigns the name and the cards from the parent class.
     *
     * @param name
     * @param cards
     */
    public RiskyGuy(String name, Card[] cards) {
        super(name, cards);
    }

    @Override
    public Card[] choose(Card[] cardsToTop) {
        Card[] card = null;
        int counter = 0;
        int cardValue;
        int hasEnough = 32;
        Card playerCard;

        if (cardsToTop != null && super.getPackSize() > 0) {
            Card[] temp = new Card[super.getPackSize()];

            cardValue = cardsToTop[0].getValue();
            int j = 0;
            card = new Card[cardsToTop.length];
            while (j < super.getPackSize() && counter < hasEnough) {
                playerCard = super.getPack().getCardAt(j);
                if (getPack().getCardAt(j).hasHigherValue(cardValue)) {
                    hasEnough = hasEnoughCard(playerCard);
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
        } else if (super.getPack().size() > 0) {
            playerCard = super.getPack().getCardAt(0);
            hasEnough = hasEnoughCard(playerCard);
            card = new Card[hasEnough];
            for (int i = 0; i < hasEnough; i++) {
                card[i] = super.getPack().getCardAt(0);
                super.getPack().removeAt(0);
            }
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
    private int hasEnoughCard(Card card) {
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
        return "" + this.prefix;
    }
}
