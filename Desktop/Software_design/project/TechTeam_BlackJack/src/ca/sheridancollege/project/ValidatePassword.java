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
public class ValidatePassword {

    public static void validPassword() {
        Scanner in = new Scanner(System.in);
//        System.out.println("Enter a password:");
//        String password = in.next();

        boolean isValid = false;

        System.out.println("Please create a password.");
        System.out.println("Greater than 7 characters, at least 1 uppercase and 1 special character.");

        while (!isValid) {
            System.out.println("Enter a password:");
            String password = in.next();

            if (!checkLength(password)) {
                System.out.println("ERROR: Must be at least 8 characters");
            }
            if (!checkUpper(password)) {
                System.out.println("ERROR: Must contain 1 uppercase");
            }
            if (!checkSpecial(password)) {
                System.out.println("ERROR: Must contain 1 special character");
            }
            if (checkLength(password) && checkUpper(password) && checkSpecial(password)) {
                System.out.println("Password is valid!");
                isValid = true;
            } else {
                System.out.println("Password is not valid. Please try again.\n");
            }

        }

    }

    public static boolean checkLength(String password) {

        if (password.length() > 7) {
            return true;
        } else {
            return false;
        }
    }
    

    public static boolean checkUpper(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkSpecial(String password) {
        String specialChars = "!@#$%^&*()";

        for (char s : password.toCharArray()) {
            if (specialChars.indexOf(s) != -1) {
                return true;
            }
        }
        return false;
    }

}
