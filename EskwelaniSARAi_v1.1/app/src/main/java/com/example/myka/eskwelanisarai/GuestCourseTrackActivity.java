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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class GuestCourseTrackActivity extends ActionBarActivity implements CourseOutlineItemAdapter.ClickListener{

    private RecyclerView recycler;
    private CourseOutlineItemAdapter adapter;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_course_track);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        GuestDrawerFragment drawerFragment = (GuestDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_guest_drawer);
        drawerFragment.setUp(R.id.fragment_guest_drawer, (DrawerLayout) findViewById(R.id.guest_drawer_layout), toolbar);

        recycler = (RecyclerView) findViewById(R.id.course_track_outline);
        recycler.setHasFixedSize(true);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        linearLayout.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(linearLayout);
        adapter = new CourseOutlineItemAdapter(this, getOutlineData());
        adapter.setClickListener(this);
        recycler.setAdapter(adapter);
    }

    private List<CourseOutlineItem> getOutlineData() {
        List<CourseOutlineItem> data = new ArrayList<>();
        int[] icons = {R.drawable.one, R.drawable.question, R.drawable.two, R.drawable.question, R.drawable.three, R.drawable.question, R.drawable.four, R.drawable.question};
        String[] titles = {"Corn Type","Quiz: Corn Types", "Corn Processing: Wet Milling", "Quiz: Wet Milling", "Corn Processing: Dry Milling", "Quiz: Dry Milling", "Nutritional Content of Corn", "Quiz: Nutritional Contents"};

        for (int i=0; i<titles.length && i<icons.length; i++) {
            CourseOutlineItem current = new CourseOutlineItem();
            current.imageId = icons[i];
            current.topic = titles[i];
            data.add(current);
        }
        return data;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_guest_course_track, menu);
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

    @Override
    public void itemClick(View view, int position) {
        if(position == 0){
            startActivity(new Intent(this, Sample1Activity.class));
        }
        else if(position == 1){
            startActivity(new Intent(this, Sample1QuizActivity.class));
        }
        else{
            Toast.makeText(getApplicationContext(), "No Available Data at the Moment!", Toast.LENGTH_SHORT).show();
        }
    }
}
