
package ueb07;

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
    public void testDoTurnSucceded() {
        Card[][] packs = new Card[][] {{Card.EIGHT_SPADES, Card.KING_HEARTS, Card.ACE_DIAMONDS},
            {Card.NINE_DIAMONDS,Card.QUEEN_CLUBS,Card.KING_DIAMONDS},
            {Card.TEN_DIAMONDS,Card.TEN_CLUBS,Card.ACE_CLUBS}}; 
        Game gameTest =  new Game(packs, "rcr");
        gameTest.doTurn(gameTest.getPlayers()[0], gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{Card.EIGHT_SPADES}, gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{Card.KING_HEARTS, Card.ACE_DIAMONDS}, gameTest.getPlayers()[0].getPack().toArray());
    }
    
    @Test
    public void testDoTurnFailed() {
        Card[][] packs = new Card[][] {{Card.EIGHT_SPADES, Card.KING_HEARTS, Card.ACE_DIAMONDS},
            {Card.SEVEN_CLUBS,Card.SEVEN_DIAMONDS,Card.SEVEN_HEARTS},
            {Card.TEN_DIAMONDS,Card.TEN_CLUBS,Card.ACE_CLUBS}}; 
        Game gameTest =  new Game(packs, "rcr");
        gameTest.doTurn(gameTest.getPlayers()[0], gameTest.getCardsToTop());
        gameTest.doTurn(gameTest.getPlayers()[1], gameTest.getCardsToTop());
        assertEquals(1, gameTest.getCountCantLay());
        assertArrayEquals(new Card[]{Card.EIGHT_SPADES}, gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{Card.SEVEN_CLUBS,Card.SEVEN_DIAMONDS,Card.SEVEN_HEARTS}, gameTest.getPlayers()[1].getPack().toArray());
    }
    
    @Test(expected = AssertionError.class)
    public void testDoTurnPlayerHasNoLeftCards() {
        Card[][] packs = new Card[][] {{Card.EIGHT_SPADES, Card.KING_HEARTS, Card.ACE_DIAMONDS},
            {},{Card.TEN_DIAMONDS,Card.TEN_CLUBS,Card.ACE_CLUBS}}; 
        Game gameTest =  new Game(packs, "rcr");
        gameTest.doTurn(gameTest.getPlayers()[0], gameTest.getCardsToTop());
        gameTest.doTurn(gameTest.getPlayers()[1], gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{Card.EIGHT_SPADES}, gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{}, gameTest.getPlayers()[1].getPack().toArray());
    }
    
    @Test
    public void testNextPlayerNormalSituation() {
        Card[][] packs = new Card[][] {{Card.EIGHT_SPADES, Card.KING_HEARTS, Card.ACE_DIAMONDS},{Card.NINE_DIAMONDS,Card.QUEEN_CLUBS,
            Card.KING_DIAMONDS},{Card.TEN_DIAMONDS,Card.TEN_CLUBS,Card.ACE_CLUBS}}; 
        Game gameTest =  new Game(packs, "rcr");
        gameTest.doTurn(gameTest.getPlayers()[0], gameTest.getCardsToTop());
        int nextPlayer = gameTest.nextPlayer(0, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        assertEquals(1, nextPlayer);
        assertEquals(0, gameTest.getCountCantLay());
        assertArrayEquals(new Card[]{Card.NINE_DIAMONDS}, gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{Card.QUEEN_CLUBS,Card.KING_DIAMONDS}, gameTest.getPlayers()[1].getPack().toArray());
    }
    
    @Test
    public void testNextPlayerOnePlayerHasToSkip() {
        Card[][] packs = new Card[][] {{Card.EIGHT_SPADES, Card.KING_HEARTS, Card.ACE_DIAMONDS},
            {Card.SEVEN_CLUBS,Card.SEVEN_DIAMONDS,Card.SEVEN_HEARTS},{Card.TEN_CLUBS, Card.TEN_DIAMONDS, Card.ACE_CLUBS}}; 
        Game gameTest =  new Game(packs, "rcr");
        gameTest.doTurn(gameTest.getPlayers()[0], gameTest.getCardsToTop());
        int nextPlayer = gameTest.nextPlayer(0, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        assertEquals(2, nextPlayer);
        assertEquals(0, gameTest.getCountCantLay());
        assertArrayEquals(new Card[]{Card.TEN_CLUBS, Card.TEN_DIAMONDS}, gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{Card.ACE_CLUBS}, gameTest.getPlayers()[2].getPack().toArray());
    }
    
    @Test
    public void testNextPlayerAllPlayersSkiped() {
        Card[][] packs = new Card[][] {{Card.QUEEN_DIAMONDS, Card.KING_HEARTS, Card.ACE_DIAMONDS},
            {Card.SEVEN_CLUBS,Card.SEVEN_DIAMONDS,Card.SEVEN_HEARTS},{Card.TEN_CLUBS, Card.TEN_DIAMONDS, Card.QUEEN_CLUBS}}; 
        Game gameTest =  new Game(packs, "rcr");
        gameTest.doTurn(gameTest.getPlayers()[0], gameTest.getCardsToTop());
        int nextPlayer = gameTest.nextPlayer(0, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        assertEquals(0, nextPlayer);
        assertEquals(0, gameTest.getCountCantLay());
        assertArrayEquals(new Card[]{Card.KING_HEARTS}, gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{Card.ACE_DIAMONDS}, gameTest.getPlayers()[0].getPack().toArray());
    }
    
    @Test
    public void testNextPlayerAcePlacedCautiousPlayer() {
        Card[][] packs = new Card[][] {{Card.ACE_CLUBS, Card.ACE_DIAMONDS, Card.ACE_SPADES},
            {Card.SEVEN_CLUBS,Card.SEVEN_DIAMONDS,Card.SEVEN_HEARTS},{Card.TEN_CLUBS, Card.TEN_DIAMONDS, Card.QUEEN_CLUBS}}; 
        Game gameTest =  new Game(packs, "ccr");
        gameTest.doTurn(gameTest.getPlayers()[0], gameTest.getCardsToTop());
        int nextPlayer = gameTest.nextPlayer(0, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        assertEquals(0, nextPlayer);
        assertEquals(0, gameTest.getCountCantLay());
        assertArrayEquals(new Card[]{Card.ACE_SPADES}, gameTest.getCardsToTop());
        assertArrayEquals(new Card[]{}, gameTest.getPlayers()[0].getPack().toArray());
    }
    
    @Test
    public void testNextPlayerAcePlaced() {
        Card[][] packs = new Card[][] {{Card.JACK_DIAMONDS, Card.QUEEN_CLUBS, Card.ACE_SPADES},
            {Card.SEVEN_CLUBS,Card.SEVEN_DIAMONDS,Card.SEVEN_HEARTS},{Card.TEN_CLUBS, Card.TEN_DIAMONDS, Card.KING_DIAMONDS}}; 
        Game gameTest =  new Game(packs, "crc");
        gameTest.doTurn(gameTest.getPlayers()[0], gameTest.getCardsToTop());
        int nextPlayer = gameTest.nextPlayer(0, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        assertEquals(2, nextPlayer);
        assertEquals(0, gameTest.getCountCantLay());
        assertArrayEquals(new Card[]{Card.KING_DIAMONDS}, gameTest.getCardsToTop());
        int nextPlayer2 = gameTest.nextPlayer(2, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        assertEquals(0, nextPlayer2);
        assertArrayEquals(new Card[]{Card.ACE_SPADES}, gameTest.getCardsToTop());
        int nextPlayer3 = gameTest.nextPlayer(0, gameTest.getCardsToTop(), gameTest.getCountCantLay());
        assertEquals(0, nextPlayer3);
        assertArrayEquals(new Card[]{Card.QUEEN_CLUBS}, gameTest.getCardsToTop());
    }
    
}
