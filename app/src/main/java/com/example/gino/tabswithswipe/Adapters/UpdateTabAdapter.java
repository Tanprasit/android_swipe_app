package com.example.gino.tabswithswipe.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.gino.tabswithswipe.Fragments.CommunityFragment;
import com.example.gino.tabswithswipe.Activities.PublicProfileFragment;

public class UpdateTabAdapter extends FragmentStatePagerAdapter {

    public UpdateTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int fragmentIndex) {
        switch (fragmentIndex) {
            case 0:
                return new PublicProfileFragment();
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
