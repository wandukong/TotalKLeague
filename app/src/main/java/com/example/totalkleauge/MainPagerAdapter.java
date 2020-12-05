package com.example.totalkleauge;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.totalkleauge.club.ClubFragment;
import com.example.totalkleauge.rank.RankFragment;

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    public MainPagerAdapter(FragmentManager fm) {super(fm);}

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if(position == 0){
            fragment = new ClubFragment();
            Log.e("11", "club");
        } else if(position == 1){
            fragment = new RankFragment();
            Log.e("11", "rank");
        } else if(position == 2){
            fragment = new PlanFragment();
            Log.e("11", "plan");
        }
        return fragment;
    }

    @Override
    public int getCount() { return 3; }

}
