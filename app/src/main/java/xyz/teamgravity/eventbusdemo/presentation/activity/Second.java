package xyz.teamgravity.eventbusdemo.presentation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import xyz.teamgravity.eventbusdemo.databinding.ActivitySecondBinding;

public class Second extends AppCompatActivity {

    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}