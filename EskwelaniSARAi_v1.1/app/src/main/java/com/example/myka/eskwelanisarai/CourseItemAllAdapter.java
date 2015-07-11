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
 * Created by Myka on 7/11/2015.
 */
public class CourseItemAllAdapter extends RecyclerView.Adapter<CourseItemAllAdapter.AllCourseViewHolder> {

    List<CourseItemAll> data = Collections.emptyList();
    private LayoutInflater inflater;

    public CourseItemAllAdapter (Context context, List<CourseItemAll> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public AllCourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.course_item_all, parent, false);
        AllCourseViewHolder holder = new AllCourseViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(AllCourseViewHolder holder, int position) {
        CourseItemAll current = data.get(position);
        holder.screenshot.setImageResource(current.imageId);
        holder.title.setText(current.courseTitle);
        holder.sDescription.setText(current.shortDescription);
        holder.user.setText(current.userAvailability);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class AllCourseViewHolder extends RecyclerView.ViewHolder{

        ImageView screenshot;
        TextView title;
        TextView sDescription;
        TextView user;
        public AllCourseViewHolder(View itemView) {
            super(itemView);

            screenshot = (ImageView) itemView.findViewById(R.id.course_all_image);
            title = (TextView) itemView.findViewById(R.id.course_all_title);
            sDescription = (TextView) itemView.findViewById(R.id.course_all_shortdesc);
            user = (TextView) itemView.findViewById(R.id.course_all_availuser);
        }
    }
}
