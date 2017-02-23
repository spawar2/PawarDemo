package com.example.gsu.pawardemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ActivityB extends AppCompatActivity {

    private Button toB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        initialView();
        initialListener();
    }


    private void initialView(){
        toB = (Button) findViewById(R.id.toB);
    }

    private void initialListener() {

        toB.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), ActivityB.class);
                startActivity(intent);

            }
        });
    }
}
