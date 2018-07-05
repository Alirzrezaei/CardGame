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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CautiousGuyTest {

    /**
     * Test of choose method, of class CautiousGuy.
     */
    @Test
    public void testChoose_OnEmptyStack() {
        Card[] cards = new Card[]{Card.EIGHT_SPADES, Card.KING_HEARTS};

        Player player = new CautiousGuy("Fred", cards);
        Card[] chosen = player.choose(null);

        assertArrayEquals(new Card[]{Card.EIGHT_SPADES}, chosen);
        assertArrayEquals(new Card[]{Card.KING_HEARTS}, player.getPack().toArray());
    }

    @Test
    public void testChoose_HasNoCards() {
        Player player = new CautiousGuy("Fred");
        Card[] chosen = player.choose(new Card[]{Card.EIGHT_SPADES});

        assertNull(chosen);
        assertArrayEquals(new Card[]{}, player.getPack().toArray());
    }

    @Test
    public void testChoose_OnOneCard_HasCardOneHigher() {
        Card[] cards = new Card[]{Card.EIGHT_SPADES, Card.KING_HEARTS};

        Player player = new CautiousGuy("Fred", cards);
        Card[] chosen = player.choose(new Card[]{Card.SEVEN_HEARTS});

        assertArrayEquals(new Card[]{Card.EIGHT_SPADES}, chosen);
        assertArrayEquals(new Card[]{Card.KING_HEARTS}, player.getPack().toArray());
    }

    @Test
    public void testChoose_OnOneCard_HasCardWithSameValue() {
        Card[] cards = new Card[]{Card.EIGHT_HEARTS, Card.KING_HEARTS};

        Player player = new CautiousGuy("Fred", cards);
        Card[] chosen = player.choose(new Card[]{Card.EIGHT_DIAMONDS});

        assertArrayEquals(new Card[]{Card.KING_HEARTS}, chosen);
        assertArrayEquals(new Card[]{Card.EIGHT_HEARTS}, player.getPack().toArray());
    }

    @Test
    public void testChoose_OnOneCard_HasCardWithNextValue() {
        Card[] cards = new Card[]{Card.NINE_HEARTS, Card.KING_HEARTS};

        Player player = new CautiousGuy("Fred", cards);
        Card[] chosen = player.choose(new Card[]{Card.EIGHT_SPADES});

        assertArrayEquals(new Card[]{Card.NINE_HEARTS}, chosen);
        assertArrayEquals(new Card[]{Card.KING_HEARTS}, player.getPack().toArray());
    }

    @Test
    public void testChoose_OnTwoCards_HasCardsOneHigher() {
        Card[] cards = new Card[]{Card.EIGHT_HEARTS, Card.EIGHT_SPADES, Card.KING_HEARTS};

        Player player = new CautiousGuy("Fred", cards);
        Card[] chosen = player.choose(new Card[]{Card.SEVEN_HEARTS, Card.SEVEN_SPADES});

        assertArrayEquals(new Card[]{Card.EIGHT_HEARTS, Card.EIGHT_SPADES}, chosen);
        assertArrayEquals(new Card[]{Card.KING_HEARTS}, player.getPack().toArray());
    }

    @Test
    public void testChoose_OnTwoCards_HasCardsWithSameValue() {
        Card[] cards = new Card[]{Card.EIGHT_HEARTS, Card.EIGHT_SPADES, Card.KING_HEARTS, Card.KING_SPADES};

        Player player = new CautiousGuy("Fred", cards);
        Card[] chosen = player.choose(new Card[]{Card.EIGHT_CLUBS, Card.EIGHT_DIAMONDS});

        assertArrayEquals(new Card[]{Card.KING_HEARTS, Card.KING_SPADES}, chosen);
        assertArrayEquals(new Card[]{Card.EIGHT_HEARTS, Card.EIGHT_SPADES}, player.getPack().toArray());
    }

    @Test
    public void testChoose_OnTwoCards_HasCardsWithNextValue() {
        Card[] cards = new Card[]{Card.NINE_HEARTS, Card.NINE_SPADES, Card.KING_HEARTS};

        Player player = new CautiousGuy("Fred", cards);
        Card[] chosen = player.choose(new Card[]{Card.EIGHT_HEARTS, Card.EIGHT_SPADES});

        assertArrayEquals(new Card[]{Card.NINE_HEARTS, Card.NINE_SPADES}, chosen);
        assertArrayEquals(new Card[]{Card.KING_HEARTS}, player.getPack().toArray());
    }

    @Test
    public void testChoose_OnOneCard_HasNoHigherValue() {
        Card[] cards = new Card[]{Card.SEVEN_HEARTS, Card.EIGHT_SPADES};

        Player player = new CautiousGuy("Fred", cards);
        Card[] chosen = player.choose(new Card[]{Card.EIGHT_HEARTS});

        assertArrayEquals(new Card[]{}, chosen);
        assertArrayEquals(new Card[]{Card.SEVEN_HEARTS, Card.EIGHT_SPADES}, player.getPack().toArray());
    }

    @Test
    public void testChoose_OnTwoCards_HasJustOneCardWithNextValue() {
        Card[] cards = new Card[]{Card.NINE_HEARTS, Card.KING_HEARTS};

        Player player = new CautiousGuy("Fred", cards);
        Card[] chosen = player.choose(new Card[]{Card.EIGHT_HEARTS, Card.EIGHT_SPADES});

        assertArrayEquals(new Card[]{}, chosen);
        assertArrayEquals(new Card[]{Card.NINE_HEARTS, Card.KING_HEARTS}, player.getPack().toArray());
    }

    @Test
    public void testChoose_OnOneCard_HasNoHigherValue_SameValuePack() {//for two value its work but for more two does not
        Card[] cards = new Card[]{Card.EIGHT_CLUBS, Card.EIGHT_DIAMONDS, Card.EIGHT_SPADES};

        Player player = new CautiousGuy("Fred", cards);
        Card[] chosen = player.choose(new Card[]{Card.SEVEN_CLUBS});

        assertArrayEquals(new Card[]{Card.EIGHT_CLUBS}, chosen);
        assertArrayEquals(new Card[]{Card.EIGHT_DIAMONDS, Card.EIGHT_SPADES}, player.getPack().toArray());
    }

    @Test
    public void testChoose_HasNoHigherValue_SameValuePack() {
        Card[] cards = new Card[]{Card.EIGHT_CLUBS, Card.EIGHT_DIAMONDS, Card.EIGHT_SPADES};

        Player player = new CautiousGuy("Fred", cards);
        Card[] chosen = player.choose(new Card[]{Card.SEVEN_CLUBS, Card.SEVEN_DIAMONDS});

        assertArrayEquals(new Card[]{Card.EIGHT_CLUBS, Card.EIGHT_DIAMONDS}, chosen);
        assertArrayEquals(new Card[]{Card.EIGHT_SPADES}, player.getPack().toArray());
    }

    @Test
    public void testChoose_HasNoHigherValue_SameValuePack2() {
        Card[] cards = new Card[]{Card.EIGHT_CLUBS, Card.EIGHT_DIAMONDS, Card.EIGHT_SPADES, Card.KING_CLUBS, Card.ACE_DIAMONDS};

        Player player = new CautiousGuy("Fred", cards);
        Card[] chosen = player.choose(new Card[]{Card.TEN_CLUBS, Card.TEN_DIAMONDS, Card.ACE_CLUBS, Card.ACE_DIAMONDS});

        assertArrayEquals(new Card[]{}, chosen);
        assertArrayEquals(new Card[]{Card.EIGHT_CLUBS, Card.EIGHT_DIAMONDS, Card.EIGHT_SPADES, Card.KING_CLUBS, Card.ACE_DIAMONDS}, player.getPack().toArray());
    }

    @Test
    public void testChoose_HasNoHigherValue_SameValuePack3() {
        Card[] cards = new Card[]{Card.JACK_CLUBS, Card.JACK_DIAMONDS, Card.JACK_HEARTS, Card.JACK_SPADES, Card.ACE_DIAMONDS};

        Player player = new CautiousGuy("Fred", cards);
        Card[] chosen = player.choose(new Card[]{Card.TEN_CLUBS, Card.TEN_DIAMONDS, Card.TEN_HEARTS, Card.TEN_SPADES});

        assertArrayEquals(new Card[]{Card.JACK_CLUBS, Card.JACK_DIAMONDS, Card.JACK_HEARTS, Card.JACK_SPADES}, chosen);
        assertArrayEquals(new Card[]{Card.ACE_DIAMONDS}, player.getPack().toArray());
    }

    @Test
    public void testChoose_HasNoHigherValue_SameValuePack4() {
        Card[] cards = new Card[]{Card.NINE_CLUBS, Card.JACK_HEARTS, Card.JACK_SPADES};

        Player player = new CautiousGuy("Fred", cards);
        Card[] chosen = player.choose(new Card[]{Card.EIGHT_CLUBS, Card.EIGHT_DIAMONDS});

        assertArrayEquals(new Card[]{Card.JACK_HEARTS, Card.JACK_SPADES}, chosen);
        assertArrayEquals(new Card[]{Card.NINE_CLUBS}, player.getPack().toArray());
    }
     @Test
    public void testChoose_OnEmptyStack2() {
        Card[] cards = new Card[]{Card.EIGHT_CLUBS,Card.EIGHT_SPADES, Card.KING_HEARTS};

        Player player = new CautiousGuy("Fred", cards);
        Card[] chosen = player.choose(null);

        assertArrayEquals(new Card[]{Card.EIGHT_CLUBS}, chosen);
        assertArrayEquals(new Card[]{Card.EIGHT_SPADES, Card.KING_HEARTS}, player.getPack().toArray());
    }
    @Test
    public void testChoose_OnEmptyOnTop() {
        Card[] cards = new Card[]{Card.EIGHT_SPADES, Card.KING_HEARTS, Card.ACE_DIAMONDS};

        Player player = new CautiousGuy("Fred", cards);
        Card[] chosen = player.choose(null);

        assertArrayEquals(new Card[]{Card.EIGHT_SPADES}, chosen);
        assertArrayEquals(new Card[]{Card.KING_HEARTS, Card.ACE_DIAMONDS}, player.getPack().toArray());
    }
@Test
    public void testToString() {
        Card[] cards = new Card[]{Card.EIGHT_SPADES, Card.KING_HEARTS, Card.ACE_DIAMONDS};

        Player player = new CautiousGuy("Fred", cards);
         assertEquals("CFred: EIGHT_SPADES, KING_HEARTS, ACE_DIAMONDS", player.toString());
    }
    @Test
    public void testChoose_OnOnTop() {
        Card[] cards = new Card[]{Card.JACK_DIAMONDS, Card.QUEEN_CLUBS, Card.ACE_SPADES};

        Player player = new CautiousGuy("Fred", cards);
        Card[] chosen = player.choose(new Card[]{Card.KING_DIAMONDS});

        assertArrayEquals(new Card[]{Card.ACE_SPADES}, chosen);
        assertArrayEquals(new Card[]{Card.JACK_DIAMONDS, Card.QUEEN_CLUBS}, player.getPack().toArray());
    }
  
}
