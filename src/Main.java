import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // The program should randomly choose a word, from a list of words. Then it should show the user a series of
        //underscores that represent the letters of the word.
        //For example, for the word “computer” it should be like:
        // _ _ _ _ _ _ _
        String[] list = {"singr", "computer"};
        System.out.print("     _________\n" +
                "     |/      |\n" +
                "     |      \n" +
                "     |          HANGMAN   \n" +
                "     |        LANA PAVIC     \n" +
                "     |    MIHOVIL STAGLICIC  \n" +
                "     |\n" +
                "    _|___");
        System.out.println();
        System.out.println();
        System.out.println("------  Starting a game ------ ");
        System.out.println("\t You have 6 attempts");
        System.out.println("\t The given word is : ");
        System.out.println();


        Random Random = new Random();
        String randomWord = list[Random.nextInt(list.length)];
        // System.out.println("word " + randomWord);
        String underscores = randomWord.replaceAll("[a-zA-Z]", "_");
        System.out.println("\t\t\t" + underscores);
        System.out.println();
        StringBuilder hiddenWord = new StringBuilder(underscores);
        ArrayList<Character> charList = new ArrayList<>();

        int guessCount = 0;
        int guessLimit = 6;
        System.out.println("\tEnter a letter only : ");
        Scanner scanner = new Scanner(System.in);
        //char usersGuess = scanner.next().charAt(0);
        while (!hiddenWord.toString().equals(randomWord)) {
            String userInput = scanner.nextLine();
            userInput = userInput.toLowerCase();
            char a = userInput.charAt(0);

            if (!charList.contains(a) && guessCount != guessLimit) {
                for (int i = 0; i < randomWord.length(); i++) {
                    if (randomWord.charAt(i) == a) {
                        hiddenWord.setCharAt(i, a);

                    }
                    charList.add(a);
                }
                System.out.println("You have left  " + (guessLimit - guessCount) + " attempts.");
                //System.out.println("YOU WIN ! ");
                System.out.println(hiddenWord);
                guessCount++;
            } else if (charList.contains(a)) {
                System.out.println(" You already entered this letter. Enter a new letter again:");
            } else if (guessCount == guessLimit) {
                System.out.println(" Sorry, you LOST.");
                System.out.println(" The word is " + randomWord);
            } else if (randomWord == hiddenWord.toString()) {
                System.out.println(" You win");
            }
        }
    }
}
       /* int guessCount = 0;
        int guessLimit = 6; // head,body,left arm,right arm,left leg and right leg
        boolean outOfGuesses = false;
        System.out.println(" Word" + guess);
    }
}
            /*word = input.nextLine();
            while(!guess.equals(word) && !outOfGuesses){
                if(guessCount < guessLimit){
                    System.out.print(" Enter a char: \n");
                    guess = input.nextLine();
                    guessCount++;
                } else {
                    outOfGuesses = true;
                }
            }

            if(outOfGuesses){
                System.out.println("You Lose! \n"
                        + "_____________\n"
                        +" Hidden word was : \n" + word
                        + "\n End of game!");
            } else {
                System.out.println("You Win! \n"
                        + "______________\n"
                        + "End of game ! ");
            }
        }
    }

             */