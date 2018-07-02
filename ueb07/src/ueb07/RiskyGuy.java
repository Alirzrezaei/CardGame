package ueb07;

import ueb07.cards.Card;

/**
 *
 * @author ite102770
 */
public class RiskyGuy extends Player {

    public RiskyGuy(String name) {
        super(name);
    }

    public RiskyGuy(String name, Card[] cards) {
        super(name, cards);
    }

    @Override
    public Card[] choose(Card[] cardsToTop) {
        Card[] card = null;
        int counter = 0;
        int cardValue;
        Card playerCard;
        if (cardsToTop != null && super.getPack().size() > 0) {
            Card[] temp = new Card[cardsToTop.length];
            if (cardsToTop.length == 1) {
                card = new Card[1];
                cardValue = cardsToTop[0].getValue();
                playerCard = super.getPack().getCardWithValueHigherThan(cardValue);
                for (int j = 0; j < super.getPackSize(); j++) {
                    if (playerCard != null && playerCard.getValue() == super.getPack().getCardAt(j).getValue()) {
                        card[0] = super.getPack().getCardAt(j);
                        super.getPack().removeAt(j);
                    }
                }
                return card;
            } else {
                 int noCards = 1;
                for(int i = 0; i < cardsToTop.length; i =i+noCards){
                    noCards = numberOfSameCards(cardsToTop);
                    cardValue = cardsToTop[i].getValue();
                    playerCard = super.getPack().getCardWithValueHigherThan(cardValue);
                    
                    for (int j = 0; j < super.getPackSize(); j++) {
                        if (playerCard != null && playerCard.getValue() == super.getPack().getCardAt(j).getValue()) {
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
            }
        } else if (super.getPack().size() > 0) {
            card = new Card[1];
            card[0] = super.getPack().getCardAt(0);
            super.getPack().removeAt(0);
            return card;
        }
        return null;

    }
    private int numberOfSameCards(Card[] cardOnTop){
        int noCards = 1; 
        for(int i = 0; i < cardOnTop.length && cardOnTop[i].hasSameValue(cardOnTop[i+1]); i++){
            noCards = noCards + 1;
        }
        return noCards;
    }
    private int hasEnoughCard(Card card, int noCardOnTop){
        int hasCard = 0;
        for(int i = 0; card != null && i < super.getPack().size(); i++){
            if(super.getPack().getCardAt(i).hasSameValue(card)){
                hasCard++;
            }
        }
        return hasCard;
    }
}
