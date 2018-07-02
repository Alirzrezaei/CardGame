/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ueb07.cards;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Reyhan
 */
public class ListElementTest {
    
    /**
     *test for size
     */
    @Test 
    public void testGetCardAt() {
        List ls = new ListElement(Card.ACE_HEARTS);
        assertEquals(1, ls.size());
        assertEquals(Card.ACE_HEARTS, ls.getCardAt(0));
    }
    @Test
    public void testAddValue() {
        List ls = new ListElement(Card.JACK_HEARTS , (List) this);
        assertEquals(1, ls.size());
        ls = ls.add(Card.ACE_HEARTS);
        ls = ls.add(Card.EIGHT_DIAMONDS);
        assertEquals(3, ls.size());
        assertEquals(Card.EIGHT_DIAMONDS, ls.getCardAt(0));
        assertEquals(Card.JACK_HEARTS, ls.getCardAt(1));
        assertEquals(Card.ACE_HEARTS, ls.getCardAt(2));
    }
    @Test
    public void testRemoveValue() {
        List ls = new EmptyElement();
        ls.add(Card.JACK_HEARTS);
        assertEquals(1, ls.size());
        ls = ls.add(Card.ACE_HEARTS);
        ls = ls.add(Card.EIGHT_DIAMONDS);
        assertEquals(3, ls.size());
        ls = ls.remove(Card.JACK_HEARTS);
        assertEquals(2, ls.size());
        assertEquals(Card.EIGHT_DIAMONDS, ls.getCardAt(0));
        assertEquals(Card.ACE_HEARTS, ls.getCardAt(1));
    }
    @Test
    public void testIsEmpty() {
        List ls = new EmptyElement();
        assertEquals(0, ls.size());
        ls = ls.add(Card.ACE_HEARTS);
        assertEquals(1, ls.size());
        assertFalse(ls.isEmpty());
        ls = ls.remove(Card.ACE_HEARTS);
        //assertTrue(ls.isEmpty());
        assertEquals(0, ls.size());
    }
    
}
