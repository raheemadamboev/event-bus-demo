package xyz.teamgravity.eventbusdemo.presentation.viewmodel.main;

import androidx.lifecycle.ViewModel;

import org.greenrobot.eventbus.EventBus;

import java.util.Random;

import xyz.teamgravity.eventbusdemo.presentation.viewmodel.main.MainEvent;

public class MainViewModel extends ViewModel {

    private final Random random;

    public MainViewModel() {
        random = new Random();
    }

    public void onGenerate() {
        EventBus.getDefault().postSticky(new MainEvent(String.valueOf(random.nextInt(999999))));
    }
}
