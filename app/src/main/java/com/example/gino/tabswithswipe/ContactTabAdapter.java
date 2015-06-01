package com.example.gino.tabswithswipe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ContactTabAdapter extends FragmentStatePagerAdapter {

    public ContactTabAdapter(FragmentManager fm) {
        super(fm);
    }

    // On first swipe it creates a list of fragment and creates corresponding index values.
    @Override
    public Fragment getItem(int fragmentIndex) {

        switch (fragmentIndex) {
            case 0:
                return new FriendsFragment();
            case 1:
                return new CommunityFragment();
            default:
                return new CommunityFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

}













