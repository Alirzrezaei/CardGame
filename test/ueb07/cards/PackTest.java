package ueb07.cards;

import ueb07.cards.Card;
import ueb07.cards.Pack;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static ueb07.cards.Card.*;

/**
 *
 * @author GeritKaleck
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PackTest {

    /**
     * Test of toArray method, of class Pack. Has to be tested first.
     */
    @Test
    public void testAToArray() {
        Card[] cards = new Card[]{NINE_DIAMONDS, QUEEN_HEARTS, QUEEN_SPADES};
        Pack pack = new Pack(cards);
        assertArrayEquals(cards, pack.toArray());
    }

    @Test
    public void testAToArray_Sorting() {
        Card[] cards = new Card[]{QUEEN_HEARTS, NINE_DIAMONDS, QUEEN_SPADES};
        Pack pack = new Pack(cards);
        assertArrayEquals(new Card[]{NINE_DIAMONDS, QUEEN_HEARTS, QUEEN_SPADES}, pack.toArray());
    }

    /**
     * Test of getFirstCard method, of class Pack.
     */
    @Test
    public void testGetFirstCard() {
        Pack pack = new Pack(new Card[]{NINE_DIAMONDS, QUEEN_SPADES});
        assertEquals(2, pack.size());
        assertEquals(NINE_DIAMONDS, pack.getFirstCard());
    }

    @Test
    public void testGetFirstCard_EmptyPack() {
        Pack pack = new Pack();
        assertNull(pack.getFirstCard());
    }

    /**
     * Test of getCardAt method, of class Pack.
     */
    @Test
    public void testGetCardAt() {
        Pack pack = new Pack(new Card[]{NINE_DIAMONDS, QUEEN_SPADES});
        assertEquals(NINE_DIAMONDS, pack.getCardAt(0));
        assertEquals(QUEEN_SPADES, pack.getCardAt(1));
    }

    @Test
    public void testGetCardAt_InvalidIndex() {
        Pack pack = new Pack(new Card[]{NINE_DIAMONDS, QUEEN_SPADES});
        assertNull(pack.getCardAt(-1));
        assertNull(pack.getCardAt(2));
    }

    /**
     * Test of getCardWithValue method, of class Pack.
     */
    @Test
    public void testGetCardWithValue() {
        Pack pack = new Pack(new Card[]{NINE_DIAMONDS, QUEEN_HEARTS, QUEEN_SPADES});
        assertEquals(NINE_DIAMONDS, pack.getCardWithValue(9));
        assertEquals(QUEEN_HEARTS, pack.getCardWithValue(12));
    }

    @Test
    public void testGetCardWithValue_NotExisting() {
        Pack pack = new Pack(new Card[]{NINE_DIAMONDS, QUEEN_SPADES});
        assertNull(pack.getCardWithValue(8));
        assertNull(pack.getCardWithValue(10));
        assertNull(pack.getCardWithValue(13));
        assertNull(pack.getCardWithValue(-1));
    }

    /**
     * Test of getCardsWithValue method, of class Pack.
     */
    @Test
    public void testGetCardsWithValue() {
        Pack pack = new Pack(new Card[]{NINE_DIAMONDS, QUEEN_HEARTS, QUEEN_SPADES});
        assertArrayEquals(new Card[]{NINE_DIAMONDS}, pack.getCardsWithValue(9));
        assertArrayEquals(new Card[]{QUEEN_HEARTS, QUEEN_SPADES}, pack.getCardsWithValue(12));
    }

    @Test
    public void testGetCardsWithValue_NotExisting() {
        Pack pack = new Pack(new Card[]{NINE_DIAMONDS, QUEEN_HEARTS, QUEEN_SPADES});
        assertArrayEquals(new Card[]{}, pack.getCardsWithValue(8));
        assertArrayEquals(new Card[]{}, pack.getCardsWithValue(10));
        assertArrayEquals(new Card[]{}, pack.getCardsWithValue(13));
    }

    /**
     * Test of getCardWithValueHigherThan method, of class Pack.
     */
    @Test
    public void testGetCardWithValueHigherThan() {
        Pack pack = new Pack(new Card[]{NINE_DIAMONDS, QUEEN_HEARTS, QUEEN_SPADES});
        assertEquals(NINE_DIAMONDS, pack.getCardWithValueHigherThan(7));
        assertEquals(NINE_DIAMONDS, pack.getCardWithValueHigherThan(8));
        assertEquals(QUEEN_HEARTS, pack.getCardWithValueHigherThan(9));
        assertEquals(QUEEN_HEARTS, pack.getCardWithValueHigherThan(10));
        assertEquals(QUEEN_HEARTS, pack.getCardWithValueHigherThan(11));
    }

    @Test
    public void testGetCardWithValueHigherThan_NotExisting() {
        Pack pack = new Pack(new Card[]{NINE_DIAMONDS, QUEEN_HEARTS, QUEEN_SPADES});
        assertNull(pack.getCardWithValueHigherThan(12));
        assertNull(pack.getCardWithValueHigherThan(13));
    }

    @Test
    public void testGetCardWithValueHigherThan_EmptyPack() {
        Pack pack = new Pack();
        assertNull(pack.getCardWithValueHigherThan(7));
    }

    /**
     * Test of Remove method, of class Pack.
     */
    @Test
    public void testRemoveCard() {
        Pack pack = new Pack(new Card[]{NINE_DIAMONDS, QUEEN_HEARTS, QUEEN_SPADES});
        assertEquals(3, pack.size());
        pack.remove(NINE_DIAMONDS);
        assertEquals(2, pack.size());
        assertFalse(pack.contains(NINE_DIAMONDS));
    }

    @Test(expected = AssertionError.class)
    public void testRemoveCard_NullCard() {
        Pack pack = new Pack(null);
        assertEquals(0, pack.size());
        pack.remove((Card) NINE_CLUBS);
        assertEquals(0, pack.size());
    }

    @Test(expected = AssertionError.class)
    public void testRemoveCard_NullArray() {
        Pack pack = new Pack(new Card[]{NINE_DIAMONDS});
        assertEquals(1, pack.size());
        pack.remove((Card) null);
        assertEquals(1, pack.size());
    }

    @Test
    public void testRemoveCard_NotExisting() {
        Pack pack = new Pack(new Card[]{NINE_DIAMONDS, QUEEN_HEARTS, QUEEN_SPADES});
        assertArrayEquals(new Card[]{}, pack.getCardsWithValue(8));
        assertArrayEquals(new Card[]{}, pack.getCardsWithValue(10));
        assertArrayEquals(new Card[]{}, pack.getCardsWithValue(13));
    }

    @Test
    public void testRemoveCard_inArray() {
        Pack pack = new Pack(new Card[]{NINE_DIAMONDS, QUEEN_HEARTS, QUEEN_SPADES, KING_DIAMONDS, KING_HEARTS});
        assertEquals(5, pack.size());
        pack.remove(new Card[]{QUEEN_HEARTS, KING_HEARTS, NINE_CLUBS});
        assertEquals(3, pack.size());
    }

    @Test(expected = AssertionError.class)
    public void testRemoveCard_inArrayNull() {
        Pack pack = new Pack(new Card[]{NINE_DIAMONDS, QUEEN_HEARTS, QUEEN_SPADES, KING_DIAMONDS, KING_HEARTS});
        assertEquals(5, pack.size());
        pack.remove((Card) null);
        assertEquals(5, pack.size());
    }

    @Test(expected = AssertionError.class)
    public void testRemoveCard_inArrayNull2() {
        Pack pack = new Pack(null);
        assertEquals(0, pack.size());
        pack.remove(new Card[]{NINE_DIAMONDS, QUEEN_HEARTS, QUEEN_SPADES, KING_DIAMONDS, KING_HEARTS});
        assertEquals(0, pack.size());
    }

    @Test(expected = AssertionError.class)
    public void testContains_NullCard() {
        Pack pack = new Pack(null);
        assertEquals(0, pack.size());
        assertFalse(pack.contains(NINE_DIAMONDS));

    }

    /**
     * Test of toString method, of class Pack.
     */
    @Test
    public void testToString() {
        Pack cards = new Pack(new Card[]{NINE_DIAMONDS, QUEEN_HEARTS, QUEEN_SPADES});
        assertEquals("NINE_DIAMONDS, QUEEN_HEARTS, QUEEN_SPADES", cards.toString());
        
    }

    @Test
    public void testToString_Sorting() {
        Card[] cards = new Card[]{QUEEN_HEARTS, NINE_DIAMONDS, QUEEN_SPADES};
        Pack pack = new Pack(cards);
        assertArrayEquals(new Card[]{NINE_DIAMONDS,QUEEN_HEARTS,QUEEN_SPADES}, pack.toArray());
    }

    @Test
    public void testIsEmpty() {
        Pack pack = new Pack();
        assertEquals(0, pack.size());
    }

    @Test
    public void testIsEmpty_withAddElement() {
        Pack pack = new Pack();
        pack.add(ACE_HEARTS);
        assertEquals(1, pack.size());
        pack.remove(ACE_HEARTS);
        assertEquals(0, pack.size());
    }
    @Test
    public void testRomoveIsNotThere() {
         Pack cards = new Pack(new Card[]{NINE_DIAMONDS, QUEEN_HEARTS, QUEEN_SPADES});

        assertEquals(3, cards.size());
        cards.remove(ACE_HEARTS);
        assertEquals(3, cards.size());
    }
}
