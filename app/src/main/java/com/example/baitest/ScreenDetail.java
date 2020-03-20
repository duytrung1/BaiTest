package com.example.baitest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.example.baitest.Adapter.subjects;

public class ScreenDetail extends AppCompatActivity {
    ImageView imgae;
    TextView name, age, salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_detail);
        setTitle("Screen Detail");
        imgae = findViewById(R.id.image);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        salary = findViewById(R.id.salary);
        name.setText(subjects.getEmployeeName());
        age.setText(subjects.getEmployeeAge());
        salary.setText(subjects.getEmployeeSalary());
        Glide.with(getBaseContext()).load(subjects.getProfileImage()).into(imgae);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.iteam:
                finish();

                return super.onOptionsItemSelected(item);
        }
        return true;
    }

}
