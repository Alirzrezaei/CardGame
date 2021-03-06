package ueb07;

import java.util.Arrays;
import java.util.Random;
import ueb07.cards.Card;
import ueb07.cards.Pack;

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

    /**
     * Gets the cards on top in an array
     *
     * @return cars on top
     */
    Card[] getCardsToTop() {
        return cardsOnTop;
    }

    /**
     * getting the current player
     *
     * @return current player
     */
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * return number of player that skipped
     *
     * @return number of skipped players
     */
    public int getCountCantLay() {
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
                players[i] = new CautiousGuy("" + i); //TODO DONE add prefix in the respective classes
            } else {
                players[i] = new RiskyGuy("" + i); //TODO DONE add prefix in the respective classes
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
        assert (packs != null) : "We don't have any packs";
        players = new Player[packs.length];
        for (int i = 0; i < players.length; i++) {
            if (riskType != null && riskType.charAt(i) == 'r') {
                players[i] = new RiskyGuy("" + i, packs[i]);
            } else {
                players[i] = new CautiousGuy("" + i, packs[i]);
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
        int numberOfCards = (int) card.length / players.length;
        int k = 0;
        for (Card iCard : Card.values()) {
            card[k++] = iCard;
        }
        Player dealer = new Dealer("Dealer", card);
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < numberOfCards; j++) {
                players[i].receive(dealer.choose(cardsOnTop));
            }
        }
        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i].toString());
        }
        System.out.print("\n\n\n");

        return players;
    }

    /**
     * Checks if the given player still has cards.
     *
     * @param player player to be checked
     * @return true, if the player has no more cards
     */
    boolean hasWon(Player player) {
        //assert (player != null) : "Wrong player is passed";
        return player == null || player.getPackSize() == 0;
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

        assert player != null;
        assert player.getPackSize() > 0;
        Card[] tempToTop = null;
        tempToTop = player.choose(cardsToTop);
        if (tempToTop != null && tempToTop.length > 0) {
            cardsOnTop = tempToTop;

            countCantLay = 0;
        } else {
            countCantLay++;
        }
        return player;
    }

    /**
     * Executes all actions that are required for one move of a player:
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
    //TODO DONE cardsOnTop should be empty when a new round starts (e.g. an ace was the card to top or none of the players can put down another card)
    int nextPlayer(int currentPlayer, Card[] cardsToTop, int couldntLay) {
        if (cardsToTop != null && cardsToTop[0].isAce()) {
            cardsOnTop = null;
            countCantLay = 0;
            return currentPlayer;
        }
        if(hasWon(players[currentPlayer])){
            return currentPlayer;
        }
        //TODO DONE not needed, only ever written to, never read
        if (countCantLay == players.length) {
            cardsOnTop = null;
            countCantLay = 0;
            return currentPlayer;
        }
        currentPlayer++;
        if (currentPlayer == players.length) {
            currentPlayer = 0;
        }

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
        currentPlayer = 0;
        dealCards();
        while (!hasWon(players[currentPlayer])){
            doTurn(players[currentPlayer], cardsOnTop);
            System.out.println("OnTop: " + Arrays.toString(cardsOnTop) + "\t\t" + players[currentPlayer].toString());
            if (currentPlayer == 2) {
                System.out.print("\n\n");
            }
            currentPlayer = nextPlayer(currentPlayer, cardsOnTop, countCantLay);

        } 
        System.out.println(players[currentPlayer].getName() + " WON!");
    }

    @Override
    public String toString() {

        return "";
    }

}
