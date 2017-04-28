package com.arbli.timetable.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.arbli.timetable.constant.Const;
import com.arbli.timetable.fragment.PlaceholderFragment;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private static final String TAG = "TAG";

    private DatabaseReference mDatabase;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);

        mDatabase = FirebaseDatabase.getInstance().getReference();

    }

    @Override
    public Fragment getItem(int position) {
        return PlaceholderFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Const.DAYS_LONG[position];
    }
}
