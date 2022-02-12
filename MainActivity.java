package com.srcodex.msa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTime = findViewById(R.id.tvTime);

        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        Calendar calendar = Calendar.getInstance();
                        calendar.set(0,0,0, hourOfDay, minute);

                        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
                        tvTime.setText("Time: "+sdf.format(calendar.getTime()));

                    }
                },12,0,false);
                timePickerDialog.show();

            }
        });

    }
}