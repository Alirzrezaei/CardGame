package ueb07;

import java.util.Arrays;
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
    public void testDoTurn_TrueCAse() {
        Card[][] packs = new Card[][]{{Card.EIGHT_SPADES, Card.KING_HEARTS, Card.ACE_DIAMONDS},
        {Card.NINE_DIAMONDS, Card.QUEEN_CLUBS, Card.KING_DIAMONDS},
        {Card.TEN_DIAMONDS, Card.TEN_CLUBS, Card.ACE_CLUBS}};
        Game gameTest = new Game(packs, "rcr");
        gameTest.doTurn(gameTest.getPlayers()[0], gameTest.getCardsToTop());
        gameTest.nextPlayer(1, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        assertArrayEquals(new Card[]{Card.EIGHT_SPADES}, gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{Card.KING_HEARTS, Card.ACE_DIAMONDS}, gameTest.getPlayers()[0].getPack().toArray());
    }

    @Test
    public void testDoTurn_False() {
        Card[][] packs = new Card[][]{{Card.EIGHT_SPADES, Card.KING_HEARTS, Card.ACE_DIAMONDS},
        {Card.SEVEN_CLUBS, Card.SEVEN_DIAMONDS, Card.SEVEN_HEARTS},
        {Card.TEN_CLUBS, Card.TEN_DIAMONDS, Card.ACE_CLUBS}};
        Game gameTest = new Game(packs, "rcr");
        gameTest.doTurn(gameTest.getPlayers()[0], gameTest.getCardsToTop());
        gameTest.nextPlayer(2, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        assertArrayEquals(new Card[]{Card.EIGHT_SPADES}, gameTest.getCardsToTop());
        //assertEquals(1, gameTest.getCountCantLay());
        assertArrayEquals(new Card[]{Card.SEVEN_CLUBS, Card.SEVEN_DIAMONDS, Card.SEVEN_HEARTS}, gameTest.getPlayers()[1].getPack().toArray());
    }

    @Test(expected = AssertionError.class)
    public void testDoTurnPlayerHasNoLeftCards() {
        Card[][] packs = new Card[][]{{Card.EIGHT_SPADES, Card.KING_HEARTS, Card.ACE_DIAMONDS},
        {}, {Card.TEN_DIAMONDS, Card.TEN_CLUBS, Card.ACE_CLUBS}};
        Game gameTest = new Game(packs, "rcr");
        gameTest.doTurn(gameTest.getPlayers()[0], gameTest.getCardsToTop());
        gameTest.doTurn(gameTest.getPlayers()[1], gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{Card.EIGHT_SPADES}, gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{}, gameTest.getPlayers()[1].getPack().toArray());
    }

    @Test
    public void testNextPlayerNormalSituation() {
        Card[][] packs = new Card[][]{{Card.EIGHT_SPADES, Card.KING_HEARTS, Card.ACE_DIAMONDS},
        {Card.NINE_DIAMONDS, Card.QUEEN_CLUBS, Card.KING_DIAMONDS},
        {Card.TEN_DIAMONDS, Card.TEN_CLUBS, Card.ACE_CLUBS}};
        Game gameTest = new Game(packs, "rcr");
        gameTest.doTurn(gameTest.getPlayers()[0], gameTest.getCardsToTop());

        int nextPlayer = gameTest.nextPlayer(0, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        assertEquals(1, nextPlayer);
        gameTest.doTurn(gameTest.getPlayers()[1], gameTest.getCardsToTop());
        assertEquals(0, gameTest.getCountCantLay());
        //assertArrayEquals(new Card[]{Card.NINE_DIAMONDS}, gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{Card.QUEEN_CLUBS, Card.KING_DIAMONDS}, gameTest.getPlayers()[1].getPack().toArray());
    }
   
    @Test
    public void tesToString() {
        Card[][] packs = new Card[][]{{Card.ACE_CLUBS, Card.ACE_DIAMONDS, Card.ACE_SPADES},
        {Card.SEVEN_CLUBS, Card.SEVEN_DIAMONDS, Card.SEVEN_HEARTS},
        {Card.TEN_CLUBS, Card.TEN_DIAMONDS, Card.TEN_DIAMONDS}};
        Game gameTest = new Game(packs, "ccr");
        assertEquals("C0: ACE_CLUBS, ACE_DIAMONDS, ACE_SPADES", gameTest.getPlayers()[0].toString());
        assertEquals("C1: SEVEN_CLUBS, SEVEN_DIAMONDS, SEVEN_HEARTS", gameTest.getPlayers()[1].toString());
        assertEquals("R2: TEN_CLUBS, TEN_DIAMONDS, TEN_DIAMONDS", gameTest.getPlayers()[2].toString());
    }

}
