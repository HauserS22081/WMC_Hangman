package at.htlgkr.hangman.pvsc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.hangman.HangmanViewModel;
import at.htlgkr.hangman.MainViewModel;
import at.htlgkr.hangman.databinding.FragmentPvsCBinding;

public class PvsCFragment extends Fragment implements View.OnClickListener {

    private FragmentPvsCBinding binding;

    public PvsCFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPvsCBinding.inflate(inflater, container, false);

        binding.btEasy.setOnClickListener(this);
        binding.btHard.setOnClickListener(this);

        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        HangmanViewModel hangmanViewModel = new ViewModelProvider(requireActivity()).get(HangmanViewModel.class);
        MainViewModel mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        PvsCController controller = new PvsCController();
        String word;
        if (view.equals(binding.btEasy)) {
            word = controller.getGermanWord();
        } else {
            word = controller.getEnglishWord();
        }

        hangmanViewModel.setWord(word);
        mainViewModel.showGame();
    }
}