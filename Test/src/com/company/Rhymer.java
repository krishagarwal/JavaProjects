package com.company;

import java.util.Scanner;

public class Rhymer {

    static void playGame(){
        Scanner sc = new Scanner(System.in);
        String word = "test";
        int score = 0;

        StringBuilder sb = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
        sb.deleteCharAt(sb.indexOf((word.charAt(0) + "").toUpperCase()));
        sb.deleteCharAt(sb.indexOf((word.charAt(0) + "").toLowerCase()));


        while (true) {
            System.out.printf("Enter a word %d letter word that rhymes with '%s' or 'e' to exit.%n", word.length(), word);
            String input = sc.nextLine();

            if (input.equals("e")) {
                break;
            }

            if (input.matches("[" + sb.toString() + "]" + word.substring(1))) {
                System.out.println("Yay you got to point!");
                score++;
                sb.deleteCharAt(sb.indexOf((input.charAt(0) + "").toUpperCase()));
                sb.deleteCharAt(sb.indexOf((input.charAt(0) + "").toLowerCase()));
            } else {
                System.out.println("You lose...");
                break;
            }
        }

        System.out.printf("You scored %d points!%n", score);
    }

}
