package com.arbli.timetable.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import com.arbli.timetable.R;
import com.arbli.timetable.activity.CourseEventEditActivity;
import com.arbli.timetable.activity.CourseEventViewActivity;
import com.arbli.timetable.constant.Const;
import com.arbli.timetable.model.CourseEvent;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<CourseEvent> courseEvents;
    private Resources res;
    private Context mContext;
    private AlphaAnimation alphaAnimation;

    public MyAdapter(Context context, ArrayList<CourseEvent> courseEvents) {
        this.mContext = context;
        this.courseEvents = courseEvents;
        res = context.getResources();
        alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch(viewType) {
            case Const.EVENT_EMPTY:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_event_empty, parent, false);
                return new EmptyEventViewHolder(view);
            case Const.EVENT_LENGTH_1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_event_single, parent, false);
                return new EventViewHolder(view, true);
            case Const.EVENT_LENGTH_2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_event_double, parent, false);
                return new EventViewHolder(view, false);
            case Const.EVENT_LENGTH_3:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_event_triple, parent, false);
                return new EventViewHolder(view, false);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CourseEvent tmp = courseEvents.get(position);
        int duration = tmp.getDuration();
        if (duration == 0) return;

        String courseName = tmp.getNameOfCourse();
        String classroom = tmp.getClassroom();
        int color = ResourcesCompat.getColor(res, Const.COLOR_ARRAY[tmp.getColor()], null);
        ((EventViewHolder) holder).tvCourseName.setText(courseName);
        ((EventViewHolder) holder).tvClassroom.setText(classroom);
        ((EventViewHolder) holder).cv.setCardBackgroundColor(color);

        if (duration != 1) {
            String professorName = tmp.getProfessorShortName();
            ((EventViewHolder) holder).tvProfName.setText(professorName);
        }
    }

    @Override
    public int getItemCount() {
        return courseEvents.size();
    }

    @Override
    public int getItemViewType(int position) {
        return courseEvents.get(position).getDuration();
    }

    private class EmptyEventViewHolder extends RecyclerView.ViewHolder {
        public EmptyEventViewHolder(View view) {
            super(view);
        }
    }

    private class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnTouchListener, View.OnLongClickListener {
        private TextView tvClassroom, tvCourseName, tvProfName;
        private CardView cv;

        public EventViewHolder(View view, boolean isSingle) {
            super(view);
            tvClassroom = (TextView) view.findViewById(R.id.tvClassroom);
            tvCourseName = (TextView) view.findViewById(R.id.tvName);
            if (!isSingle) {
                tvProfName = (TextView) view.findViewById(R.id.tvProfName);
            }
            cv = (CardView) view.findViewById(R.id.cv);
            cv.startAnimation(alphaAnimation);
            cv.setOnClickListener(this);
            cv.setOnTouchListener(this);
            cv.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            CourseEvent ce = courseEvents.get(getAdapterPosition());
            Intent intent = new Intent(mContext, CourseEventViewActivity.class);
            intent.putExtra(Const.COURSE_EVENT_OBJECT_TAG, ce);
            mContext.startActivity(intent);
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    ObjectAnimator upAnim = ObjectAnimator.ofFloat(view, "translationZ", 16);
                    upAnim.setDuration(150);
                    upAnim.setInterpolator(new DecelerateInterpolator());
                    upAnim.start();
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    ObjectAnimator downAnim = ObjectAnimator.ofFloat(view, "translationZ", 0);
                    downAnim.setDuration(150);
                    downAnim.setInterpolator(new AccelerateInterpolator());
                    downAnim.start();
                    break;
            }
            return false;
        }

        @Override
        public boolean onLongClick(View view) {
            if (FirebaseAuth.getInstance().getCurrentUser().getEmail().equals("ddaja15@epoka.edu.al")) {
                CourseEvent ce = courseEvents.get(getAdapterPosition());
                Intent intent = new Intent(mContext, CourseEventEditActivity.class);
                intent.putExtra(Const.COURSE_EVENT_OBJECT_TAG, ce);
                mContext.startActivity(intent);
            } else
                Toast.makeText(mContext,"You have no admin privileges!",Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}
