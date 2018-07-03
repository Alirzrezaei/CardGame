package ueb07;

import ueb07.Player;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import ueb07.cards.Card;

/**
 *
 * @author GeritKaleck
 */
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class RiskyGuyTest {
    
    /**
     * Test of choose method, of class RiskyGuy.
     */
    @Test
    public void testChoose_OnEmptyStack() {
        Card[] cards = new Card[] {Card.EIGHT_SPADES, Card.KING_HEARTS, Card.ACE_DIAMONDS};       
        
        Player player = new RiskyGuy("Fritz", cards);
        Card[] chosen = player.choose(null);
        
        assertArrayEquals(new Card[]{Card.EIGHT_SPADES}, chosen);
        assertArrayEquals(new Card[]{Card.KING_HEARTS, Card.ACE_DIAMONDS}, player.getPack().toArray());
    }
    
    @Test
    public void testChoose_HasNoCards() {
         Player player = new RiskyGuy("Fritz");
        Card[] chosen = player.choose(new Card[]{Card.EIGHT_SPADES});
        
        assertNull(chosen);
        assertArrayEquals(new Card[]{}, player.getPack().toArray());
    }   
    
    @Test
    public void testChoose_OnOneCard_HasCardOneHigher() {
        Card[] cards = new Card[] {Card.EIGHT_CLUBS, Card.EIGHT_SPADES, Card.KING_HEARTS};   
        
        Player player = new RiskyGuy("Fritz", cards);
        Card[] chosen = player.choose(new Card[]{Card.SEVEN_HEARTS});
        
        assertArrayEquals(new Card[]{Card.EIGHT_CLUBS, Card.EIGHT_SPADES}, chosen);
        assertArrayEquals(new Card[]{Card.KING_HEARTS}, player.getPack().toArray());
    }
    
    @Test
    public void testChoose_OnOneCard_HasCardWithSameValue() {
        Card[] cards = new Card[] {Card.EIGHT_CLUBS, Card.EIGHT_HEARTS, Card.KING_CLUBS, Card.KING_HEARTS} ;   
        
        Player player = new RiskyGuy("Fritz", cards);
        Card[] chosen = player.choose(new Card[]{Card.EIGHT_DIAMONDS});
        
        assertArrayEquals(new Card[]{Card.KING_CLUBS, Card.KING_HEARTS}, chosen);
        assertArrayEquals(new Card[]{Card.EIGHT_CLUBS, Card.EIGHT_HEARTS}, player.getPack().toArray());
    }
    
    @Test
    public void testChoose_OnOneCard_HasCardWithNextValue() {
        Card[] cards = new Card[] {Card.NINE_HEARTS, Card.NINE_SPADES, Card.KING_HEARTS}; 
        
        Player player = new RiskyGuy("Fritz", cards);
        Card[] chosen = player.choose(new Card[]{Card.EIGHT_SPADES});
        
        assertArrayEquals(new Card[]{Card.NINE_HEARTS, Card.NINE_SPADES}, chosen);
        assertArrayEquals(new Card[]{Card.KING_HEARTS}, player.getPack().toArray());
    }

    
    @Test
    public void testChoose_OnTwoCards_HasCardsOneHigher() {
        Card[] cards = new Card[] {Card.EIGHT_DIAMONDS, Card.EIGHT_HEARTS, Card.EIGHT_SPADES, Card.KING_HEARTS};   
        
        Player player = new RiskyGuy("Fritz", cards);
        Card[] chosen = player.choose(new Card[]{Card.SEVEN_HEARTS, Card.SEVEN_SPADES});        
        
        assertArrayEquals(new Card[]{Card.EIGHT_DIAMONDS, Card.EIGHT_HEARTS, Card.EIGHT_SPADES}, chosen);
        assertArrayEquals(new Card[]{Card.KING_HEARTS}, player.getPack().toArray());
    }
    
    @Test
    public void testChoose_OnTwoCards_HasCardsWithSameValue() {
        Card[] cards = new Card[] {Card.EIGHT_HEARTS, Card.EIGHT_SPADES, Card.KING_HEARTS, Card.KING_SPADES};   
        
        Player player = new RiskyGuy("Fritz", cards);
        Card[] chosen = player.choose(new Card[]{Card.EIGHT_CLUBS, Card.EIGHT_DIAMONDS});        
        
        assertArrayEquals(new Card[]{Card.KING_HEARTS, Card.KING_SPADES}, chosen);
        assertArrayEquals(new Card[]{Card.EIGHT_HEARTS, Card.EIGHT_SPADES}, player.getPack().toArray());
    }
    
    @Test
    public void testChoose_OnTwoCards_HasCardsWithNextValue() {
        Card[] cards = new Card[] {Card.NINE_CLUBS, Card.NINE_HEARTS, Card.NINE_SPADES, Card.KING_HEARTS};   
        
        Player player = new RiskyGuy("Fritz", cards);
        Card[] chosen = player.choose(new Card[]{Card.EIGHT_HEARTS, Card.EIGHT_SPADES});        
        
        assertArrayEquals(new Card[]{Card.NINE_CLUBS, Card.NINE_HEARTS, Card.NINE_SPADES}, chosen);
        assertArrayEquals(new Card[]{Card.KING_HEARTS}, player.getPack().toArray());
    }
    
    @Test
    public void testChoose_OnOneCard_HasNoHigherValue() {
        Card[] cards = new Card[] {Card.SEVEN_HEARTS, Card.EIGHT_SPADES};   
        
        Player player = new RiskyGuy("Fritz", cards);
        Card[] chosen = player.choose(new Card[]{Card.EIGHT_HEARTS}); 
        
        assertArrayEquals(new Card[]{}, chosen);
        assertArrayEquals(new Card[]{Card.SEVEN_HEARTS, Card.EIGHT_SPADES}, player.getPack().toArray());
    }
    
    @Test
    public void testChoose_OnTwoCards_HasJustOneCardWithNextValue() {
        Card[] cards = new Card[] {Card.NINE_HEARTS, Card.KING_HEARTS};   
        
        Player player = new RiskyGuy("Fritz", cards);
        Card[] chosen = player.choose(new Card[]{Card.EIGHT_HEARTS, Card.EIGHT_SPADES}); 
        
        assertArrayEquals(new Card[]{}, chosen);
        assertArrayEquals(new Card[]{Card.NINE_HEARTS, Card.KING_HEARTS}, player.getPack().toArray());
   }
    ////// Own test case
     @Test
    public void testChoose_HasNoHigherValue_SameValuePack4() {
        Card[] cards = new Card[]{Card.NINE_CLUBS,  Card.JACK_HEARTS, Card.JACK_SPADES};

        Player player = new CautiousGuy("Fred", cards);
        Card[] chosen = player.choose(new Card[]{Card.EIGHT_CLUBS, Card.EIGHT_DIAMONDS});

        assertArrayEquals(new Card[]{Card.JACK_HEARTS, Card.JACK_SPADES}, chosen);
        assertArrayEquals(new Card[]{Card.NINE_CLUBS}, player.getPack().toArray());
    }
     @Test
    public void testChoose_OnEmptyStack_() {
        Card[] cards = new Card[] {Card.EIGHT_CLUBS, Card.EIGHT_DIAMONDS, Card.EIGHT_SPADES, Card.KING_HEARTS};       
        
        Player player = new RiskyGuy("Fritz", cards);
        Card[] chosen = player.choose(null);
        
        assertArrayEquals(new Card[]{Card.EIGHT_CLUBS, Card.EIGHT_DIAMONDS, Card.EIGHT_SPADES}, chosen);
        assertArrayEquals(new Card[]{Card.KING_HEARTS}, player.getPack().toArray());
    }
     @Test
    public void testChoose_OnEmptyOnTop() {
        Card[] cards = new Card[]{Card.EIGHT_SPADES, Card.KING_HEARTS, Card.ACE_DIAMONDS};

        Player player = new CautiousGuy("Fred", cards);
        Card[] chosen = player.choose(null);

        assertArrayEquals(new Card[]{Card.EIGHT_SPADES}, chosen);
        assertArrayEquals(new Card[]{Card.KING_HEARTS, Card.ACE_DIAMONDS}, player.getPack().toArray());
    }
    
}
