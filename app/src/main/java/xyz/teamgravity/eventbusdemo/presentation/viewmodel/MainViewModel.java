package xyz.teamgravity.eventbusdemo.presentation.viewmodel;

import androidx.lifecycle.ViewModel;

import org.greenrobot.eventbus.EventBus;

import java.util.Random;

public class MainViewModel extends ViewModel {

    private final Random random;

    public MainViewModel() {
        random = new Random();
    }

    public void onGenerate() {
        EventBus.getDefault().post(new MainEvent(String.valueOf(random.nextInt(999999))));
    }
}
