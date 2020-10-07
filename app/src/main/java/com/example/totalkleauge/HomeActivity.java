package com.example.totalkleauge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewPager viewPager = findViewById(R.id.main_viewpager);
        viewPager.setOffscreenPageLimit(3);

        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager());

        ClubFragment clubFragment = new ClubFragment();
        RankFragment rankFragment = new RankFragment();
        PlanFragment planFragment = new PlanFragment();

        adapter.addItem(clubFragment);
        adapter.addItem(rankFragment);
        adapter.addItem(planFragment);

        viewPager.setAdapter(adapter);

    }
}