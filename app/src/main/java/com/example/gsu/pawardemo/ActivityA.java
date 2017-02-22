package com.example.gsu.pawardemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ActivityA extends AppCompatActivity {

    private ImageButton activityswitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
    }


    private void initialView(){
        activityswitch = (ImageButton) findViewById(R.id.activityswitch);
    }

    private void initialListener() {

        activityswitch.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), ActivityA.class);
                startActivity(intent);

            }
        });
    }


}
