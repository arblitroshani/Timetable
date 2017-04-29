package com.arbli.timetable.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.arbli.timetable.R;
import com.arbli.timetable.adapter.SectionsPagerAdapter;
import com.arbli.timetable.constant.Const;

import java.util.Calendar;

public class DayViewActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private View mTimeIndicator;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        resources = getResources();

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOffscreenPageLimit(1);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        mTimeIndicator = findViewById(R.id.timeIndicator);

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        if (day == Calendar.SUNDAY) day = Calendar.MONDAY;
        tabLayout.getTabAt(day - Calendar.MONDAY).select();

        int minTotal = hour * 60 + minutes;
        if (minTotal >= Const.SCHOOL_START_MINUTES && minTotal <= Const.SCHOOL_END_MINUTES) {
            int position = hour - 8;
            if (minutes < 45) position--;

            int startMargin = (int) resources.getDimension(R.dimen.time_indicator_start_margin);
            int differenceMargin = (int) resources.getDimension(R.dimen.time_margin_difference);

            int totalMargin = startMargin + differenceMargin * position;
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) mTimeIndicator.getLayoutParams();
            params.topMargin = totalMargin;
        } else {
            mTimeIndicator.setBackgroundColor(ResourcesCompat.getColor(resources, R.color.transparent, null));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_day_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
