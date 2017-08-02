import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Guest on 8/2/17.
 */
public class App {
    public static void main(String[] args) {

        Hangman newGame = new Hangman();
        System.out.println("Welcome to Hangman Game! Let's Play");
        String blank = newGame.displayUnderscore();
        System.out.println("Look, here is what you need to guess: " + blank);
        System.out.println("Guess a letter to complete the word and win the game.");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (!newGame.wordGuessed(blank)) {

                System.out.println("Guess a letter: ");
                String inputLetter = bufferedReader.readLine();

                blank = newGame.replaceUnderscoreWithLetter(inputLetter, blank);

                System.out.println(blank + "          " + newGame.addUserGuessToArray(inputLetter));


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
