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
public class ValidateUsername {
    public static String username;
    
    public static void validUsername(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a username: ");
        username = in.next();
    }
}
