package sg.edu.rp.c346.id22013179.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatePicker dp = findViewById(R.id.datePicker);
        TimePicker tp = findViewById(R.id.timePicker);
        Button btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        Button btnDisplayTime = findViewById(R.id.buttonDisplayDate);
        TextView tvDisplay = findViewById(R.id.textViewDisplay);
        Button btnReset = findViewById(R.id.btnReset);

        dp.updateDate(2020,0,1);
        tp.setCurrentHour(0);
        tp.setCurrentMinute(0);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int hour = tp.getCurrentHour();
                int minute = tp.getCurrentMinute();

                String timeString = String.format(Locale.getDefault(),"%d:%02d",hour,minute);

                tvDisplay.setText("Time is "+ timeString);
            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePicker datePicker = findViewById(R.id.datePicker);

                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1;
                int year = datePicker.getYear();

                String date = "Date is " + day + "/" + month + "/" + year;
                tvDisplay.setText(date);
            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = dp.getDayOfMonth();
                int month = dp.getMonth() + 1;
                int year = dp.getYear();
                String date = "Date is " + day + "/" + month + "/" + year;
                tvDisplay.setText(date);
            }
        });

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = tp.getCurrentHour();
                int minute = tp.getCurrentMinute();
                String time = "Time is " + hour + ":" + minute;
                tvDisplay.setText(time);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.updateDate(2020, 0, 1);
                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);
                tvDisplay.setText("");
            }
        });
    }
}
