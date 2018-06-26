package ueb07;

import ueb07.cards.Card;
import ueb07.cards.Pack;

/**
 * A player with a name and pack of cards.
 *
 * @author klk
 */
public abstract class Player {

    /**
     * name of the player
     */
    private final String name;

    /**
     * cards of the player in the pack
     */
    private final Pack pack;

    /**
     * Creates a player with a given name.
     *
     * @param name name for the player
     */
    public Player(String name) {
        this(name, new Card[0]);
    }

    /**
     * Creates a player with a name and the given card pack.
     *
     * @param name name for the player
     * @param cards cards for the player
     */
    Player(String name, Card[] cards) {
        pack = new Pack(cards);
        this.name = name;
    }

    /**
     * Returns the name of the player
     *
     * @return name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the reference of the pack to inheriting classes.
     *
     * @return the pack
     */
    protected Pack getPack() {
        return this.pack;
    }

    /**
     * Returns the number of cards of the player.
     *
     * @return number of cards
     */
    public int getPackSize() {
        return pack.size();
    }

    /**
     * Receives the given card.
     *
     * @param card received card
     */
    public void receive(Card card) {
        pack.add(card);
    }

    /**
     * Receives the given cards
     *
     * @param cards cards to be received
     */
    public void receive(Card[] cards) {
        for (Card card : cards) {
            receive(card);
        }
    }

    /**
     * Returns all the cards a player want to play. These cards are removed from
     * his/her pack. If a player cannot play any card, an empty array is
     * returned. If he does not have any cards left null is returned.
     *
     * @param cardsToTop card(s) that has to be surpassed
     * @return all cards that the player wants to play, an empty array if he
     * cannto play any card, null if he does not have any cards left      *
     */
    public abstract Card[] choose(Card[] cardsToTop);

    /**
     * Name and cards of the player in a single line. 
     *
     * @return Name and cards of the player in a single line
     */
    @Override
    public String toString() {
        return name + ": " + pack.toString();
    }

}
