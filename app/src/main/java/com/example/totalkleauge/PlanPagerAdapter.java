package com.example.totalkleauge;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.totalkleauge.planfragment.Plan05Fragment;
import com.example.totalkleauge.planfragment.Plan06Fragment;
import com.example.totalkleauge.planfragment.Plan07Fragment;
import com.example.totalkleauge.planfragment.Plan08Fragment;
import com.example.totalkleauge.planfragment.Plan09Fragment;
import com.example.totalkleauge.planfragment.Plan10Fragment;
import com.example.totalkleauge.planfragment.Plan11Fragment;

public class PlanPagerAdapter extends FragmentStatePagerAdapter {

    public PlanPagerAdapter(@NonNull FragmentManager fm) { super(fm); }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if(position == 0){
            fragment = new Plan05Fragment();
        } else if(position == 1){
            fragment = new Plan06Fragment();
        } else if(position == 2){
            fragment = new Plan07Fragment();
        } else if(position == 3){
            fragment = new Plan08Fragment();
        } else if(position == 4){
            fragment = new Plan09Fragment();
        } else if(position == 5){
            fragment = new Plan10Fragment();
        } else if(position == 6){
            fragment = new Plan11Fragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 7;
    }
}
