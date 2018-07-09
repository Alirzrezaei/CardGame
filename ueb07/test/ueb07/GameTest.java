package ueb07;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import ueb07.Game.*;
import ueb07.cards.Card;

/**
 *
 * @author ite102770
 */
public class GameTest {

    public GameTest() {
    }

    @Test
    public void tesToString() {
        Card[][] packs = new Card[][]{{Card.ACE_CLUBS, Card.ACE_DIAMONDS, Card.ACE_SPADES},
        {Card.SEVEN_CLUBS, Card.SEVEN_DIAMONDS, Card.SEVEN_HEARTS},
        {Card.TEN_CLUBS, Card.TEN_DIAMONDS, Card.TEN_DIAMONDS}};
        Game gameTest = new Game(packs, "ccr");
        assertEquals("{C0: ACE_CLUBS, ACE_DIAMONDS, ACE_SPADES}", gameTest.getPlayers()[0].toString());
        assertEquals("{C1: SEVEN_CLUBS, SEVEN_DIAMONDS, SEVEN_HEARTS}", gameTest.getPlayers()[1].toString());
        assertEquals("{R2: TEN_CLUBS, TEN_DIAMONDS, TEN_DIAMONDS}", gameTest.getPlayers()[2].toString());
    }

    @Test
    public void testDealCards() {

        Game gameTest = new Game(3);
        gameTest.dealCards();
        System.out.println(gameTest.getPlayers()[0].toString());
        System.out.println(gameTest.getPlayers()[1].toString());
        System.out.println(gameTest.getPlayers()[2].toString());
    }

    @Test
    public void testNextPlayer_UnchangedPlayer() {
        Card[][] packs = new Card[][]{{Card.JACK_CLUBS, Card.JACK_DIAMONDS, Card.JACK_SPADES, Card.KING_DIAMONDS, Card.ACE_CLUBS, Card.ACE_DIAMONDS, Card.ACE_SPADES},
        {Card.SEVEN_CLUBS, Card.SEVEN_DIAMONDS, Card.SEVEN_HEARTS, Card.TEN_CLUBS},
        {Card.TEN_CLUBS, Card.TEN_DIAMONDS, Card.TEN_DIAMONDS}};
        Game gameTest = new Game(packs, "rcr");
        gameTest.doTurn(gameTest.getPlayers()[0], null);
        assertArrayEquals(new Card[]{Card.JACK_CLUBS, Card.JACK_DIAMONDS, Card.JACK_SPADES}, gameTest.getCardsToTop());
        int nextPlayer = gameTest.nextPlayer(0, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        assertEquals(1, nextPlayer);
        gameTest.doTurn(gameTest.getPlayers()[nextPlayer], gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{Card.JACK_CLUBS, Card.JACK_DIAMONDS, Card.JACK_SPADES}, gameTest.getCardsToTop());
        nextPlayer = gameTest.nextPlayer(nextPlayer, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        assertEquals(2, nextPlayer);
        gameTest.doTurn(gameTest.getPlayers()[nextPlayer], gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{Card.JACK_CLUBS, Card.JACK_DIAMONDS, Card.JACK_SPADES}, gameTest.getCardsToTop());
        nextPlayer = gameTest.nextPlayer(nextPlayer, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        assertEquals(0, nextPlayer);
        gameTest.doTurn(gameTest.getPlayers()[nextPlayer], gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{Card.ACE_CLUBS, Card.ACE_DIAMONDS, Card.ACE_SPADES}, gameTest.getCardsToTop());
    }

    @Test
    public void testNextPlayer_UnchangedPlayer_CurrentPlayerStartNextRound() {
        Card[][] packs = new Card[][]{{Card.JACK_CLUBS, Card.JACK_DIAMONDS, Card.JACK_SPADES, Card.KING_DIAMONDS, Card.ACE_CLUBS},
        {Card.SEVEN_CLUBS, Card.SEVEN_DIAMONDS, Card.SEVEN_HEARTS, Card.TEN_CLUBS},
        {Card.TEN_CLUBS, Card.TEN_DIAMONDS, Card.TEN_DIAMONDS}};
        Game gameTest = new Game(packs, "rcr");
        gameTest.doTurn(gameTest.getPlayers()[0], null);
        assertArrayEquals(new Card[]{Card.JACK_CLUBS, Card.JACK_DIAMONDS, Card.JACK_SPADES}, gameTest.getCardsToTop());
        int nextPlayer = gameTest.nextPlayer(0, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        assertEquals(1, nextPlayer);
        gameTest.doTurn(gameTest.getPlayers()[nextPlayer], gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{Card.JACK_CLUBS, Card.JACK_DIAMONDS, Card.JACK_SPADES}, gameTest.getCardsToTop());
        nextPlayer = gameTest.nextPlayer(nextPlayer, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        assertEquals(2, nextPlayer);
        gameTest.doTurn(gameTest.getPlayers()[nextPlayer], gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{Card.JACK_CLUBS, Card.JACK_DIAMONDS, Card.JACK_SPADES}, gameTest.getCardsToTop());
        nextPlayer = gameTest.nextPlayer(nextPlayer, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        assertEquals(0, nextPlayer);
        gameTest.doTurn(gameTest.getPlayers()[nextPlayer], gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{Card.JACK_CLUBS, Card.JACK_DIAMONDS, Card.JACK_SPADES}, gameTest.getCardsToTop());
        nextPlayer = gameTest.nextPlayer(nextPlayer, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        assertEquals(0, nextPlayer);
        assertNull(gameTest.getCardsToTop());
        gameTest.doTurn(gameTest.getPlayers()[nextPlayer], gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{Card.KING_DIAMONDS}, gameTest.getCardsToTop());
    }

    @Test
    public void testNextPlayer_callingAfterCreation() {
        Card[][] packs = new Card[][]{{Card.JACK_CLUBS, Card.JACK_DIAMONDS, Card.JACK_SPADES, Card.KING_DIAMONDS, Card.ACE_CLUBS},
        {Card.SEVEN_CLUBS, Card.SEVEN_DIAMONDS, Card.SEVEN_HEARTS, Card.TEN_CLUBS},
        {Card.TEN_CLUBS, Card.TEN_DIAMONDS, Card.TEN_DIAMONDS}};
        Game gameTest = new Game(packs, "rcr");
        int nextPlayer = gameTest.nextPlayer(0, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        assertNull(gameTest.getCardsToTop());
        assertEquals(1, nextPlayer);
    }

    @Test
    public void testNextPlayer_normalCase() {
        Card[][] packs = new Card[][]{{Card.JACK_CLUBS, Card.JACK_DIAMONDS, Card.KING_DIAMONDS, Card.ACE_CLUBS},
        {Card.SEVEN_CLUBS, Card.SEVEN_DIAMONDS, Card.QUEEN_CLUBS, Card.QUEEN_HEARTS},
        {Card.TEN_CLUBS, Card.KING_DIAMONDS, Card.KING_SPADES}};
        Game gameTest = new Game(packs, "rcr");
        gameTest.doTurn(gameTest.getPlayers()[0], null);
        int nextPlayer = gameTest.nextPlayer(0, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        assertEquals(1, nextPlayer);
        gameTest.doTurn(gameTest.getPlayers()[nextPlayer], gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{Card.QUEEN_CLUBS, Card.QUEEN_HEARTS}, gameTest.getCardsToTop());
        nextPlayer = gameTest.nextPlayer(nextPlayer, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        gameTest.doTurn(gameTest.getPlayers()[nextPlayer], gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{Card.KING_DIAMONDS, Card.KING_SPADES}, gameTest.getCardsToTop());
    }

    @Test
    public void testNextPlayer_playedAce() {
        Card[][] packs = new Card[][]{{Card.QUEEN_HEARTS, Card.KING_DIAMONDS},
        {Card.SEVEN_CLUBS, Card.SEVEN_DIAMONDS, Card.QUEEN_CLUBS, Card.ACE_DIAMONDS},
        {Card.TEN_CLUBS, Card.KING_DIAMONDS, Card.KING_SPADES}};
        Game gameTest = new Game(packs, "rcr");
        gameTest.doTurn(gameTest.getPlayers()[0], null);
        assertArrayEquals(new Card[]{Card.QUEEN_HEARTS}, gameTest.getCardsToTop());
        int nextPlayer = gameTest.nextPlayer(0, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        assertEquals(1, nextPlayer);
        gameTest.doTurn(gameTest.getPlayers()[nextPlayer], gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{Card.ACE_DIAMONDS}, gameTest.getCardsToTop());
        nextPlayer = gameTest.nextPlayer(nextPlayer, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        gameTest.doTurn(gameTest.getPlayers()[nextPlayer], gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{Card.SEVEN_CLUBS}, gameTest.getCardsToTop());
        nextPlayer = gameTest.nextPlayer(nextPlayer, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        gameTest.doTurn(gameTest.getPlayers()[nextPlayer], gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{Card.TEN_CLUBS}, gameTest.getCardsToTop());
    }

    @Test
    public void testNextPlayer_CardOnTopNotNull() {
        Card[][] packs = new Card[][]{{Card.JACK_CLUBS, Card.KING_DIAMONDS, Card.ACE_CLUBS},
        {Card.SEVEN_CLUBS, Card.SEVEN_DIAMONDS, Card.QUEEN_HEARTS},
        {Card.EIGHT_HEARTS, Card.TEN_HEARTS},
        {Card.TEN_CLUBS, Card.KING_DIAMONDS, Card.KING_SPADES}};
        Game gameTest = new Game(packs, "rcrc");
        int nextPlayer = gameTest.nextPlayer(2, new Card[]{Card.SEVEN_CLUBS, Card.SEVEN_SPADES}, 2);
        assertEquals(3, nextPlayer);
    }
    
}
