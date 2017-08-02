import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/2/17.
 */
public class HangmanTest {

    @Test
    public void newHangman_instantiatesCorrectly() {
        Hangman hangman = new Hangman();
        assertEquals(true, hangman instanceof Hangman);
    }

    @Test
    public void newHangman_getsAnswer_apple() {
        Hangman hangman = new Hangman();
        assertEquals("apple", hangman.getAnswer());
    }

//    @Test
//    public void newHangman_getGuessedLetters_ape() {
//        ArrayList<Character> expectedArray = new ArrayList<>();
//        expectedArray.add('a');
//        expectedArray.add('e');
//        expectedArray.add('c');
//        Hangman hangman = new Hangman("apple", expectedArray);
//        assertEquals(expectedArray, hangman.getGuessedLetters());
//    }
//
    @Test
    public void newHangman_chooseRandomWordFromArrayOfWords_true() {
        Hangman hangman = new Hangman();
        String chosenWords = hangman.chooseRandomWord();
        assertEquals(true, chosenWords instanceof String);
    }

    @Test
    public void isPresent_checkifLettersPresentIsPresent_true(){
        Hangman hangman = new Hangman();
        ArrayList<Integer> expectedArray = new ArrayList<>();
        Integer num = 0;
        expectedArray.add(num);
        assertEquals(expectedArray, hangman.isPresent("a"));
    }

    @Test
    public void isPresent_checkifLettersPresentIsNotPresent_true(){
        Hangman hangman = new Hangman("apple");
        ArrayList<Integer> expectedArray = new ArrayList<>();
        assertEquals(expectedArray, hangman.isPresent("m"));
    }

    @Test
    public void addUserGuessToArray_addUserGuessToArrrayIfNotPresent_returnM() {
        Hangman hangman = new Hangman();
        ArrayList<String> expectedArray = new ArrayList<>();
        expectedArray.add("m");
        assertEquals(expectedArray,hangman.addUserGuessToArray("m"));
    }
    @Test
    public void addUserGuessToArray_addUserGuessToArrrayIfPresent_returnArrayWithoutA() {
        Hangman hangman = new Hangman();
        ArrayList<String> expectedArray = new ArrayList<>();
        expectedArray.add("m");
        assertEquals(expectedArray,hangman.addUserGuessToArray("m"));
    }

    @Test
    public void displayUnderscore_checkLengthToReplaceUnderscore_3underscore(){
        Hangman hangman = new Hangman();
        assertEquals("_ _ _ ", hangman.displayUnderscore());
    }

    @Test
    public void replaceUnderscoreWithLetter_whenGuessedLetterIsPresentInPlayWords_c__(){
        Hangman hangman = new Hangman ("cat");
        assertEquals("c__", hangman.replaceUnderscoreWithLetter("c"));
    }

    @Test
    public void replaceUnderscoreWithLetter_whenGuessedLetterIsNotPresentInPlayWords_cat(){
        Hangman hangman = new Hangman ("cat");
        assertEquals("___", hangman.replaceUnderscoreWithLetter("x"));
    }

}