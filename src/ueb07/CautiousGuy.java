/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ueb07;

import ueb07.cards.Card;

/**
 *
 * @author ite102770
 */
public class CautiousGuy extends Player {

    public CautiousGuy(String name) {
        super(name);
    }

    public CautiousGuy(String name, Card[] cards) {
        super(name, cards);
    }

    @Override
    public Card[] choose(Card[] cardsToTop) {

        Card[] card = null;

        int counter = 0;
        int cardValue;
        if (cardsToTop != null && super.getPack().size() > 0 ) {
            Card[] temp = new Card[cardsToTop.length];
            for (int i = 0; i < cardsToTop.length; i++) {
                cardValue = cardsToTop[i].getValue();
                for (int j = 0; j < super.getPackSize(); j++) {
                    if (super.getPack().getCardWithValueHigherThan(cardValue) != null
                            && super.getPack().getCardWithValueHigherThan(cardValue).getValue()
                            == super.getPack().getCardAt(j).getValue()) {
                        temp[counter] = super.getPack().getCardAt(j);
                        super.getPack().removeAt(j);
                        counter++;
                    }
                }
            }
            card = new Card[counter];
            for (int i = 0; i < counter; i++) {
                card[i] = temp[i];
            }
            return card;
        } else if (super.getPack().size() > 0) {
            card = new Card[1];
            card[0] = super.getPack().getCardAt(0);
            super.getPack().removeAt(0);
            return card;
        }
        return null;

    }

}
