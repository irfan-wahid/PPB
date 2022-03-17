package com.example.easytutonotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView titledetail, descriptiondetail, timedetail;

        titledetail = (TextView) findViewById(R.id.titledetail);
        descriptiondetail = (TextView) findViewById(R.id.descriptiondetail);
        timedetail = (TextView) findViewById(R.id.timedetail);

        Intent intentThatStartedThisActivity = getIntent();

        if (intentThatStartedThisActivity.hasExtra("title")){

            String extTitle = getIntent().getExtras().getString("title");
            String extDesc = getIntent().getExtras().getString("description");
            String extTime = getIntent().getExtras().getString("time");

            titledetail.setText(extTitle);
            descriptiondetail.setText(extDesc);
            timedetail.setText(extTime);
            setTitle(extTitle);

        }
    }
}