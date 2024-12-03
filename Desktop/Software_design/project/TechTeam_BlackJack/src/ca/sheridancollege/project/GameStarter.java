/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Ha Huynh
 */
public class GameStarter {
    public static void main(String[] args) {
        BlackjackGame blackjackGame = new BlackjackGame("Blackjack");

        ValidateUsername.validUsername();
        ValidatePassword.validPassword();

        blackjackGame.addPlayer(new Player(ValidateUsername.username, 1000L) {
            @Override
            public void play() { }
        });

        blackjackGame.play();
    }
}


