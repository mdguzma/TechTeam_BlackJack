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
                System.out.println("Player: " + player.getName() + " - Credits: " + player.getBalance());

                System.out.print("Enter bet amount: ");
                long bet = scanner.nextLong();
                player.placeBet(bet);

                while (!player.isStanding()) {
                    System.out.println("Hand: " + player.getHand());
                    System.out.println("Hand Value: " + calculateHandValue(player));

                    System.out.print("Action (Hit/Stand): ");
                    String action = scanner.next();

                    processPlayerAction(player, action);
                }
            }

            dealerLogic();
            evaluateResult();

            System.out.print("Play another round? (yes/no): ");
            continueGame = scanner.next().equalsIgnoreCase("yes");
        }

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

    public void dealInitialCards() {
        for (Player player : getPlayers()) {
            player.receiveCard(deck.getCards().remove(0));
            player.receiveCard(deck.getCards().remove(0));
        }
        dealer.receiveCard(deck.getCards().remove(0));
        dealer.receiveCard(deck.getCards().remove(0));
    }

    public void processPlayerAction(Player player, String action) {
        if ("Hit".equalsIgnoreCase(action)) {
            player.receiveCard(deck.getCards().remove(0));
            if (calculateHandValue(player) > 21) {
                System.out.println("Bust! " + player.getName() + " lost the round.");
                player.clearHand();
            }
        } else if ("Stand".equalsIgnoreCase(action)) {
            player.setStanding(true);
        }
    }

    public void evaluateResult() {
        int dealerValue = calculateHandValue(dealer);

        for (Player player : getPlayers()) {
            int playerValue = calculateHandValue(player);

            if (playerValue > 21) {
                System.out.println(player.getName() + " busted and lost their bet.");
            } else if (dealerValue > 21 || playerValue > dealerValue) {
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

        // Add players
        blackjackGame.addPlayer(new Player("Alice", 1000L) {
            @Override
            public void play() {
                // Player logic handled in play method
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
