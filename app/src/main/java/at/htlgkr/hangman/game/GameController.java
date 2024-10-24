package at.htlgkr.hangman.game;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final char PLACEHOLDER = '_';
    private final List<Character> letters;
    private List<Character> currentLetters;

    public GameController(String word) {
        this.letters = arrToList(word.toCharArray());
        currentLetters = new ArrayList<>();
        initializeCurrentLetters(letters.size());
    }

    public boolean play(char playedLetter) {
        if(!letters.contains(playedLetter)) return false;

        List<Integer> indices = getIndices(playedLetter);

        updateCurrentLetters(indices, playedLetter);

        return true;
    }

    public String getCurrentString() {
        String currentString = "";
        for (Character letter : currentLetters) {
            currentString += letter;
        }
        return currentString;
    }

    public boolean hasWon() {
        for (Character letter : currentLetters) {
            if(letter.equals(PLACEHOLDER)) return false;
        }

        return true;
    }

    private boolean equalsIgnoreUpperCase(Character letter, char letter2) {
        return String.valueOf(letter).equalsIgnoreCase(String.valueOf(letter2));
    }

    private void updateCurrentLetters(List<Integer> indices, char playedLetter) {
        for (int i = 0; i < indices.size(); i++) {
            currentLetters.set(indices.get(i), playedLetter);
        }
    }

    private List<Integer> getIndices(char playedLetter) {
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < letters.size(); i++) {
            if (equalsIgnoreUpperCase(playedLetter, letters.get(i))) indices.add(i);
        }

        return indices;
    }

    private void initializeCurrentLetters(int size) {
        for (int i = 0; i < size; i++) {
            currentLetters.add(PLACEHOLDER);
        }
    }

    private List<Character> arrToList(char[] arr) {
        List<Character> list = new ArrayList<>();

        for (char letter : arr) {
            list.add(letter);
        }

        return list;

    }
}
