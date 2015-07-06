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
 * Created by Myka on 7/5/2015.
 */
public class CustomDrawerAdapter extends RecyclerView.Adapter<CustomDrawerAdapter.DrawerViewHolder> {

    List<CustomDrawerItem> data = Collections.emptyList();
    private LayoutInflater inflater;

    private ClickListener clickListener;

    public CustomDrawerAdapter (Context context, List<CustomDrawerItem> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public DrawerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_drawer_items, parent, false);
        DrawerViewHolder holder = new DrawerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DrawerViewHolder holder, int position) {
        CustomDrawerItem current = data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);
    }

    public void setClickListener (ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class DrawerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        ImageView icon;

        public DrawerViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = (TextView) itemView.findViewById(R.id.drawer_item_text);
            icon = (ImageView) itemView.findViewById(R.id.drawer_item_icon);
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
