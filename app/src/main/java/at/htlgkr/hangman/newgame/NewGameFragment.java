package at.htlgkr.hangman.newgame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.hangman.MainViewModel;
import at.htlgkr.hangman.R;
import at.htlgkr.hangman.databinding.FragmentNewGameBinding;

public class NewGameFragment extends Fragment {

    private FragmentNewGameBinding binding;

    public NewGameFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNewGameBinding.inflate(inflater, container, false);

        binding.btNewgame.setOnClickListener(view -> {
            MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

            viewModel.showStart();
        });

        return binding.getRoot();
    }
}