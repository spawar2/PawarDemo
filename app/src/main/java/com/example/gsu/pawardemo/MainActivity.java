package com.example.gsu.pawardemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.gsu.pawardemo.bean.Book;
import com.example.gsu.pawardemo.util.UtilLog;

import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {

    private ImageButton bt1;
    private ImageButton bt3;
    private ImageButton activityswitch;

    @OnClick(R.id.bt2)
    public void button2Click(){
        Intent intent = new Intent(this, DialogActivity.class);
        startActivityForResult(intent,2);
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
        activityswitch = (ImageButton) findViewById(R.id.activityswitch);
    }

    private void initialListener() {
        bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                        public void onClick(View v){
                    Toast.makeText(v.getContext(),"Button1 was clicked", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(v.getContext(), ViewPagerActivity.class);
                    intent.putExtra("key","value");
                    Bundle bundle = new Bundle();
                    bundle.putInt("Integer", 12345);
                    Book book = new Book();
                    book.setName("Android");
                    book.setAuthor("Pawar");
                    bundle.putSerializable("book", book);
                    intent.putExtras(bundle);
                    startActivityForResult(intent, 1);
                }


        });

        bt3.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

         //       Intent intent = new Intent(v.getContext(), ListViewActivity.class);
           //     startActivity(intent);
                Intent intent = new Intent(v.getContext(), ListViewActivity.class);
                startActivityForResult(intent,3);
            }
        });


        activityswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityA.class);
                 startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                String message = data.getStringExtra("Message");
                toastShort(message);
                break;
            case 2:

                toastShort("Dialog");
                break;
            case 3:
                toastShort("ListView");
                break;
            default:
        }
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
