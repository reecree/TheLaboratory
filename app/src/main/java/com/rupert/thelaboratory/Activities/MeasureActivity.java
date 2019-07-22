package com.rupert.thelaboratory.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.rupert.thelaboratory.R;
import com.rupert.thelaboratory.Measurement.Count;
import com.rupert.thelaboratory.Measurement.Date;

public class MeasureActivity extends AppCompatActivity {

    private String[] measurementTypes = {Count.Name(), Date.Name()};
    private View createCountView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        createCountView = findViewById(R.id.count_add);

        Spinner spinner = (Spinner) findViewById(R.id.measurement_type_spinner);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_spinner_item);
        adapter.add("NONE");
        adapter.addAll(measurementTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    hideAll();
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
        createCountView.setVisibility(View.INVISIBLE);
    }

    private void showCount() {
        createCountView.setVisibility(View.VISIBLE);
    }

    private void showDate() {

    }

}
