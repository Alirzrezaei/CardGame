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
        int noCards;
        int hasEnough;
        Card playerCard;
        
        if (cardsToTop != null && super.getPack().size() > 0) {
            Card[] temp = new Card[cardsToTop.length];
            for (int i = 0; i < cardsToTop.length; i = i + noCards) {//index next card
                cardValue = cardsToTop[i].getValue();
                noCards = numberOfSameCards(cardsToTop, cardsToTop[i]);
                playerCard = super.getPack().getCardWithValueHigherThan(cardValue);
                hasEnough = hasEnoughCard(playerCard);
                if (hasEnough >= noCards) {
                    for (int j = 0; j < super.getPackSize() && counter < noCards; j++) {
                        if (playerCard != null && playerCard.getValue()
                                == super.getPack().getCardAt(j).getValue()) {
                            temp[counter] = super.getPack().getCardAt(j);      
                            counter++;
                        }
                    }
                } 
                    card = new Card[counter];
                    for (int k = 0; k < counter; k++) {
                        card[k] = temp[k];
                        super.getPack().remove(card[k]);
                    }
                
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

    private int numberOfSameCards(Card[] cardOnTop, Card card) {
        int noCards = 1;
        for (int i = 1; i < cardOnTop.length; i++) {
            if (cardOnTop[i].hasSameValue(card)) {
                noCards++;
            }
        }
        return noCards;
    }

    private int hasEnoughCard(Card card) {
        int hasCard = 0;
        for (int i = 0; card != null && i < super.getPack().size(); i++) {
            if (super.getPack().getCardAt(i).hasSameValue(card)) {
                hasCard++;
            }
        }
        return hasCard;
    }
}
