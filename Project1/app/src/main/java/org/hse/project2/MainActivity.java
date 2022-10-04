package org.hse.project2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;
import java.util.ArrayList;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.text.InputFilter;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private TextView result2;
    private EditText number;

    private int minET = 1, maxET = 19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = findViewById(R.id.number);
        //number.setFilters(new InputFilter[] { new InputFilterMaxMin(1, 19) });

        View button = findViewById(R.id.button);
        View button2 = findViewById(R.id.button2);

        result = findViewById(R.id.result);
        result2 = findViewById(R.id.result2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { clickButton(); }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { clickButton2(); }
        });

        number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    int input = Integer.parseInt(charSequence.toString());

                    if (input < minET || input > maxET) {
                        Toast.makeText(getApplicationContext(),
                                        "Выход за диапазон!", Toast.LENGTH_SHORT)
                                .show();
                        button.setEnabled(false);
                        button2.setEnabled(false);
                    }
                    else {
                        button.setEnabled(true);
                        button2.setEnabled(true);
                    }
                }
                catch (NumberFormatException e) {
                    button.setEnabled(false);
                    button2.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void clickButton() {
        String numberVal = number.getText().toString();

        if (numberVal.isEmpty()) {
            numberVal = "0";
        }

        int count = Integer.parseInt(numberVal);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(i + 1);
        }

        int sum = list.stream().mapToInt(Integer::intValue).sum();
        result.setText(String.format("Result: %d", sum));
    }

    private void clickButton2() {
        String numberVal = number.getText().toString();

        if (numberVal.isEmpty()) {
            numberVal = "0";
        }

        int count = Integer.parseInt(numberVal);

        if (count < 2) {
            result2.setText("Result: 0");
        }
        else {
            int res = 1;

            for (int i = 2; i <= count; i += 2) {
                res *= i;
            }

            result2.setText(String.format("Result: %d", res));
        }
    }
}