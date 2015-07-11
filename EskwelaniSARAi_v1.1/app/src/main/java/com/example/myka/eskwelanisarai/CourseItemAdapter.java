package com.example.myka.eskwelanisarai;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Myka on 7/9/2015.
 */
public class CourseItemAdapter extends RecyclerView.Adapter<CourseItemAdapter.CourseViewHolder> {

    List<CourseItem> data = Collections.emptyList();
    private LayoutInflater inflater;

    private ClickListener clickListener;

    public CourseItemAdapter (Context context, List<CourseItem> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }


    public void setClickListener (ClickListener clickListener) {
        this.clickListener = clickListener;
    }


    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.course_item, parent, false);
        CourseViewHolder holder = new CourseViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {
        CourseItem current = data.get(position);
        holder.title.setText(current.courseTitle);
        holder.screenshot.setImageResource(current.imageId);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        ImageView screenshot;

        public CourseViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = (TextView) itemView.findViewById(R.id.course_title);
            screenshot = (ImageView) itemView.findViewById(R.id.course_screenshot);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.itemClick(v, getPosition());
            }
        }
    }

    public interface ClickListener {
        public void itemClick (View view, int position);
    }
}
