package com.company;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner myScan = new Scanner(System.in);

        ArrayList<String> words = new ArrayList<>(Arrays.asList("eskimo", "trumpet", "element", "painting", "curtain", "shelves",
                                                    "toilet", "computer", "pen", "mouse", "stupid", "sheep", "keyboard",
                                                    "awesome", "light", "adventure", "crazy", "pillow", "insane", "shirt"));

        ArrayList<String> charsUsed = new ArrayList<>();

        String hangManWord = words.get((int)(Math.random() * words.size()));

        System.out.println("Welcome to HangMan.");
        System.out.println("You get 6 lives.");
        System.out.println("Your word has " + hangManWord.length() + " characters.");
        System.out.println("Start guessing!");

        boolean breakLoop = false;
        int livesUsed = 0;

        while(livesUsed < 6 && !breakLoop){
            System.out.println("\n" + generateString(charsUsed, hangManWord) + "\n");
            System.out.println("What letter do you guess?");
            String userInput = myScan.nextLine().toLowerCase();

            if(userInput.length() != 1){
                System.out.println("Invalid. Try again.");
            }

            if(charsUsed.contains(userInput)){
                System.out.println("You already used that character. Try again.");
            }

            else if(hangManWord.indexOf(userInput) != -1){
                charsUsed.add(userInput);
                System.out.println("Yay! You guessed the character correct!");
            }

            else{
                charsUsed.add(userInput);
                livesUsed++;
                System.out.println("Sorry, that character is not in the word.");
                System.out.println("You have " + (6 - livesUsed) + " lives left.");
            }

            if(generateString(charsUsed, hangManWord).indexOf("_") == -1){
                breakLoop = true;
            }
        }

        if(livesUsed == 6){
            System.out.println("Oh no! You used all your lives. The word was '" + hangManWord + "'.");
        }

        else{
            System.out.println("You won! The word is '" + hangManWord + "'.");
        }

    }

    public static String generateString(ArrayList<String> charsUsed, String hangManWord){
        String returnVal = "";

        for(int i = 0; i < hangManWord.length(); i++){
            if(charsUsed.contains(hangManWord.substring(i, i+1))){
                returnVal += hangManWord.charAt(i) + " ";
            } else{
                returnVal += "_ ";
            }
        }

        return returnVal;
    }

}
