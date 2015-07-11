package com.example.myka.eskwelanisarai;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class TraineeHomeActivity extends ActionBarActivity {

    private RecyclerView tRecycler;
    private CourseItemAdapter tAdapter;

    private RecyclerView nRecycler;
    private CourseItemAdapter nAdapter;

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainee_home);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        TraineeDrawerFragment drawerFragment = (TraineeDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_trainee_drawer);
        drawerFragment.setUp(R.id.fragment_trainee_drawer, (DrawerLayout) findViewById(R.id.trainee_drawer_layout), toolbar);

        tRecycler = (RecyclerView) findViewById(R.id.trending_courses);
        tRecycler.setHasFixedSize(true);
        LinearLayoutManager tLinearLayout = new LinearLayoutManager(this);
        tLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        tRecycler.setLayoutManager(tLinearLayout);
        tAdapter = new CourseItemAdapter(this, getTrendingCourseData());
        tRecycler.setAdapter(tAdapter);

        nRecycler = (RecyclerView) findViewById(R.id.new_courses);
        nRecycler.setHasFixedSize(true);
        LinearLayoutManager nLinearLayout = new LinearLayoutManager(this);
        nLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        nRecycler.setLayoutManager(nLinearLayout);
        nAdapter = new CourseItemAdapter(this, getNewCourseData());
        nRecycler.setAdapter(nAdapter);
    }

    private List<CourseItem> getNewCourseData() {
        List<CourseItem> data = new ArrayList<>();
        int[] icons = {R.drawable.smallfarm, R.drawable.smallfarm, R.drawable.smallfarm, R.drawable.smallfarm, R.drawable.smallfarm};
        String[] titles = {"Land Preparation", "Corn Foraging", "Corn Diseases", "Corn Pest", "Corn Processing"};

        for (int i=0; i<titles.length && i<icons.length; i++) {
            CourseItem current = new CourseItem();
            current.imageId = icons[i];
            current.courseTitle = titles[i];
            data.add(current);
        }
        return data;
    }

    private List<CourseItem> getTrendingCourseData() {
        List<CourseItem> data = new ArrayList<>();
        int[] icons = {R.drawable.smallfarm, R.drawable.smallfarm, R.drawable.smallfarm, R.drawable.smallfarm, R.drawable.smallfarm};
        String[] titles = {"Corn Processing", "Corn Pest", "Corn Diseases", "Corn Foraging", "Land Preparation"};

        for (int i=0; i<titles.length && i<icons.length; i++) {
            CourseItem current = new CourseItem();
            current.imageId = icons[i];
            current.courseTitle = titles[i];
            data.add(current);
        }
        return data;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_trainee_home, menu);
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

    public void redirectTrending(View view){
        Intent traineeTrending = new Intent(this, TraineeTrendingActivity.class);
        startActivity(traineeTrending);
    }
}
