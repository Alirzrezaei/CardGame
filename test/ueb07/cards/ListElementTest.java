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
    
     private Element createElements(char... value){
        if (value.length == 0) {
            return null;
        }
        // create a new element
        Element el = new Element(value[0]);
        Element firstEl = el; // remember first element
        
        // create more elements
        for (int i = 1; i < value.length; i++) {
            el.setNext(new Element()) ;
            el = el.getNext();
             el.setValue(value[i]);
        }
        return firstEl;       
    }
    @Test
    public void testSomeMethod() {
    }
    
}
