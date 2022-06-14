package xyz.teamgravity.eventbusdemo.presentation.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import xyz.teamgravity.eventbusdemo.databinding.ActivitySecondBinding;
import xyz.teamgravity.eventbusdemo.presentation.viewmodel.main.MainEvent;
import xyz.teamgravity.eventbusdemo.presentation.viewmodel.second.SecondViewModel;

public class Second extends AppCompatActivity {

    private ActivitySecondBinding binding;

    private SecondViewModel viewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        lateInIt();
        button();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private void lateInIt() {
        viewmodel = new ViewModelProvider(this).get(SecondViewModel.class);
    }

    private void button() {
        onGenerate();
    }

    private void onGenerate() {
        binding.generateB.setOnClickListener(view -> viewmodel.onGenerate());
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(MainEvent event) {
        binding.generateT.setText(event.getMessage());
    }
}