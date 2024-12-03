/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
    public abstract class Player {

    private String name; // the unique name for this player
    private List<Card> hand; // the player's current hand of cards
    private Long balance; // the player's current balance
    private double currentBet; // the player's current bet amount
    private boolean isStanding; // flag to track if the player has chosen to stand

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name, Long balance) {
        this.name = name;
        this.balance = balance;
        this.hand = new ArrayList<>();
        this.isStanding = false;
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the player name is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Places a bet for the player
     *
     * @param amount the amount to bet
     */
    public void placeBet(Long amount) {
        this.currentBet = amount;
        this.balance -= amount;
    }

    /**
     * Receives a card and adds it to the player's hand
     *
     * @param card the card to receive
     */
    public void receiveCard(Card card) {
        hand.add(card);
    }

    /**
     * Decides the player's move
     *
     * @param action the action to take ("Hit" or "Stand")
     */
    public void decideMove(String action) {
        if ("Hit".equalsIgnoreCase(action)) {
            // Game will provide another card, logic defined in the game class
        } else if ("Stand".equalsIgnoreCase(action)) {
            isStanding = true;
        }
    }

    /**
     * Clears the player's hand at the end of a round
     */
    public void clearHand() {
        hand.clear();
        isStanding = false;
    }

    /**
     * @return true if the player is standing, false otherwise
     */
    public boolean isStanding() {
        return isStanding;
    }

    /**
     * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
     * with logic to play your game.
     */
    public abstract void play();

}
