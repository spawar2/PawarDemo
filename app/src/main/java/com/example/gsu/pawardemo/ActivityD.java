package com.example.gsu.pawardemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityD extends AppCompatActivity {

    private Button toD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        initialView();
        initialListener();
    }


    private void initialView(){
        toD = (Button) findViewById(R.id.toD);
    }

    private void initialListener() {

        toD.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), ActivityD.class);
                startActivity(intent);

            }
        });
    }
}
