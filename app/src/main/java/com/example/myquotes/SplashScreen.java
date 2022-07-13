package com.example.myquotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Presentation;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class SplashScreen extends AppCompatActivity {
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();
//        image = findViewById(R.id.imageView);
//        Glide.with(this).asGif().load(R.raw.animatetext).into(image);


        SharedPreferences preferences = this.getSharedPreferences("splash",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        Thread thread = new Thread(){
            @Override
            public void run() {
                try{
                    if(preferences.getBoolean("isMain",false)){
                        sleep(5*1000);
                        Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        editor.putBoolean("isMain",true);
                        editor.apply();

                        TaskStackBuilder.create(SplashScreen.this).addNextIntentWithParentStack(
                                new Intent(SplashScreen.this,MainActivity.class))
                                .addNextIntent(new Intent(SplashScreen.this,IntroActivity.class))
                                .startActivities();
                     }
                }catch(Exception e){
                    Toast.makeText(SplashScreen.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        };
        thread.start();




    }
}