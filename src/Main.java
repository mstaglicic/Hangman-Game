import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // The program should randomly choose a word, from a list of words. Then it should show the user a series of
        //underscores that represent the letters of the word.
        //For example, for the word “computer” it should be like:
        // _ _ _ _ _ _ _
        String[] list = {"potato", "estate", "energy", "length", "java", "system", "effort", 
                         "wealth", "nation", "police", "family", "sister", "church", "worker", "studio", 
                         "dinner", "player", "singer", "farmer"};
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
        // System.out.println("word " + randomWord); this line for testing the previous code if it is working
        String underscores = randomWord.replaceAll("[a-zA-Z]", "_");
        System.out.println("\t\t\t" + underscores);
        System.out.println();
        StringBuilder hiddenWord = new StringBuilder(underscores);
        ArrayList<Character> charList = new ArrayList<>();

        int guessCount = 0;
        int guessLimit = 5;
        System.out.println("\tEnter a letter only : ");
        Scanner scanner = new Scanner(System.in);
        while (!hiddenWord.toString().equals(randomWord)) {
            String userInput = scanner.nextLine();
            userInput = userInput.toLowerCase();
            char a = userInput.charAt(0);

            // adding conditions for this game - if our list of previous attempts does not contain a
            // new letter from user and if user still have remaining attempts then our code is running
            if (!charList.contains(a) && guessCount != guessLimit) {
                for (int i = 0; i < randomWord.length(); i++) {
                    if (randomWord.charAt(i) == a) {
                        hiddenWord.setCharAt(i, a);

                    }
                    charList.add(a);
                }
                // just a print where user can see how many attempts he have
                System.out.println("You have left  " + (guessLimit - guessCount) + " attempts.");
                System.out.println(hiddenWord);
                System.out.println();

                guessCount++;

                // try to complete a loop for when user win , in other words when randomWord is equal to
                // hiddenWord
                if (hiddenWord.toString().equals(randomWord)) {
                    System.out.println("You win in " + guessCount + " attempts");
                }
                // in this line we should call a class Draw which has draws of all cases - NOT DONE YET

                // next line is about condition if user try to input the same letter as before it gives him
                // an error and does not count it in attempts
            } else if (charList.contains(a)) {
                System.out.println(" You already entered this letter. Enter a new letter again:");

                // user has six attempts and when he is left at 0 attempts , automatically the game is finished
            } else if (guessCount == guessLimit) {
                System.out.println(" Sorry, you LOST.");
                System.out.println(" The word is " + randomWord);
            }
        }
    }
}
