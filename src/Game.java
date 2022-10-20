import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        // The program should randomly choose a word, from a list of words. Then it should show the user a series of
        //underscores that represent the letters of the word.
        //For example, for the word “computer” it should be like:
        // _ _ _ _ _ _ _
        introGame();
    }
    public static void introGame() {
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
        randomWordGen();

    }
    static void randomWordGen() {
        Random Random = new Random();
        String[] cars = {"audi", "fiat", "citroen", "opel","jaguar","lamborghini","ford","lexus","honda"};
        String randomWordCar = cars[Random.nextInt(cars.length)];
        String[] country = {"croatia", "czechia", "slovenia", "poland", "slovakia", "hungary", "france", "germany"};
        String randomWordCountry = country[Random.nextInt(country.length)];
        String[] citiesEU = {"paris", "zagreb", "berlin","prague", "warsaw", "ljubljana", "rome", "venezia"};
        String randomWordCitiesEU = citiesEU[Random.nextInt(citiesEU.length)];
        Scanner scanner = new Scanner(System.in);
        System.out.println("------  Starting a game ------ ");
        System.out.println();
        String randomWord = null;
        System.out.println(" Choose the category : \n" +
                " 1. Cars \n" +
                " 2. Countries in EU \n" +
                " 3. Cities in EU \n");
        int menuOpt = scanner.nextInt();
        if (menuOpt == 1) {
            randomWord = randomWordCar;
        }
        if (menuOpt == 2) {
            randomWord = randomWordCountry;
        }
        if (menuOpt == 3) {
            randomWord = randomWordCitiesEU;
        }
        System.out.println("\t The given word is : ");
        System.out.println();

        // Test line to test the code if the output word is OK
        //System.out.println(randomWord);

        String underscores = randomWord.replaceAll("[a-zA-Z]", "_");
        System.out.print("\t\t\t");
        for (int i = 0; i < underscores.length(); i++) {
            System.out.print(underscores.charAt(i) + " ");
        }
        System.out.println();
        StringBuilder hiddenWord = new StringBuilder(underscores);

        ArrayList<Character> charList = new ArrayList<>();

        int guessCount = 0;
        int guessLimit = hiddenWord.length() - 1;
        System.out.println();
        scanner = new Scanner(System.in);
        while (!hiddenWord.toString().equals(randomWord)) {
            Collections.sort(charList);
            System.out.println("Characters already entered: " + charList);
            System.out.println();
            System.out.print("Enter a letter only : ");
            String userInput = scanner.nextLine();
            System.out.println(userInput);
            userInput = userInput.toLowerCase();
            char a = userInput.charAt(0);
            // adding conditions for this game - if our list of previous attempts does not contain a
            // new letter from user and if user still have remaining attempts then our code is running
            if (!charList.contains(a) && guessCount != guessLimit) {
                charList.add(a);
                boolean isGuessed = false;
                for (int i = 0; i < randomWord.length(); i++) {
                    if (randomWord.charAt(i) == a) {
                        hiddenWord.setCharAt(i, a);
                        isGuessed = true;
                    }
                }

                // just a print where user can see how many attempts he have
                System.out.println("You have left  " + (guessLimit - guessCount) + " attempts.");

                for (int i = 0; i < hiddenWord.length(); i++) {
                    System.out.print(hiddenWord.charAt(i) + " ");
                }
                System.out.println();
                if(!isGuessed)
                    guessCount++;
                System.out.println(hangmanDraw.draw(guessCount));
                // just to test if logic for draw work
                //System.out.println("Guess count value " + guessCount + " ");
                System.out.println();

                // Win situation
                if (hiddenWord.toString().equals(randomWord)) {
                    System.out.println("You win with " + guessCount + " miss");
                    System.out.println(" Want to play again? ( 0 / 1 ) ");
                    int playNext = scanner.nextInt();
                    while (playNext == 1) {
                        randomWordGen();
                    }
                    System.out.println(" Game over . ");
                    System.exit(0);

                }
                // if user try to input the same letter as before it gives him
                // an error and does not count it in attempts
            } else if (charList.contains(a)) {
                System.out.println(" You already entered this letter. Enter a new letter again:");

                // LOSE situation - user has limited attempts and when he is left at 0 attempts , automatically the game is finished
            } else if (guessCount == guessLimit) {
                System.out.println(" Sorry, you LOST.");
                System.out.println(" The word is " + randomWord);

                System.out.println(" Want to play again? ( 0 / 1 ) ");
                int playNext = scanner.nextInt();
                while (playNext == 1) {
                    randomWordGen();

                }
                System.out.println(" Game over . ");
                System.exit(0);

            }
        }
    }
}
