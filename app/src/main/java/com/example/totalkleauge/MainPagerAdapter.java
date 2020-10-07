package com.example.totalkleauge;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    ArrayList<Fragment> items = new ArrayList<Fragment>();
    public MainPagerAdapter(FragmentManager fm) {super(fm);}

    public void addItem(Fragment item) {items.add(item);}

    @Override
    public Fragment getItem(int position) { return items.get(position); }

    @Override
    public int getCount() { return items.size(); }

}
