/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/** 
 *
 * @author mdguzman
 */
public class Wager {
    
    public static long validWager(long balance) {
        Scanner in = new Scanner(System.in);
        long wager = 0;
        boolean isValid = false;
        
//      Keep trying until the bet is a valid amount
        while (!isValid) {
            System.out.print("Enter wager amount: ");
            wager = in.nextLong();

            if (wager > 0 && wager <= balance) {
                isValid = true;
            } else if (wager <= 0) {
                System.out.println("Wager must be greater than $0.");
            } else {
                System.out.println("Wager exceeds available balance. Your balance is: " + balance);
            }
        }
        return wager;
    }
    
}
