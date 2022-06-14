package xyz.teamgravity.eventbusdemo.presentation.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import xyz.teamgravity.eventbusdemo.databinding.ActivityMainBinding;
import xyz.teamgravity.eventbusdemo.presentation.viewmodel.main.MainEvent;
import xyz.teamgravity.eventbusdemo.presentation.viewmodel.main.MainViewModel;

public class Main extends AppCompatActivity {

    private ActivityMainBinding binding;

    private MainViewModel viewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
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
        viewmodel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    private void button() {
        onGenerate();
        onSecond();
    }

    private void onGenerate() {
        binding.generateB.setOnClickListener(view -> viewmodel.onGenerate());
    }

    private void onSecond() {
        binding.secondB.setOnClickListener(view -> startActivity(new Intent(this, Second.class)));
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(MainEvent event) {
        binding.generateT.setText(event.getMessage());
    }
}