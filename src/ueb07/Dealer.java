/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ueb07;

import ueb07.cards.Card;

/**
 *
 * @author ite102770
 */
public class Dealer extends Player {
    
    
    Dealer(){
        Player dealer = new Player();
    }
     /**
     * Returns all the cards a player want to play. These cards are removed from
     * his/her pack. If a player cannot play any card, an empty array is
     * returned. If he does not have any cards left null is returned.
     *
     * @param cardsToTop card(s) that has to be surpassed
     * @return all cards that the player wants to play, an empty array if he
     * cannto play any card, null if he does not have any cards left      *
     */
    @Override
    public Card[] choose(Card[] cardsToTop){
        
    }
    
}
