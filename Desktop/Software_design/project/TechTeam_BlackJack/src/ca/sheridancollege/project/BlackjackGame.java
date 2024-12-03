/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

public class BlackjackGame extends Game {
    private GroupOfCards deck;
    private Player dealer;
    private Scanner scanner;

    public BlackjackGame(String name) {
        super(name);
        deck = new GroupOfCards(52);
        dealer = new Player("Dealer", 0L) {
            @Override
            public void play() {
                // Dealer logic
            }
        };
        scanner = new Scanner(System.in);
    }

    @Override
    public void play() {
        System.out.println("Starting Blackjack Game!");
        boolean continueGame = true;

        while (continueGame) {
            deck.shuffle();
            dealInitialCards();

            for (Player player : getPlayers()) {
                System.out.println();
                System.out.println("Player: " + player.getName() + " - Credits: " + player.getBalance());

                System.out.println();
                System.out.print("Enter bet amount: ");
                long bet = scanner.nextLong();
                player.placeBet(bet);

                while (!player.isStanding()) {
                    System.out.println();
                    System.out.println("Hand: " + player.getHand());
                    System.out.println("Hand Value: " + calculateHandValue(player));

                    System.out.println();
                    System.out.print("Action (Hit/Stand): ");
                    
                    String action = scanner.next();

                    processPlayerAction(player, action);
                }
            }

            dealerLogic();
            evaluateResult();
            
            System.out.println();
            System.out.print("Play another round? (yes/no): ");
            
            continueGame = scanner.next().equalsIgnoreCase("yes");
        }
        
        System.out.println();
        System.out.println("Game Over! Thanks for playing.");
    }

    private void dealerLogic() {
        while (calculateHandValue(dealer) < 17) {
            dealer.receiveCard(deck.getCards().remove(0));
        }
    }

    @Override
    public void declareWinner() {
        System.out.println("Winner declared after evaluation.");
    }
    
//  Function to deal cards
    public void dealInitialCards() {
        for (Player player : getPlayers()) {
            player.receiveCard(deck.getCards().remove(0));
            player.receiveCard(deck.getCards().remove(0));
        }
        dealer.receiveCard(deck.getCards().remove(0));
        dealer.receiveCard(deck.getCards().remove(0));
    }
    
//  Game logic, giving the player the option to hit/stand
    public void processPlayerAction(Player player, String action) {
        if ("Hit".equalsIgnoreCase(action)) {
            player.receiveCard(deck.getCards().remove(0));
            if (calculateHandValue(player) > 21) {
                System.out.println("Bust! " + player.getName() + " lost the round.");
                System.out.println();
                player.clearHand();
            }
        } else if ("Stand".equalsIgnoreCase(action)) {
            player.setStanding(true);
        } else{
            System.out.println("Unknown action. Please enter 'Hit' or 'Stand'.");
        }
    }

//    Method to evaluate the outcome of the game. Win/Loss/Tie
    public void evaluateResult() {
        int dealerValue = calculateHandValue(dealer);

        for (Player player : getPlayers()) {
            int playerValue = calculateHandValue(player);

            if (playerValue > 21) {
                System.out.println(player.getName() + " busted and lost their bet.");
            } else if (dealerValue > 21 || playerValue > dealerValue) {
                System.out.println();
                System.out.println(player.getName() + " wins!");
                player.addWinnings(2 * player.getCurrentBet());
            } else if (playerValue == dealerValue) {
                System.out.println(player.getName() + " ties with the dealer.");
                player.addWinnings(player.getCurrentBet());
            } else {
                System.out.println(player.getName() + " loses to the dealer.");
            }
            player.clearHand();
        }
        dealer.clearHand();
    }

    private int calculateHandValue(Player player) {
        int value = 0;
        int aceCount = 0;

        for (Card card : player.getHand()) {
            value += card.getNumericValue();
            if (card.getValue() == Card.Value.ACE) {
                aceCount++;
            }
        }

        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        return value;
    }

    // Add the main method to run the game
    public static void main(String[] args) {
        BlackjackGame blackjackGame = new BlackjackGame("Blackjack");

        ValidateUsername.validUsername();
        // User registration with password validation
        ValidatePassword.validPassword();

        // Add players
        blackjackGame.addPlayer(new Player(ValidateUsername.username, 1000L) {
            @Override
            public void play() { // Player logic handled in play method
            }
        });
        blackjackGame.addPlayer(new Player("Bob", 1000L) {
            @Override
            public void play() {
                // Player logic handled in play method
            }
        });
        // Start the game
        blackjackGame.play();
    }
}
