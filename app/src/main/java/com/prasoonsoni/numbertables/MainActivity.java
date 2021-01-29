package com.prasoonsoni.numbertables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.*;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView numberTable;
    public void toReturnTable(int timesTable){
        ArrayList<String> tableNumber = new ArrayList<String>();
        for(int i = 1;i<=10;i++){
            tableNumber.add(Integer.toString(i*timesTable));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2,tableNumber);
        numberTable.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView enText = (TextView) findViewById(R.id.enText);
        enText.animate().alpha(1f).setDuration(2000);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.animate().alpha(1f).setDuration(3000);
        numberTable = (ListView) findViewById(R.id.numberTable);
        numberTable.animate().alpha(1f).setDuration(4000);

        seekBar.setMax(20);
        seekBar.setProgress(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTable;
                if (progress<min){
                    timesTable = min;
                    seekBar.setProgress(min);
                }
                else{
                    timesTable = progress;
                }
                toReturnTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        toReturnTable(10);

    }
}