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
 * Created by Myka on 7/12/2015.
 */
public class CourseOutlineItemAdapter extends RecyclerView.Adapter<CourseOutlineItemAdapter.OutlineViewHolder> {
    List<CourseOutlineItem> data = Collections.emptyList();
    private LayoutInflater inflater;

    ClickListener clickListener;

    public CourseOutlineItemAdapter (Context context, List<CourseOutlineItem> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void setClickListener (ClickListener clickListener){
        this.clickListener = clickListener;
    }


    @Override
    public OutlineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.outline_item, parent, false);
        OutlineViewHolder holder = new OutlineViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(OutlineViewHolder holder, int position) {
        CourseOutlineItem current = data.get(position);
        holder.title.setText(current.topic);
        holder.icon.setImageResource(current.imageId);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class OutlineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView icon;
        TextView title;

        public OutlineViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = (TextView) itemView.findViewById(R.id.outline_item_title);
            icon = (ImageView) itemView.findViewById(R.id.outline_item_icon);
        }

        @Override
        public void onClick(View v) {
            if(clickListener != null){
                clickListener.itemClick(v, getLayoutPosition());
            }
        }
    }

    public interface ClickListener {
        public void itemClick(View view, int position);
    }
}
