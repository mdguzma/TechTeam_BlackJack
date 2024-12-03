/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

public class Card {
    public enum Suit {HEARTS, CLUBS, SPADES, DIAMONDS}
    public enum Value {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}

    private Value value;
    private Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }
// Method to evaluate the players hand. Certain card have number and suit's return 10
    public int getNumericValue() {
        switch (value) {
            case ACE: return 1; // Dynamically adjusted in Blackjack logic
            case TWO: return 2;
            case THREE: return 3;
            case FOUR: return 4;
            case FIVE: return 5;
            case SIX: return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE: return 9;
            case TEN:
            case JACK:
            case QUEEN:
            case KING:
                return 10;
            default: throw new IllegalArgumentException("Unexpected card value: " + value);
        }
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
    
    public int getDynamicAceValue(int currentHandValue) {
        return currentHandValue + 11 > 21 ? 1 : 11;
    }

}
