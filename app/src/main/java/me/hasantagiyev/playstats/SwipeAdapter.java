package me.hasantagiyev.playstats;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;

public class SwipeAdapter extends FragmentStatePagerAdapter {
    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new DashboardFragment();
                break;
            case 1:
                fragment = new StatisticsFragment();
                break;
            case 2:
                fragment = new SettingsFragment();
                break;
            default:
                fragment = new DashboardFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
