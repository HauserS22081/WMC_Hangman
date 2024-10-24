package at.htlgkr.hangman;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import at.htlgkr.hangman.databinding.ActivityMainBinding;
import at.htlgkr.hangman.game.GameFragment;
import at.htlgkr.hangman.newgame.NewGameFragment;
import at.htlgkr.hangman.pvsc.PvsCFragment;
import at.htlgkr.hangman.pvsp.PvsPFragment;
import at.htlgkr.hangman.start.StartFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.state.observe(this, state -> {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            switch (state) {
                case MainViewModel.START: {
                    fragmentTransaction.replace(R.id.main, new StartFragment(), "FRAGMENT START");
                    break;
                }

                case MainViewModel.PVSP: {
                    fragmentTransaction.replace(R.id.main, new PvsPFragment(), "FRAGMENT PVSP");
                    fragmentTransaction.addToBackStack("");
                    break;
                }

                case MainViewModel.PVSC: {
                    fragmentTransaction.replace(R.id.main, new PvsCFragment(), "FRAGMENT PVSC");
                    fragmentTransaction.addToBackStack("");
                    break;
                }

                case MainViewModel.GAME: {
                    fragmentTransaction.replace(R.id.main, new GameFragment(), "FRAGMENT GAME");
                    fragmentTransaction.addToBackStack("");
                    break;
                }

                case MainViewModel.NEWGAME: {
                    fragmentTransaction.replace(R.id.main, new NewGameFragment(), "FRAGMENT NEWGAME");
                    fragmentTransaction.addToBackStack("");
                }
            }

            fragmentTransaction.commit();
        });
    }
}