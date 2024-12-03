/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private String name;
    private List<Card> hand;
    private long balance;
    private long currentBet;
    private boolean isStanding;

    public Player(String name, long balance) {
        this.name = name;
        this.balance = balance;
        this.hand = new ArrayList<>();
        this.isStanding = false;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public long getBalance() {
        return balance;
    }

    public long getCurrentBet() {
        return currentBet;
    }

    public void placeBet(long amount) {
        this.currentBet = amount;
        this.balance -= amount;
    }

    public void addWinnings(long amount) {
        this.balance += amount;
    }

    public boolean isStanding() {
        return isStanding;
    }

    public void setStanding(boolean standing) {
        isStanding = standing;
    }

    public void receiveCard(Card card) {
        hand.add(card);
    }

    public void clearHand() {
        hand.clear();
        isStanding = false;
    }

    public abstract void play();
}