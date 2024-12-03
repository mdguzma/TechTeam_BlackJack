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
    
    public void  validPassword(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a password:");
        String password = in.next();
        
        if (checkLength(password)){
            System.out.println("Password is valid");
        }else{
            System.out.println("Password is not valid");
        }
        
    
    }
    public static boolean checkLength(String password){
        
        if(password.length() > 7){
            return true;
        }else{
            return false;}
    }
    
    public static boolean checkUpper(String password){
        for(char c : password.toCharArray()){
            if(Character.isUpperCase(c)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkSpecial(String password){
        String specialChars = "!@#$%^&*()";
        
        for(char s:password.toCharArray()){
            if(specialChars.indexOf(s) !=-1){
                return true;
              }
        }
        return false;
    }
    
}
