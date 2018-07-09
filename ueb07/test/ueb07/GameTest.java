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
         Card[][] packs = new Card[][]{{Card.JACK_CLUBS,Card.JACK_DIAMONDS,Card.JACK_SPADES,Card.KING_DIAMONDS, Card.ACE_CLUBS, Card.ACE_DIAMONDS, Card.ACE_SPADES},
        {Card.SEVEN_CLUBS, Card.SEVEN_DIAMONDS, Card.SEVEN_HEARTS,Card.TEN_CLUBS}, 
        {Card.TEN_CLUBS, Card.TEN_DIAMONDS, Card.TEN_DIAMONDS}};
         Game gameTest = new Game(packs, "rcr");
         gameTest.doTurn(gameTest.getPlayers()[0], null);
         assertArrayEquals(new Card[] {Card.JACK_CLUBS,Card.JACK_DIAMONDS,Card.JACK_SPADES}, gameTest.getCardsToTop());
         int nextPlayer = gameTest.nextPlayer(0, gameTest.getCardsToTop(), gameTest.getCountCantLay());
         assertEquals(1, nextPlayer);
         gameTest.doTurn(gameTest.getPlayers()[nextPlayer], gameTest.getCardsToTop());
         nextPlayer = gameTest.nextPlayer(nextPlayer, gameTest.getCardsToTop(), gameTest.getCountCantLay());
         assertEquals(2, nextPlayer);
         gameTest.doTurn(gameTest.getPlayers()[nextPlayer], gameTest.getCardsToTop());
         nextPlayer = gameTest.nextPlayer(nextPlayer, gameTest.getCardsToTop(), gameTest.getCountCantLay());
         assertEquals(0, nextPlayer);
         gameTest.doTurn(gameTest.getPlayers()[nextPlayer], gameTest.getCardsToTop());
         assertArrayEquals(new Card[] {Card.ACE_CLUBS, Card.ACE_DIAMONDS, Card.ACE_SPADES}, gameTest.getCardsToTop()); 
    }
    
}
