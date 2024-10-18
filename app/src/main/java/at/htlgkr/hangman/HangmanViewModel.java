package at.htlgkr.hangman;

import androidx.lifecycle.ViewModel;

public class HangmanViewModel extends ViewModel {
    private String word;

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
