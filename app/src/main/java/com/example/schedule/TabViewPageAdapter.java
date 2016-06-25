package com.example.schedule;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.schedule.TabDays.FiveFragment;
import com.example.schedule.TabDays.FourFragment;
import com.example.schedule.TabDays.OneFragment;
import com.example.schedule.TabDays.ThreeFragment;
import com.example.schedule.TabDays.TwoFragment;

public class TabViewPageAdapter extends FragmentPagerAdapter {

    public TabViewPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new OneFragment();
            case 1:
                // Games fragment activity
                return new TwoFragment();
            case 2:
                // Movies fragment activity
                return new ThreeFragment();
            case 3:
                // Movies fragment activity
                return new FourFragment();

            case 4:
                // Movies fragment activity
                return new FiveFragment();
//            case 5:
//                // Movies fragment activity
//                return new SixFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 5;
    }

}

