package org.hse.baseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        View button = findViewById(R.id.button);
        View button2 = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            { showToast("Расписание для преподавателей"); };
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            { showToast("Расписание для студентов"); };
        });
    }

    private void showToast(String text) {
        Toast.makeText(getApplicationContext(), text,
                Toast.LENGTH_SHORT).show();
    }
}