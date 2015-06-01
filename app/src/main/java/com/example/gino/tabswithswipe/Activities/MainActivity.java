package com.example.gino.tabswithswipe.Activities;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.gino.tabswithswipe.Adapters.ContactTabAdapter;
import com.example.gino.tabswithswipe.Adapters.UpdateTabAdapter;
import com.example.gino.tabswithswipe.R;

public class MainActivity extends AppCompatActivity implements android.support.v7.app.ActionBar.TabListener {
    private ActionBar actionBar;
    private ViewPager mTabsViewPager;
    private ContactTabAdapter mContactTabAdapter;
    private UpdateTabAdapter mUpdateTabAdapter;
    private Button contactButton;
    private Button updatesButton;
    private Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.actionBar = getSupportActionBar();

        // Set navigation mode to tabs. Check if actionbar was created.
        if (null != this.actionBar) {
            this.actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        }

        // Setup top tabs to activity
        mContactTabAdapter = new ContactTabAdapter(getSupportFragmentManager());
        mUpdateTabAdapter = new UpdateTabAdapter(getSupportFragmentManager());

        // Defaults to contact adapter
        this.configureTabsForActivity(mContactTabAdapter);

        // Setup tab values for top navigation tabs
        this.setupTabValues();

        // Find buttons for bottom navigation.
        contactButton = (Button) findViewById(R.id.btn_contact);
        updatesButton = (Button) findViewById(R.id.btn_update);
    }

    // This will default to friends fragment first.
    private void configureTabsForActivity(FragmentStatePagerAdapter fragmentStatePagerAdapter) {

        // Find pager from xml config.
        mTabsViewPager = (ViewPager) findViewById(R.id.tabs_pager_1);

        // This sets the listener to the pager. In other words it listens for the
        // user's input. For this instance it is a swipe.
        mTabsViewPager.setOnPageChangeListener(new OnPageChangeListener() {

            // Set current fragment from stored fragment list in TabsAdapter.
            @Override
            public void onPageSelected(int position) {
                mTabsViewPager.setCurrentItem(position);
            }

            // Set current fragment from stored fragment list in TabsAdapter by user swiping.
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

        mTabsViewPager.setAdapter(fragmentStatePagerAdapter);
    }

    // Setup navigation tabs to action bar, along with the listener.
    private void setupTabValues() {
        Tab tab1 = actionBar.newTab().setText("New Contact").setTabListener(this);
        Tab tab2 = actionBar.newTab().setText("My Contacts").setTabListener(this);
        Tab tab3 = actionBar.newTab().setText("Chats").setTabListener(this);

        this.actionBar.addTab(tab1);
        this.actionBar.addTab(tab2);
        this.actionBar.addTab(tab3);
    }

    public void onContactClick(View view) {
        try {
            this.configureTabsForActivity(mContactTabAdapter);
            System.out.println("set contact adapter");

            contactButton.setBackgroundColor(Color.parseColor("#cc0000"));
            updatesButton.setBackgroundColor(Color.parseColor("#00cc00"));
        } catch (Exception e) {
            Log.d("TAG", "Error: " + e);
        }
    }

    public void onUpdatesClick(View view) {
        try {
            this.configureTabsForActivity(mUpdateTabAdapter);
            System.out.println("set update adapter");

            contactButton.setBackgroundColor(Color.parseColor("#00cc00"));
            updatesButton.setBackgroundColor(Color.parseColor("#cc0000"));
        } catch (Exception e) {
            Log.d("TAG", "Error: " + e);
        }
        this.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });

    }

    @Override
    public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTabSelected(Tab selectedtab, FragmentTransaction arg1) {
        // TODO Auto-generated method stub
        mTabsViewPager.setCurrentItem(selectedtab.getPosition()); //update tab position on tap
    }

    @Override
    public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
        // TODO Auto-generated method stub

    }
}