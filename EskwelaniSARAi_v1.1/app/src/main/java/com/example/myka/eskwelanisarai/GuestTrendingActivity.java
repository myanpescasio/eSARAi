package com.example.myka.eskwelanisarai;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class GuestTrendingActivity extends ActionBarActivity {

    private RecyclerView tRecycler;
    private CourseItemAllAdapter tAdapter;

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_trending);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        GuestDrawerFragment drawerFragment = (GuestDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_guest_drawer);
        drawerFragment.setUp(R.id.fragment_guest_drawer, (DrawerLayout) findViewById(R.id.guest_drawer_layout), toolbar);

        tRecycler = (RecyclerView) findViewById(R.id.trending_courses_all);
        tRecycler.setHasFixedSize(true);
        LinearLayoutManager tLinearLayout = new LinearLayoutManager(this);
        tLinearLayout.setOrientation(LinearLayoutManager.VERTICAL);
        tRecycler.setLayoutManager(tLinearLayout);
        tAdapter = new CourseItemAllAdapter(this, getCourseData());
        tRecycler.setAdapter(tAdapter);
    }

    private List<CourseItemAll> getCourseData() {
        List<CourseItemAll> data = new ArrayList<>();
        int[] icons = {R.drawable.smallfarm, R.drawable.smallfarm, R.drawable.smallfarm, R.drawable.smallfarm, R.drawable.smallfarm, R.drawable.smallfarm};
        String[] titles = {"Corn Processing", "Corn Pest", "Corn Diseases", "Corn Foraging", "Land Preparation", "Corn Stages"};
        String[] sDescription = {"This module discusses corn and its co-product processing.",
                "This module discusses corn pests and their management.",
                "This module discusses corn diseases and their management.",
                "This module discusses corn foraging.",
                "This module discusses land preparation for corn planting.",
                "This module discusses stages of corn plant development."};
        String[] user = {"all", "all", "all", "registered user", "registered user", "all"};

        for (int i=0; i<titles.length && i<icons.length; i++) {
            CourseItemAll current = new CourseItemAll();
            current.imageId = icons[i];
            current.courseTitle = titles[i];
            current.shortDescription = sDescription[i];
            current.userAvailability = user[i];
            data.add(current);
        }
        return data;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_guest_trending, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
