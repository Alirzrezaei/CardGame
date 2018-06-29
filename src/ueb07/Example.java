package ueb07;

import ueb07.cards.Card;

/**
 * Main class for example game. 
 * @author klk
 */
public class Example {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(Card.SEVEN_CLUBS.ordinal());
        Game game = new Game(3);
        game.playGame();
    }
    
}
