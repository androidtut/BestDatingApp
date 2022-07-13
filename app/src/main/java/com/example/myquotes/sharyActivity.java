package com.example.myquotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.myquotes.Adapters.SharyAdapters;
import com.example.myquotes.Models.SharyModels;
import com.example.myquotes.databinding.ActivitySharyBinding;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.ArrayList;

public class sharyActivity extends AppCompatActivity {
 private ArrayList<SharyModels>list;
 private ActivitySharyBinding binding;
 private InterstitialAd mInterstitialAd;
 private int ids;
 private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySharyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();
        loadfullAds();

        Intent intent = getIntent();
        ids = intent.getIntExtra("id",1);

        if(ids == 1){
            initList1();
            initList5();
        }else if(ids == 2){
            initList2();
        }else if(ids == 3){
            initList3();
        }else if(ids == 4){
            initList4();
        }

        LoadBannersAds();

        SharyAdapters adapter = new SharyAdapters(list,this);
        binding.sharyRecycler.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.sharyRecycler.setLayoutManager(linearLayoutManager);

    }


    private void loadfullAds(){
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        mInterstitialAd = null;
                    }
                });

        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(sharyActivity.this);
                } else {
                    Toast.makeText(sharyActivity.this, "Load", Toast.LENGTH_SHORT).show();
                }
                handler.postDelayed(this,1000);
            }
        };

        handler.post(runnable);
    }


    private void LoadBannersAds(){
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }


    private void initList1() {
        list.add(new SharyModels("what melody I compose\n" +
                "for my beloved valentine.\n" +
                "It was just quiet\n" +
                "until you came and\n" +
                "touched the strings of my heart .."));
        list.add(new SharyModels("mesmerized by your charisma\n" +
                "and spellbound by your love .\n" +
                "No wonder I am always thinking about you.\n" +
                "I wish to celebrate every Valentine with you.\n" +
                "Happy Valentine's Day.."));
        list.add(new SharyModels("On Valentine's Day,\n" +
                "I'm thinking about\n" +
                "the special ways\n" +
                "you have made my life better.\n" +
                "The little things,\n" +
                "the not-so-little things...\n" +
                "Your kindness,\n" +
                "the way you always listen\n" +
                "and pay attention to me.\n" +
                "You make my world\n" +
                "brighter and richer.\n" +
                "You're a gift to me,\n" +
                "and I thank you\n" +
                "for being you."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("The arc of my life\n" +
                "can only become circle\n" +
                "when a Special Someone like you\n" +
                "will be my Valentine.."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("mesmerized by your charisma\n" +
                "and spellbound by your love .\n" +
                "No wonder I am always thinking about you.\n" +
                "I wish to celebrate every Valentine with you.\n" +
                "Happy Valentine's Day.."));
        list.add(new SharyModels("On Valentine's Day,\n" +
                "I'm thinking about\n" +
                "the special ways\n" +
                "you have made my life better.\n" +
                "The little things,\n" +
                "the not-so-little things...\n" +
                "Your kindness,\n" +
                "the way you always listen\n" +
                "and pay attention to me.\n" +
                "You make my world\n" +
                "brighter and richer.\n" +
                "You're a gift to me,\n" +
                "and I thank you\n" +
                "for being you."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("The arc of my life\n" +
                "can only become circle\n" +
                "when a Special Someone like you\n" +
                "will be my Valentine.."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("mesmerized by your charisma\n" +
                "and spellbound by your love .\n" +
                "No wonder I am always thinking about you.\n" +
                "I wish to celebrate every Valentine with you.\n" +
                "Happy Valentine's Day.."));
        list.add(new SharyModels("On Valentine's Day,\n" +
                "I'm thinking about\n" +
                "the special ways\n" +
                "you have made my life better.\n" +
                "The little things,\n" +
                "the not-so-little things...\n" +
                "Your kindness,\n" +
                "the way you always listen\n" +
                "and pay attention to me.\n" +
                "You make my world\n" +
                "brighter and richer.\n" +
                "You're a gift to me,\n" +
                "and I thank you\n" +
                "for being you."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("The arc of my life\n" +
                "can only become circle\n" +
                "when a Special Someone like you\n" +
                "will be my Valentine.."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("mesmerized by your charisma\n" +
                "and spellbound by your love .\n" +
                "No wonder I am always thinking about you.\n" +
                "I wish to celebrate every Valentine with you.\n" +
                "Happy Valentine's Day.."));
        list.add(new SharyModels("On Valentine's Day,\n" +
                "I'm thinking about\n" +
                "the special ways\n" +
                "you have made my life better.\n" +
                "The little things,\n" +
                "the not-so-little things...\n" +
                "Your kindness,\n" +
                "the way you always listen\n" +
                "and pay attention to me.\n" +
                "You make my world\n" +
                "brighter and richer.\n" +
                "You're a gift to me,\n" +
                "and I thank you\n" +
                "for being you."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("The arc of my life\n" +
                "can only become circle\n" +
                "when a Special Someone like you\n" +
                "will be my Valentine.."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("mesmerized by your charisma\n" +
                "and spellbound by your love .\n" +
                "No wonder I am always thinking about you.\n" +
                "I wish to celebrate every Valentine with you.\n" +
                "Happy Valentine's Day.."));
        list.add(new SharyModels("On Valentine's Day,\n" +
                "I'm thinking about\n" +
                "the special ways\n" +
                "you have made my life better.\n" +
                "The little things,\n" +
                "the not-so-little things...\n" +
                "Your kindness,\n" +
                "the way you always listen\n" +
                "and pay attention to me.\n" +
                "You make my world\n" +
                "brighter and richer.\n" +
                "You're a gift to me,\n" +
                "and I thank you\n" +
                "for being you."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("The arc of my life\n" +
                "can only become circle\n" +
                "when a Special Someone like you\n" +
                "will be my Valentine.."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("mesmerized by your charisma\n" +
                "and spellbound by your love .\n" +
                "No wonder I am always thinking about you.\n" +
                "I wish to celebrate every Valentine with you.\n" +
                "Happy Valentine's Day.."));
        list.add(new SharyModels("On Valentine's Day,\n" +
                "I'm thinking about\n" +
                "the special ways\n" +
                "you have made my life better.\n" +
                "The little things,\n" +
                "the not-so-little things...\n" +
                "Your kindness,\n" +
                "the way you always listen\n" +
                "and pay attention to me.\n" +
                "You make my world\n" +
                "brighter and richer.\n" +
                "You're a gift to me,\n" +
                "and I thank you\n" +
                "for being you."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("The arc of my life\n" +
                "can only become circle\n" +
                "when a Special Someone like you\n" +
                "will be my Valentine.."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        }

    private void initList2() {
        list.add(new SharyModels("but kept in the hearts of others,\n" +
                "from dusk to dawn.\n" +
                "Love you from the core of my heart .\n" +
                "Wanna Be Your Valentine 4ever.."));
        list.add(new SharyModels("mesmerized by your charisma\n" +
                "and spellbound by your love .\n" +
                "No wonder I am always thinking about you.\n" +
                "I wish to celebrate every Valentine with you.\n" +
                "Happy Valentine's Day.."));
        list.add(new SharyModels("On Valentine's Day,\n" +
                "I'm thinking about\n" +
                "the special ways\n" +
                "you have made my life better.\n" +
                "The little things,\n" +
                "the not-so-little things...\n" +
                "Your kindness,\n" +
                "the way you always listen\n" +
                "and pay attention to me.\n" +
                "You make my world\n" +
                "brighter and richer.\n" +
                "You're a gift to me,\n" +
                "and I thank you\n" +
                "for being you."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("The arc of my life\n" +
                "can only become circle\n" +
                "when a Special Someone like you\n" +
                "will be my Valentine.."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("mesmerized by your charisma\n" +
                "and spellbound by your love .\n" +
                "No wonder I am always thinking about you.\n" +
                "I wish to celebrate every Valentine with you.\n" +
                "Happy Valentine's Day.."));
        list.add(new SharyModels("On Valentine's Day,\n" +
                "I'm thinking about\n" +
                "the special ways\n" +
                "you have made my life better.\n" +
                "The little things,\n" +
                "the not-so-little things...\n" +
                "Your kindness,\n" +
                "the way you always listen\n" +
                "and pay attention to me.\n" +
                "You make my world\n" +
                "brighter and richer.\n" +
                "You're a gift to me,\n" +
                "and I thank you\n" +
                "for being you."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("The arc of my life\n" +
                "can only become circle\n" +
                "when a Special Someone like you\n" +
                "will be my Valentine.."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
    }

    private void initList3() {
        list.add(new SharyModels("mesmerized by your charisma\n" +
                "and spellbound by your love .\n" +
                "No wonder I am always thinking about you.\n" +
                "I wish to celebrate every Valentine with you.\n" +
                "Happy Valentine's Day.."));
        list.add(new SharyModels("On Valentine's Day,\n" +
                "I'm thinking about\n" +
                "the special ways\n" +
                "you have made my life better.\n" +
                "The little things,\n" +
                "the not-so-little things...\n" +
                "Your kindness,\n" +
                "the way you always listen\n" +
                "and pay attention to me.\n" +
                "You make my world\n" +
                "brighter and richer.\n" +
                "You're a gift to me,\n" +
                "and I thank you\n" +
                "for being you."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("The arc of my life\n" +
                "can only become circle\n" +
                "when a Special Someone like you\n" +
                "will be my Valentine.."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("mesmerized by your charisma\n" +
                "and spellbound by your love .\n" +
                "No wonder I am always thinking about you.\n" +
                "I wish to celebrate every Valentine with you.\n" +
                "Happy Valentine's Day.."));
        list.add(new SharyModels("On Valentine's Day,\n" +
                "I'm thinking about\n" +
                "the special ways\n" +
                "you have made my life better.\n" +
                "The little things,\n" +
                "the not-so-little things...\n" +
                "Your kindness,\n" +
                "the way you always listen\n" +
                "and pay attention to me.\n" +
                "You make my world\n" +
                "brighter and richer.\n" +
                "You're a gift to me,\n" +
                "and I thank you\n" +
                "for being you."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("The arc of my life\n" +
                "can only become circle\n" +
                "when a Special Someone like you\n" +
                "will be my Valentine.."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("mesmerized by your charisma\n" +
                "and spellbound by your love .\n" +
                "No wonder I am always thinking about you.\n" +
                "I wish to celebrate every Valentine with you.\n" +
                "Happy Valentine's Day.."));
        list.add(new SharyModels("On Valentine's Day,\n" +
                "I'm thinking about\n" +
                "the special ways\n" +
                "you have made my life better.\n" +
                "The little things,\n" +
                "the not-so-little things...\n" +
                "Your kindness,\n" +
                "the way you always listen\n" +
                "and pay attention to me.\n" +
                "You make my world\n" +
                "brighter and richer.\n" +
                "You're a gift to me,\n" +
                "and I thank you\n" +
                "for being you."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("The arc of my life\n" +
                "can only become circle\n" +
                "when a Special Someone like you\n" +
                "will be my Valentine.."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
    }

    private void initList4() {
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("mesmerized by your charisma\n" +
                "and spellbound by your love .\n" +
                "No wonder I am always thinking about you.\n" +
                "I wish to celebrate every Valentine with you.\n" +
                "Happy Valentine's Day.."));
        list.add(new SharyModels("On Valentine's Day,\n" +
                "I'm thinking about\n" +
                "the special ways\n" +
                "you have made my life better.\n" +
                "The little things,\n" +
                "the not-so-little things...\n" +
                "Your kindness,\n" +
                "the way you always listen\n" +
                "and pay attention to me.\n" +
                "You make my world\n" +
                "brighter and richer.\n" +
                "You're a gift to me,\n" +
                "and I thank you\n" +
                "for being you."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("The arc of my life\n" +
                "can only become circle\n" +
                "when a Special Someone like you\n" +
                "will be my Valentine.."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("mesmerized by your charisma\n" +
                "and spellbound by your love .\n" +
                "No wonder I am always thinking about you.\n" +
                "I wish to celebrate every Valentine with you.\n" +
                "Happy Valentine's Day.."));
        list.add(new SharyModels("On Valentine's Day,\n" +
                "I'm thinking about\n" +
                "the special ways\n" +
                "you have made my life better.\n" +
                "The little things,\n" +
                "the not-so-little things...\n" +
                "Your kindness,\n" +
                "the way you always listen\n" +
                "and pay attention to me.\n" +
                "You make my world\n" +
                "brighter and richer.\n" +
                "You're a gift to me,\n" +
                "and I thank you\n" +
                "for being you."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("The arc of my life\n" +
                "can only become circle\n" +
                "when a Special Someone like you\n" +
                "will be my Valentine.."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("mesmerized by your charisma\n" +
                "and spellbound by your love .\n" +
                "No wonder I am always thinking about you.\n" +
                "I wish to celebrate every Valentine with you.\n" +
                "Happy Valentine's Day.."));
        list.add(new SharyModels("On Valentine's Day,\n" +
                "I'm thinking about\n" +
                "the special ways\n" +
                "you have made my life better.\n" +
                "The little things,\n" +
                "the not-so-little things...\n" +
                "Your kindness,\n" +
                "the way you always listen\n" +
                "and pay attention to me.\n" +
                "You make my world\n" +
                "brighter and richer.\n" +
                "You're a gift to me,\n" +
                "and I thank you\n" +
                "for being you."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("The arc of my life\n" +
                "can only become circle\n" +
                "when a Special Someone like you\n" +
                "will be my Valentine.."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("mesmerized by your charisma\n" +
                "and spellbound by your love .\n" +
                "No wonder I am always thinking about you.\n" +
                "I wish to celebrate every Valentine with you.\n" +
                "Happy Valentine's Day.."));
        list.add(new SharyModels("On Valentine's Day,\n" +
                "I'm thinking about\n" +
                "the special ways\n" +
                "you have made my life better.\n" +
                "The little things,\n" +
                "the not-so-little things...\n" +
                "Your kindness,\n" +
                "the way you always listen\n" +
                "and pay attention to me.\n" +
                "You make my world\n" +
                "brighter and richer.\n" +
                "You're a gift to me,\n" +
                "and I thank you\n" +
                "for being you."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("The arc of my life\n" +
                "can only become circle\n" +
                "when a Special Someone like you\n" +
                "will be my Valentine.."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
    }

    private void initList5() {
        list.add(new SharyModels("The arc of my life\n" +
                "can only become circle\n" +
                "when a Special Someone like you\n" +
                "will be my Valentine.."));
        list.add(new SharyModels("mesmerized by your charisma\n" +
                "and spellbound by your love .\n" +
                "No wonder I am always thinking about you.\n" +
                "I wish to celebrate every Valentine with you.\n" +
                "Happy Valentine's Day.."));
        list.add(new SharyModels("On Valentine's Day,\n" +
                "I'm thinking about\n" +
                "the special ways\n" +
                "you have made my life better.\n" +
                "The little things,\n" +
                "the not-so-little things...\n" +
                "Your kindness,\n" +
                "the way you always listen\n" +
                "and pay attention to me.\n" +
                "You make my world\n" +
                "brighter and richer.\n" +
                "You're a gift to me,\n" +
                "and I thank you\n" +
                "for being you."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("The arc of my life\n" +
                "can only become circle\n" +
                "when a Special Someone like you\n" +
                "will be my Valentine.."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("mesmerized by your charisma\n" +
                "and spellbound by your love .\n" +
                "No wonder I am always thinking about you.\n" +
                "I wish to celebrate every Valentine with you.\n" +
                "Happy Valentine's Day.."));
        list.add(new SharyModels("On Valentine's Day,\n" +
                "I'm thinking about\n" +
                "the special ways\n" +
                "you have made my life better.\n" +
                "The little things,\n" +
                "the not-so-little things...\n" +
                "Your kindness,\n" +
                "the way you always listen\n" +
                "and pay attention to me.\n" +
                "You make my world\n" +
                "brighter and richer.\n" +
                "You're a gift to me,\n" +
                "and I thank you\n" +
                "for being you."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("The arc of my life\n" +
                "can only become circle\n" +
                "when a Special Someone like you\n" +
                "will be my Valentine.."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("mesmerized by your charisma\n" +
                "and spellbound by your love .\n" +
                "No wonder I am always thinking about you.\n" +
                "I wish to celebrate every Valentine with you.\n" +
                "Happy Valentine's Day.."));
        list.add(new SharyModels("On Valentine's Day,\n" +
                "I'm thinking about\n" +
                "the special ways\n" +
                "you have made my life better.\n" +
                "The little things,\n" +
                "the not-so-little things...\n" +
                "Your kindness,\n" +
                "the way you always listen\n" +
                "and pay attention to me.\n" +
                "You make my world\n" +
                "brighter and richer.\n" +
                "You're a gift to me,\n" +
                "and I thank you\n" +
                "for being you."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("The arc of my life\n" +
                "can only become circle\n" +
                "when a Special Someone like you\n" +
                "will be my Valentine.."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("mesmerized by your charisma\n" +
                "and spellbound by your love .\n" +
                "No wonder I am always thinking about you.\n" +
                "I wish to celebrate every Valentine with you.\n" +
                "Happy Valentine's Day.."));
        list.add(new SharyModels("On Valentine's Day,\n" +
                "I'm thinking about\n" +
                "the special ways\n" +
                "you have made my life better.\n" +
                "The little things,\n" +
                "the not-so-little things...\n" +
                "Your kindness,\n" +
                "the way you always listen\n" +
                "and pay attention to me.\n" +
                "You make my world\n" +
                "brighter and richer.\n" +
                "You're a gift to me,\n" +
                "and I thank you\n" +
                "for being you."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
        list.add(new SharyModels("The arc of my life\n" +
                "can only become circle\n" +
                "when a Special Someone like you\n" +
                "will be my Valentine.."));
        list.add(new SharyModels("Life feels like just as fresh\n" +
                "as a newly blossomed petal of rose\n" +
                "when i look to you as my\n" +
                "VALENTINO.."));
    }

}