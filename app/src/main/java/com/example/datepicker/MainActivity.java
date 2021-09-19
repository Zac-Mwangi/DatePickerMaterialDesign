package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

public class MainActivity extends AppCompatActivity {
    TextView dateDate;
    Button buttonDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateDate = findViewById(R.id.dateDate);
        buttonDate = findViewById(R.id.buttonDate);

        MaterialDatePicker datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select Date").setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build();

        buttonDate.setOnClickListener(v -> {
            datePicker.show(getSupportFragmentManager(),"Material Date Picker");
            datePicker.addOnPositiveButtonClickListener(selection -> {
                dateDate.setText(datePicker.getHeaderText());
                buttonDate.setText(datePicker.getHeaderText());
            });
        });
    }
}