package at.htlgkr.hangman;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public static final int START = 0;
    public static final int PVSP = 1;
    public static final int PVSC = 2;
    public static final int GAME = 3;
    public static final int NEWGAME = 4;

    private MutableLiveData<Integer> _state = new MutableLiveData<>(START);
    public LiveData<Integer> state = _state;

    public void showStart() {
        _state.postValue(START);
    }

    public void showPVSP() {
        _state.postValue(PVSP);
    }

    public void showPVSC() {
        _state.postValue(PVSC);
    }

    public void showGame() {
        _state.postValue(GAME);
    }

    public void showNewGame() {
        _state.postValue(NEWGAME);
    }

}
