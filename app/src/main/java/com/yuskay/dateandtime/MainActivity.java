package com.yuskay.dateandtime;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
 private TextView etdate, ettime, etcalender;
 private TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etdate=findViewById(R.id.etdate);
        ettime=findViewById(R.id.ettime);
        etcalender=findViewById(R.id.etcalender);

        tvOutput =findViewById(R.id.tvOutput);
        ettime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTime();
            }
        });

        etdate.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                loadDatapicker();
            }
        });

    }

    private void loadDatapicker(){
        final Calendar c= Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog dataPickerDialog=new DatePickerDialog(
                this, this, year, month, day);
        dataPickerDialog.show();

        }

    private void loadTime() {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                ettime.setText("Time is:" + hourOfDay + ":" + minute);
            }

        }, hour, minute, false);
        timePickerDialog.show();
    }



        @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
    String date ="Month/Day/Year :" + month +"/" + dayOfMonth +"/" + year;
    tvOutput.setText(date);

    }
}
