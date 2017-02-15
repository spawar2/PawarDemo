package com.example.gsu.pawardemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.gsu.pawardemo.util.UtilLog;

import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {

    private ImageButton bt1;
    private ImageButton bt3;

    @OnClick(R.id.bt2)

    public void button2Click(){
    toActivity(DialogActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
        ButterKnife.bind(this);

    }

    private void initialView(){
        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt3 = (ImageButton) findViewById(R.id.id_bt3);
    }

    private void initialListener() {
        bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                        public void onClick(View v){
                    Toast.makeText(v.getContext(),"Button1 was clicked", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(v.getContext(), ViewPagerActivity.class);
                    startActivity(intent);
                }


        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(ListViewActivity.class);

         //       Intent intent = new Intent(v.getContext(), ListViewActivity.class);
           //     startActivity(intent);
            }
        });
    }

    public void onClick(View v) {
    //    Toast.makeText(this,"Button2 was clicked", Toast.LENGTH_LONG).show();  //resource consumeing , can be used for login button reflection java run time method just need to use once
        toastLong("Button 2 was clicked");
        UtilLog.logD("testD", "Toast");
        // log.d("testD", "Toast");
        // log.e("testE", "Toast");
        // log.i("testI", "Toast");
        // log.v("testI", "Toast");
        // log.w("testI", "Toast");

    }


}
