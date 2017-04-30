package com.arbli.timetable.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arbli.timetable.R;
import com.arbli.timetable.adapter.MyAdapter;
import com.arbli.timetable.data.DataPopulate;

public class PlaceholderFragment extends Fragment {

    private static final String ARG_DAY = "day_of_week";
    private DataPopulate dp = DataPopulate.getInstance(this.getActivity());

    public PlaceholderFragment() {
    }

    public static PlaceholderFragment newInstance(int day) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_DAY, day);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_day_view_1, container, false);

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setNestedScrollingEnabled(false);

        MyAdapter mAdapter = new MyAdapter(getContext(), dp.getEvents(getArguments().getInt(ARG_DAY)));
        rv.setAdapter(mAdapter);

        return rootView;
    }

}