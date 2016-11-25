package com.example.mikey.loginvideo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

//        final EditText etName = (EditText) findViewById(R.id.etName);
        final Button bmap = (Button) findViewById(R.id.bmap);
        final Button blearn = (Button) findViewById(R.id.blearn);
//        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final TextView welcomeMessage = (TextView) findViewById(R.id.welcome);

        bmap.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent mapIntent = new Intent(UserAreaActivity.this, MapsActivity.class);
                UserAreaActivity.this.startActivity(mapIntent);
            }
        });

        blearn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent learnIntent = new Intent(UserAreaActivity.this, WildLifeActivity.class);
                UserAreaActivity.this.startActivity(learnIntent);
            }
        });

        /**
         * Getting the information that was sent over.
         */
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
//        String username = intent.getStringExtra("username");

        String message = "Main Menu";
        welcomeMessage.setText(message);
//        etName.setText(name);
//        etUsername.setText(username);
    }
}
