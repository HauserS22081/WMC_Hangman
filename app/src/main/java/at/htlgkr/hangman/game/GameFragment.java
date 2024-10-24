package at.htlgkr.hangman.game;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import at.htlgkr.hangman.HangmanViewModel;
import at.htlgkr.hangman.MainViewModel;
import at.htlgkr.hangman.R;
import at.htlgkr.hangman.databinding.FragmentGameBinding;

public class GameFragment extends Fragment implements View.OnClickListener {

    private FragmentGameBinding binding;
    private GameController controller;
    private int currentImage;
    private List<Integer> images;

    public GameFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentGameBinding.inflate(inflater, container, false);

        HangmanViewModel hangmanViewModel = new ViewModelProvider(requireActivity()).get(HangmanViewModel.class);

        images = new ArrayList<>();
        controller = new GameController(hangmanViewModel.getWord());
        binding.btGuess.setOnClickListener(this);
        setImages();

        currentImage = images.get(0);
        binding.ivImage.setImageResource(currentImage);
        binding.tvWord.setText(controller.getCurrentString());

        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {

        String letterString = String.valueOf(binding.tiWord.getText());

        if (letterString.length() != 1) {
            Snackbar.make(binding.getRoot(), "Bitte validen Buchstaben eingeben", Snackbar.LENGTH_LONG).show();
            return;
        }

        char letter = letterString.charAt(0);

        boolean isRight = controller.play(letter);

        if (!isRight) switchImages();

        binding.tvWord.setText(controller.getCurrentString());

        if (controller.hasWon()) {
            Snackbar.make(binding.getRoot(), "Gewonnen", Snackbar.LENGTH_SHORT).show();
            returnToStart();
        }
    }

    private void switchImages() {
        if (currentImage == images.get(images.size() - 1)) {
            Snackbar.make(binding.getRoot(), "Verloren", Snackbar.LENGTH_SHORT).show();
            returnToStart();
            return;
        }
        int nextImage = images.get(images.indexOf(currentImage) + 1);
        binding.ivImage.setImageResource(nextImage);
        currentImage = nextImage;
    }

    private void returnToStart() {
        MainViewModel mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        mainViewModel.showNewGame();
    }

    private void setImages() {
        images.add(R.drawable.p1);
        images.add(R.drawable.p2);
        images.add(R.drawable.p3);
        images.add(R.drawable.p4);
        images.add(R.drawable.p5);
        images.add(R.drawable.p6);
        images.add(R.drawable.p7);
        images.add(R.drawable.p8);
        images.add(R.drawable.p9);
        images.add(R.drawable.p10);
        images.add(R.drawable.p11);
        images.add(R.drawable.p12);
    }
}