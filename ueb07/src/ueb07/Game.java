package ueb07;

import java.util.Arrays;
import java.util.Random;
import ueb07.cards.Card;

/**
 * The card game "Lump". For Lump you need three to six players. You use a skat
 * deck (32 cards, 7 to ace). Objective of the game is to be the first one to
 * have to no cards left. * First, the cards are distributed evenly among the
 * players. Possible left over cards are put aside and not considered during
 * this game. The first player plays single card (e.g. a jack). The next player
 * has to play at least as many cards with a higher value (e.g. if the first
 * card was a jack the next player can play a queen, a king or an ace, if there
 * were two jacks he could play the queen of hearts and the queen of spades).
 * The one after the other play has the chance to play one or more cards. * Can
 * a player not surpass he has to skip a round. If no one can play additional
 * cards, a new round starts. The player who played the last card starts the new
 * round. Anyone who plays an ace can automatically start a new round. * The
 * first person to get rid of all his/her card is the "king". The person to be
 * the last one remaining with cards is the "Lump".
 *
 * @author Gerit
 */
public class Game {

    private static final int MAX_COUNT = 6;
    private static final int MIN_COUNT = 3;

    private Player[] players;
    private Card[] cardsOnTop;
    private int currentPlayer;
    private int countCantLay;

//<editor-fold defaultstate="collapsed" desc="Getter">
    Player[] getPlayers() {
        return players;
    }

    Card[] getCardsToTop() {
        return cardsOnTop;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public int getCountCantLay() {//??
        return countCantLay;
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Konstruktoren">

    /**
     * Creates the given number of players, limits the number of player to
     * either MIN_COUNT or MAX_COUNT. Randomly creates risky/cautious players.
     * The name of players are "R" or "C" for risky/cautious player followed by
     * the index of position of the player in the array. *
     *
     * @param countOfPlayers number of players
     */
    public Game(int countOfPlayers) {
        if (countOfPlayers < MIN_COUNT) {
            countOfPlayers = MIN_COUNT;
        }
        if (countOfPlayers > MAX_COUNT) {
            countOfPlayers = MAX_COUNT;
        }
        players = new Player[countOfPlayers];
        Random r = new Random();
        int playerType;
        for (int i = 0; i < players.length; i++) {
            playerType = r.nextInt(2);
            if (playerType == 0) {
                players[i] = new CautiousGuy("C" + i);
            } else {
                players[i] = new RiskyGuy("R" + i);
            }
        }

    }

    /**
     * Creates the game assigns the appropriate cards to the players. It can be
     * assumed that only valid card decks are distributed. Different number of
     * cards and multiple cards are possible. The name of the players start are
     * "R" or "C" depending on what type of player the player is followed by the
     * index of the player in the array.
     *
     * @param packs contains for each player an array with cards
     * @param riskType marks how likely the players are to take risks. An "r" in
     * the string creates a "risky" player, any other letter (or no letter at
     * all) would create a cautious player. The string "rcrcrc" would
     * alternatively create risky and cautious players.
     */
    Game(Card[][] packs, String riskType) {
        players = new Player[packs.length];
        for (int i = 0; i < players.length; i++) {
            if (riskType.charAt(i) == 'r') {
                players[i] = new RiskyGuy("R" + i, packs[i]);
            } else {
                players[i] = new CautiousGuy("C" + i, packs[i]);
            }
        }

    }
//</editor-fold>

    /**
     * Distributes a deck of cards evenly among the players and returns the
     * player array.
     *
     * @return Array with players
     */
    Player[] dealCards() {
        Card[] card = new Card[32];
        Player dealer = new Dealer("Dealer", card);
        int numOfPlayer = players.length;
        for (int i = 0; i < numOfPlayer; i++) {
            for (int j = 0; j < (int) (32 / numOfPlayer); j++) {
                players[i].receive(dealer.choose(cardsOnTop));
            }

        }
        return players;
    }

    /**
     * Checks if the given player still has cards.
     *
     * @param player player to be checked
     * @return true, if the player has no more cards
     */
    boolean hasWon(Player player) {
        assert (player != null) : "Wrong player is passed";
        return player.getPack() == null;
    }

    /**
     * Enables a player to make a trun. The player plays his selected cards. If
     * he cannot play, he has to skip the round.
     *
     * @param player active player
     * @param cardsToTop cards that have to be surpassed
     * @return player without the just placed card
     * @pre the player still has cards
     */
    Player doTurn(Player player, Card[] cardsToTop) {
        assert player.getPackSize() > 0;
        //TODO insert code
        return player;
    }

    /**
     * Exectues all actions that are required for one move of a player:
     * determines the next player and how the he should react to the current
     * cards on top. If a player cannot surpass the current cards he has to
     * skip. If no other player can place a card, a new round is started. The
     * player who has placed the last card will start the new round. Whoever
     * plays an ace can directly start a new round.
     *
     * @param currentPlayer the current player
     * @param cardsToTop card(s) that have to surpassed by the current player
     * @param couldntLay number of player that had to skip so far
     * @return index of the player whose turn it is
     */
    int nextPlayer(int currentPlayer, Card[] cardsToTop, int couldntLay) {
        //TODO insert code
        return currentPlayer;
    }

    /**
     * The card game happens.       <code>
     * - Distribute cards evenly
     * - as long as no one has won
     * -   if possible, a player plays a card otherwise he skips the round
     * -   if the player has not won
     * -      play according to rules and go to next player</code>
     */
    public void playGame() {

        //TODO insert code
    }

    @Override
    public String toString() {
        //TODO insert code
        return null;
    }

}
