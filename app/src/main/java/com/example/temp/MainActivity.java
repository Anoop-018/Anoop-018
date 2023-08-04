package com.example.temp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private RadioGroup radioGroup;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        radioGroup = findViewById(R.id.radioGroup);
        Button convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);

        convertButton.setOnClickListener(v -> convertTemperature());
    }

    private void convertTemperature() {
        double inputValue = Double.parseDouble(editText.getText().toString());

        if (radioGroup.getCheckedRadioButtonId() == R.id.celsiusButton) {
            double fahrenheitValue = (inputValue * 9/5) + 32;
            resultTextView.setText(getString(R.string.result_fahrenheit, fahrenheitValue));
        } else {
            double celsiusValue = (inputValue - 32) * 5/9;
            resultTextView.setText(getString(R.string.result_celsius, celsiusValue));
        }
    }
}
