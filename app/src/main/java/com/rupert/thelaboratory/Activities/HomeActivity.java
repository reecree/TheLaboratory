package com.rupert.thelaboratory.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.rupert.thelaboratory.Adapters.HomeRecycleAdapter;
import com.rupert.thelaboratory.R;
import com.rupert.thelaboratory.Measurement.Measurement;

import java.util.Vector;

public class HomeActivity extends AppCompatActivity {

    private Vector<Measurement> measurements = new Vector<>();
    private RecyclerView recyclerView;
    private HomeRecycleAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton fab;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    recyclerView.setVisibility(View.INVISIBLE);
                    fab.hide();
                    return true;
                case R.id.navigation_experiment:
                    recyclerView.setVisibility(View.INVISIBLE);
                    fab.hide();
                    return true;
                case R.id.navigation_measure:
                    fab.show();
                    showMeasurements();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        layoutManager = new LinearLayoutManager(this);
        mAdapter = new HomeRecycleAdapter(new String[0]);

        recyclerView = findViewById(R.id.home_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setVisibility(View.INVISIBLE);

        loadMeasurements();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fab = findViewById(R.id.home_measure_fab);
        fab.hide();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MeasureActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void loadMeasurements() {
        measurements.add(new Measurement("Measurement 1", null));
        measurements.add(new Measurement("Measurement 2", null));
        measurements.add(new Measurement("Measurement 3", null));
        measurements.add(new Measurement("Measurement 4", null));
    }

    protected void showMeasurements() {
        String[] ds = new String[measurements.size()];
        for(int i=0; i<measurements.size(); i++) {
            ds[i] = measurements.get(i).GetName();
        }
        mAdapter.UpdateDataset(ds);
        mAdapter.notifyDataSetChanged();
        recyclerView.setVisibility(View.VISIBLE);
    }

}
