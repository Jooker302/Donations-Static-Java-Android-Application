package com.example.donations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CyclicNumberPicker numberPicker;
    EditText editText;
    TextView totaltext;
    Button donate;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.inputamount);
        numberPicker = findViewById(R.id.numberPicker);
        totaltext = findViewById(R.id.totaltext);
        donate = findViewById(R.id.donate);
        progressBar = findViewById(R.id.progressBar);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
//                Toast.makeText(getApplicationContext(),String.valueOf(newVal),Toast.LENGTH_SHORT).show();
                    editText.setText(String.valueOf(newVal));
                    totaltext.setText("Total so Far $ "+ String.valueOf(newVal));
                    progressBar.setProgress(newVal,true);
            }
        });

//        EditText editText = findViewById(R.id.editText);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                String input = s.toString().trim();
//                Toast.makeText(getApplicationContext(),input,Toast.LENGTH_SHORT).show();

                if (!input.isEmpty()) {
                    int number = Integer.parseInt(input);
                    numberPicker.setValue(number);
                    totaltext.setText("Total so Far $"+ String.valueOf(number));
                    progressBar.setProgress(number,true);
                    if (number > 10000) {

                        editText.setError("Donations cannot be greater than $10,000");
                        editText.setText("10000");


                    }
                }else {
                    numberPicker.setValue(0);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int donatenumber = numberPicker.getValue();
                Toast.makeText(getApplicationContext(),"Donated $" + String.valueOf(donatenumber),Toast.LENGTH_SHORT).show();
            }
        });
    }
}