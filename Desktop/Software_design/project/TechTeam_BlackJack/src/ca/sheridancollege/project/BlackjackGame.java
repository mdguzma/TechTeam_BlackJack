/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author solty
 */
//Test Push
public class BlackjackGame extends Game {
    private GroupOfCards deck;
    private Player dealer;

    public BlackjackGame(String name) {
        super(name);
        deck = new GroupOfCards();
        dealer = new Player("Dealer", 0);
    }

    @Override
    public void play() {
        // Logic to play the game
    }

    @Override
    public void declareWinner() {
        // Logic to declare the winner
    }

    public void dealInitialCards() {
        // Deal two cards to each player
    }

    public void evaluateResult() {
        // Evaluate the game result after all players are done
    }

    public void processPlayerAction(Player player, String action) {
        // Process player's action (Hit or Stand)
    }

    public void nextRound() {
        // Prepare for the next round
    }
}

