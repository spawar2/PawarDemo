package com.example.gsu.pawardemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Timer_Activity extends BaseActivity {


    private int time;

    @BindView(R.id.timer_et)
    EditText editText;

    @BindView(R.id.timer_bt)
    Button timerButton;


    Handler mhandler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            time--;
            if (time>0){
                editText.setText(String.valueOf(time));
                mhandler.postDelayed(this,1000);
           //     mhandler.post(this);
            }
        }
    };


    final View.OnClickListener start = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            editText.setEnabled(false);
            time = Integer.valueOf(editText.getText().toString());
            timerButton.setText("Stop");
            timerButton.setOnClickListener(stop);
            mhandler.postDelayed(runnable,1000);

        }
    };


    final View.OnClickListener stop = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            timerButton.setText("Reset");
            timerButton.setOnClickListener(reset);
            mhandler.removeCallbacks(runnable);
        }
    };


    final View.OnClickListener reset = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            editText.setEnabled(true);
            timerButton.setText("start");
            timerButton.setOnClickListener(start);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_);
        ButterKnife.bind(this);
        timerButton.setOnClickListener(start);
    }
}
