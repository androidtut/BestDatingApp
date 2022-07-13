package com.example.myquotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.myquotes.databinding.ActivityDrawerBinding;
import com.google.android.material.navigation.NavigationView;

public class DrawerActivity extends AppCompatActivity {
    private ActionBarDrawerToggle toggle;
    private ActivityDrawerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbars);
        toggle = new ActionBarDrawerToggle(this,binding.drawer,binding.toolbars,R.string.open,R.string.close);
        binding.drawer.addDrawerListener(toggle);
        toggle.syncState();

        binding.navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                binding.drawer.closeDrawer(GravityCompat.START);
                switch (item.getItemId()){
                    case R.id.share:
                        Toast.makeText(DrawerActivity.this, "share btn click", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        }

    @Override
    public void onBackPressed() {
        if(binding.drawer.isDrawerOpen(GravityCompat.START)){
            binding.drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}