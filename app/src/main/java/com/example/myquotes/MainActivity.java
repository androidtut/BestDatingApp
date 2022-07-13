package com.example.myquotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.myquotes.Models.SharyModels;
import com.example.myquotes.databinding.ActivityMainBinding;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
TextView text;
LottieAnimationView animationView;
private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        text = findViewById(R.id.textss);
        setSupportActionBar(binding.toolbar);
        binding.toolbar.setTitle("Sharyari App");

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


//        animationView = findViewById(R.id.images);
//        animationView.setVisibility(View.VISIBLE);

//        text.setBackgroundColor(Color.BLUE);

//        text.setOnClickListener(v->{
////            set animation after button click
//          animationView.setVisibility(View.VISIBLE);
//          Intent intent = new Intent(this,sharyActivity.class);
//          startActivity(intent);
//        });

        binding.card1.setOnClickListener(this);
        binding.card7.setOnClickListener(this);
        binding.card4.setOnClickListener(this);
        binding.card8.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,sharyActivity.class);
        switch(v.getId()){
            case R.id.card1:
                 intent.putExtra("id",1);
                startActivity(intent);
                 break;
            case R.id.card7:
                intent.putExtra("id",2);
                startActivity(intent);
                break;
            case R.id.card4:
                intent.putExtra("id",3);
                startActivity(intent);
                break;
            case R.id.card8:
                intent.putExtra("id",5);
                startActivity(intent);
                break;
//            default:
//                intent.putExtra("id",1);
//                startActivity(intent);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.share:
                share();
                break;
            case R.id.exits:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void share(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,"Hello world");
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit this app")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       finish();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();

        super.onBackPressed();
    }
}