package at.htlgkr.hangman.start;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.hangman.MainViewModel;
import at.htlgkr.hangman.R;
import at.htlgkr.hangman.databinding.FragmentStartBinding;

public class StartFragment extends Fragment {

    private FragmentStartBinding binding;

    public StartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentStartBinding.inflate(inflater, container, false);

        MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        binding.btPvsp.setOnClickListener(view -> {
            viewModel.showPVSP();
        });

        binding.btPvsc.setOnClickListener(view -> {
            viewModel.showPVSC();
        });

        return binding.getRoot();
    }
}