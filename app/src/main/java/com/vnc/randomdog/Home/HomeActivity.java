package com.vnc.randomdog.Home;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.bumptech.glide.Glide;
import com.vnc.randomdog.databinding.ActivityHomeBinding;


public class HomeActivity extends AppCompatActivity implements HomeLogic.HomeEvent {

    private ActivityHomeBinding binding;

    HomeLogic homeLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        homeLogic = new HomeLogic(this,this);
        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeLogic.callApi();
            }
        });

    }


    @Override
    public void onShowImageSuccess(String message) {
                Glide.with(HomeActivity.this)
                        .load(message) // image url
                        .centerCrop()
                        .into(binding.image);
    }

    @Override
    public void onShowImageFail() {

    }
}