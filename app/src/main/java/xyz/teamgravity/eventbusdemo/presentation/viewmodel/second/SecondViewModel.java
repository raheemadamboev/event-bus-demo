package xyz.teamgravity.eventbusdemo.presentation.viewmodel.second;

import androidx.lifecycle.ViewModel;

import org.greenrobot.eventbus.EventBus;

import java.util.Random;

import xyz.teamgravity.eventbusdemo.presentation.viewmodel.main.MainEvent;

public class SecondViewModel extends ViewModel {

    private final Random random;

    public SecondViewModel() {
        random = new Random();
    }

    public void onGenerate() {
        EventBus.getDefault().postSticky(new MainEvent(String.valueOf(random.nextInt(999999))));
    }

    public void onWait() {
        EventBus.getDefault().post(new SecondEvent("Finally, have been waiting long!"));
    }
}
