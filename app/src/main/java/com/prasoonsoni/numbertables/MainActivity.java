package com.prasoonsoni.numbertables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView numberTable;

    public void toReturnTable(int timesTable) {
        ArrayList<String> tableNumber = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            tableNumber.add(timesTable + " x " + i + " = " + (i * timesTable));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tableNumber);
        numberTable.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView enText = findViewById(R.id.enText);
        SeekBar seekBar = findViewById(R.id.seekBar);
        numberTable = findViewById(R.id.numberTable);
        TextView toView = findViewById(R.id.toView);

        enText.animate().alpha(1f).setDuration(2000);
        seekBar.animate().alpha(1f).setDuration(3000);
        toView.animate().alpha(1f).setDuration(4000);
        numberTable.animate().alpha(1f).setDuration(3000);

        seekBar.setMax(20);
        seekBar.setProgress(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTable;
                if (progress < min) {
                    timesTable = min;
                    seekBar.setProgress(min);
                } else {
                    timesTable = progress;
                }
                toView.setText("NUMBER TABLE OF : " + Integer.toString(timesTable));
                toReturnTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        toView.setText("NUMBER TABLE OF : " + 10);
        toReturnTable(10);
    }
}