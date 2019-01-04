package me.hasantagiyev.playstats;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private BottomNavigationView navigation;
    private int currentPagePosition = 0;


    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            Log.d("navigationChange", "Page Scrolled -> Pos: " + Integer.toString(position));
            if (currentPagePosition != position)
            switch (position) {
                case 0:
                    Log.d("navigationItem", Integer.toString(position));
                    navigation.setSelectedItemId(R.id.navigation_dashboard);
                    break;
                case 1:
                    Log.d("navigationItem", Integer.toString(position));
                    navigation.setSelectedItemId(R.id.navigation_stats);
                    break;
                case 2:
                    Log.d("navigationItem", Integer.toString(position));
                    navigation.setSelectedItemId(R.id.navigation_settings);
                    break;
            }
            currentPagePosition = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(1);
        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(swipeAdapter);
        viewPager.addOnPageChangeListener(mOnPageChangeListener);
        viewPager.setCurrentItem(0);


        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Log.d("navigationChange", "itemId -> " + Integer.toString(item.getItemId()));
            Log.d("navigationChange", "currentPosition -> " + Integer.toString(currentPagePosition));
            switch (item.getItemId()) {
                case R.id.navigation_dashboard:
                    if (currentPagePosition == 0)
                        return false;
                    currentPagePosition = 0;
                    viewPager.setCurrentItem(0, true);
                    return true;
                case R.id.navigation_stats:
                    if (currentPagePosition == 1)
                        return false;
                    currentPagePosition = 1;
                    viewPager.setCurrentItem(1, true);
                    return true;
                case R.id.navigation_settings:
                    if (currentPagePosition == 2)
                        return false;
                    currentPagePosition = 2;
                    viewPager.setCurrentItem(2, true);
                    return true;
                default:
                    return false;
            }
        }
    };
}
