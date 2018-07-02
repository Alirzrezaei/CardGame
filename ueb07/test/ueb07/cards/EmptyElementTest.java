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
public class EmptyElementTest {
    
   
    @Test
    public void testAddElement() {
        List ls = new EmptyElement();
        assertEquals(0, ls.size());
        ls = ls.add(Card.ACE_HEARTS);
       assertEquals(1, ls.size()); 
    }
     @Test
      public void testRemoveElement() {
        List ls = new EmptyElement();
        assertEquals(0, ls.size());
        assertNull(ls.getFirstCardWithValue(0));
        assertNull(ls.getCardAt(-1));
        assertNull(ls.getCardAt(0));  
    }
    
}
