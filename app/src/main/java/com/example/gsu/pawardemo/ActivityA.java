package com.example.gsu.pawardemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ActivityA extends AppCompatActivity {

    private Button toA;
    private Button toB;
    private Button toC;
    private Button toD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
        initialView();
        initialListener();
    }


    private void initialView(){
        toA = (Button) findViewById(R.id.toA);
        toB = (Button) findViewById(R.id.toB);
        toC = (Button) findViewById(R.id.toC);
        toD = (Button) findViewById(R.id.toD);
    }

    private void initialListener() {

        toA.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), ActivityA.class);
                startActivity(intent);

            }
        });

        toB.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), ActivityB.class);
                startActivity(intent);

            }
        });

        toC.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), ActivityC.class);
                startActivity(intent);

            }
        });

        toD.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), ActivityD.class);
                startActivity(intent);

            }
        });


    }

}
