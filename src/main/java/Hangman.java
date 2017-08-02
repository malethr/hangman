import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Guest on 8/2/17.
 */
public class Hangman {
    private int numberOfWrongGueses;
    private String[] playWords = {"apple", "orange", "banana", "kiwi"};
    private String answer;
    public String underscoredAnswer;
    private ArrayList<String> guessedLetters = new ArrayList<>();


    public Hangman() {
        answer = chooseRandomWord();
        underscoredAnswer = displayUnderscore();
        System.out.println(answer);
        numberOfWrongGueses = 0;

    }

    public String getAnswer() {
        return answer;
    }


    public String chooseRandomWord() {
        Random random = new Random();
        int num = random.nextInt(playWords.length);
        return playWords[num];
    }

     private ArrayList<Integer> isPresent(String letter) {
        ArrayList<Integer> answerIndex = new ArrayList<>();
        Integer index = answer.indexOf(letter);
        while (index >= 0) {
            answerIndex.add(index);
            index = answer.indexOf(letter, index+1);
          }
          return answerIndex;
        }


    public ArrayList<String> addUserGuessToArray(String letter) {
        if (!guessedLetters.contains(letter)) {
            guessedLetters.add(letter);
        }
        return guessedLetters;
    }

    public String displayUnderscore(){
        String underscore = "";
        int length = answer.length();
        for (int i = 0; i < length; i++){
            underscore = underscore.concat("_");
        }
        return underscore;
    }

    public String replaceUnderscoreWithLetter(String letter, String underscore) {
        ArrayList<Integer> answerIndex = isPresent(letter);
        StringBuilder currentAnswer = new StringBuilder(underscore);
        if (!answerIndex.isEmpty()) {
            if (!underscore.equals(answer)) {

                for (int i = 0; i < answerIndex.size(); i++) {
                    int currentPosition = answerIndex.get(i);
                    char currentLetter = answer.charAt(currentPosition);
                    currentAnswer.setCharAt(currentPosition, currentLetter);
                }
            }
//            else {
//                System.out.println("The letter you entered is not present in the word. Try again");
//            }
        }
//        else {
//            System.out.println("The letter you entered is not present in the word. Try again");
//        }
        return currentAnswer.toString();
    }

    public boolean wordGuessed(String blank) {
        if (blank.equals(getAnswer())) {
            System.out.println("Hurray! The word is guessed");
            return true;
        }
        return false;
    }


}
