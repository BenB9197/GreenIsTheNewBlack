package com.example.mikey.loginvideo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String scientific = intent.getStringExtra("scientific");
        String common = intent.getStringExtra("commonName");
        String details = intent.getStringExtra("info");

        TextView scientificName = (TextView) findViewById(R.id.scientificName);
        TextView commonName = (TextView) findViewById(R.id.commonName);
        TextView detailsText = (TextView) findViewById(R.id.detailsText);

        scientificName.setText(scientific);
        commonName.setText(common);
        detailsText.setText(details);

    }
}
