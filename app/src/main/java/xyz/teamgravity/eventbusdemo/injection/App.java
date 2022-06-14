package xyz.teamgravity.eventbusdemo.injection;

import android.app.Application;

import org.greenrobot.eventbus.EventBus;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.builder().addIndex(new EventBusIndex()).installDefaultEventBus();
    }
}
