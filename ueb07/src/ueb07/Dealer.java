package ueb07;

import ueb07.cards.Card;
import java.util.*;

/**
 * This class he only available constructor assigns a complete card deck to a
 * player. In the method choose() the incoming parameter is ignored and an array
 * with one randomnly selected card from the pack is returned
 *
 * @author ite102770
 */
public class Dealer extends Player {

    private int total = 32;

    /**
     * default construcrtor
     *
     * @param name name of the dealer
     */
    public Dealer(String name) {
        super(name);
    }

    /**
     * assigning the name and number of cards in the game
     *
     * @param name name of the dealer
     * @param cards an array of the cards
     */
    public Dealer(String name, Card[] cards) {
        super(name, cards);
    }

    /**
     * From random function select the card and gives to the player
     *
     * @param cardsToTop card(s) that has to be surpassed
     * @return all cards that the player wants to play, an empty array if he
     * cannot play any card, null if he does not have any cards left *
     */
    @Override
    public Card[] choose(Card[] cardsToTop) {

        Card[] card = new Card[1];
        Random r = new Random();
        int selectCard;
        selectCard = r.nextInt(total);
        card[0] = super.getPack().getCardAt(selectCard);
        super.getPack().removeAt(selectCard);
        total--;
        return card;
    }

    /**
     * return all contained cards in single line
     *
     * @return return list of cards
     */
    @Override
    public String toString() {
        return "";
    }

}
