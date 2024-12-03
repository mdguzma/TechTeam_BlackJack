/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */
public abstract class Card {
    public enum Suit {HEARTS, CLUBS, SPADES, DIAMONDS}
    public enum Value {ACE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING,JOKER}
    
    private Value value;
    private Suit suit;

//    TODO
//    Switch statement to assign values to cards
//    Logic for ACE = 1 || 11
    
//   DONE
//    Suits have value of 10
   
    
    
    // Constructors, getters, and setters would go here
    
    // Constructor
    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }
    
    public Value getValue() {
        // Method implementation
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Value value) {
        this.value = value;
    }
    
    /**
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    
    /**
     * @param suit the suit to set
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }
//    Method to retun appropriate value for card
    public int getNumericValue(){
//        Switch Statement 
        switch(value){
            case ACE: 
                return 1;
//                Could probably do if true = 1 || if false = 11
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case TEN:
            case JACK:
            case QUEEN:
            case KING:
                return 10;
            default:
                throw new IllegalArgumentException("Unexpected value: " + value);
        }
    }
    
        // Method to make all suits = 10
    public int getSuitValue() {
        return 10; // All suits are considered to have a value of 10
    }
    
    
    
    @Override
    public String toString() {
        return value + " of " + suit;
    }
}