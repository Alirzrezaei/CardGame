/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ueb07;

import org.junit.Test;
import static org.junit.Assert.*;
import ueb07.cards.Card;

/**
 *
 * @author ite102770
 */
public class DealerTest {

    public DealerTest() {
    }

    @Test
    public void testChoose_OnOneCard_HasCardOneHigher() {
        
        Card[] cards = new Card[]{Card.EIGHT_SPADES, Card.KING_HEARTS};

        Player player = new CautiousGuy("Fred", cards);
        Card[] chosen = player.choose(new Card[]{Card.SEVEN_HEARTS});

        assertArrayEquals(new Card[]{Card.EIGHT_SPADES}, chosen);
        assertArrayEquals(new Card[]{Card.KING_HEARTS}, player.getPack().toArray());
    }
}
