/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j.s.p0008;

/**
 *
 * @author ngnqu
 */
import java.util.Scanner;

public class JSP0008 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        int letterCount = 0;
        int characterCount = 0;

        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (Character.isLetter(c)) {
                letterCount++;
            }
            characterCount++;
        }

        System.out.println("Number of letters: " + letterCount);
        System.out.println("Number of characters: " + characterCount);

        scanner.close();
    }
}