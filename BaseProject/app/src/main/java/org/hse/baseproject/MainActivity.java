package org.hse.baseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View buttonStudent = findViewById(R.id.button_student);
        View buttonTeacher = findViewById(R.id.button_teacher);

        buttonTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            { showToast("Расписание для преподавателей"); };
        });
        buttonStudent.setOnClickListener(new View.OnClickListener() {
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