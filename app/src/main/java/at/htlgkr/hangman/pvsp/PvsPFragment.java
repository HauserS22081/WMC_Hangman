package at.htlgkr.hangman.pvsp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import at.htlgkr.hangman.HangmanViewModel;
import at.htlgkr.hangman.MainViewModel;
import at.htlgkr.hangman.databinding.FragmentPvsPBinding;

public class PvsPFragment extends Fragment {

    private FragmentPvsPBinding binding;

    public PvsPFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPvsPBinding.inflate(inflater, container, false);

        binding.btNext.setOnClickListener(view -> {
            String word = String.valueOf(binding.tiWord.getText());

            if (word.isEmpty()) {
                Snackbar.make(binding.getRoot(), "Bitte Wort eingeben", Snackbar.LENGTH_LONG).show();
                return;
            }

            HangmanViewModel hangmanViewModel = new ViewModelProvider(requireActivity()).get(HangmanViewModel.class);
            hangmanViewModel.setWord(word);

            MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
            viewModel.showGame();
        });

        return binding.getRoot();
    }
}