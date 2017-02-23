package com.example.gsu.pawardemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ActivityC extends AppCompatActivity {

    private Button toC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        initialView();
        initialListener();
    }


    private void initialView(){
        toC = (Button) findViewById(R.id.toC);
    }

    private void initialListener() {

        toC.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), ActivityC.class);
                startActivity(intent);

            }
        });
    }
}
