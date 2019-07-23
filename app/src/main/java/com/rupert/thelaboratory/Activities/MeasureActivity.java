package com.rupert.thelaboratory.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.rupert.thelaboratory.R;
import com.rupert.thelaboratory.Measurement.Count;
import com.rupert.thelaboratory.Measurement.Date;

public class MeasureActivity extends AppCompatActivity {

    private String[] measurementTypes = {Count.Name(), Date.Name()};
    //private View createCountView;
    private LinearLayout measureBucket;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //createCountView = findViewById(R.id.count_add);
        measureBucket = findViewById(R.id.measure_bucket);
        inflater = (LayoutInflater) getApplicationContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        Spinner spinner = (Spinner) findViewById(R.id.measurement_type_spinner);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item);
        adapter.add("    ");
        adapter.addAll(measurementTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                hideAll();
                if (position == 0) {
                    return;
                }
                String measurementName = measurementTypes[position-1];
                if (measurementName.equals(Count.Name())) {
                    showCount();
                } else if (measurementName.equals(Date.Name())) {
                    showDate();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                hideAll();
            }
        });
    }

    private void hideAll() {
        measureBucket.removeAllViews();
    }

    private void showCount() {
        View v = inflater.inflate(R.layout.create_count, null);
        measureBucket.addView(v);
    }

    private void showDate() {
        View v = inflater.inflate(R.layout.create_date, null);
        measureBucket.addView(v);
    }

}
