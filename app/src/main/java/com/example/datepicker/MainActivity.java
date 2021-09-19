package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

public class MainActivity extends AppCompatActivity {
    TextView dateDate;
    Button buttonDate,buttonDateT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateDate = findViewById(R.id.dateDate);
        buttonDate = findViewById(R.id.buttonDate);
        buttonDateT = findViewById(R.id.buttonDateT);

        MaterialDatePicker datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select Date From").setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build();

        MaterialDatePicker datePicker2 = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select Date To").setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build();


        buttonDate.setOnClickListener(v -> {
            datePicker.show(getSupportFragmentManager(),"Material Date Picker");
            datePicker.addOnPositiveButtonClickListener(selection -> {
                //dateDate.setText(datePicker.getHeaderText());
                buttonDate.setText(datePicker.getHeaderText());

                String d = datePicker.getHeaderText();
                Toast.makeText(getApplicationContext(), d, Toast.LENGTH_SHORT).show();
            });
        });

        buttonDateT.setOnClickListener(v -> {
            datePicker2.show(getSupportFragmentManager(),"Material Date Picker");
            datePicker2.addOnPositiveButtonClickListener(selection -> {
               // dateDate.setText(datePicker2.getHeaderText());
                buttonDateT.setText(datePicker2.getHeaderText());

                //String d = datePicker.getHeaderText();
                //Toast.makeText(getApplicationContext(), d, Toast.LENGTH_SHORT).show();
            });
        });
    }
}