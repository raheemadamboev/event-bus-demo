package xyz.teamgravity.eventbusdemo.presentation.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import xyz.teamgravity.eventbusdemo.databinding.ActivityMainBinding;
import xyz.teamgravity.eventbusdemo.presentation.viewmodel.MainViewModel;

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

    private void lateInIt() {
        viewmodel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    private void button() {
        onGenerate();
    }

    private void onGenerate() {
        binding.generateB.setOnClickListener(view -> {
            viewmodel.onGenerate();
        });
    }
}