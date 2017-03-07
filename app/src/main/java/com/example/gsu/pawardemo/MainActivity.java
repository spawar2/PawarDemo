package com.example.gsu.pawardemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ScaleGestureDetectorCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Gravity;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.gsu.pawardemo.bean.Book;
import com.example.gsu.pawardemo.util.UtilLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements View.OnTouchListener{

    private ImageButton bt1;
    private ImageButton bt3;
    private ImageButton activityswitch;
    private Button main_timer_bt;
    private Button main_timer_bt_2;
    private Button main_timer_bt_3;
    private GestureDetector mGestureDetector;
    private ImageButton tog_id;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @BindView(R.id.main_fl)
    RelativeLayout fl;

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
        mGestureDetector = new GestureDetector(this, new simpleGestureListener());
        fl.setOnTouchListener(this);

         mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
      //  mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
      //  mDrawerLayout.addDrawerListener(mToggle);
       // mToggle.syncState();


    }

    private void initialView(){
        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt3 = (ImageButton) findViewById(R.id.id_bt3);
        activityswitch = (ImageButton) findViewById(R.id.activityswitch);
        main_timer_bt = (Button) findViewById(R.id.main_timer_bt);
        main_timer_bt_2 = (Button) findViewById(R.id.main_timer_bt_2);
        main_timer_bt_3 = (Button) findViewById(R.id.main_timer_bt_3);
        tog_id = (ImageButton) findViewById(R.id.tog_id);
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

       main_timer_bt.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                //       Intent intent = new Intent(v.getContext(), ListViewActivity.class);
                //     startActivity(intent);
                Intent intent = new Intent(v.getContext(), Timer_Activity.class);
                startActivityForResult(intent,3);
            }
        });

        main_timer_bt_2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                //       Intent intent = new Intent(v.getContext(), ListViewActivity.class);
                //     startActivity(intent);
                Intent intent = new Intent(v.getContext(), AnimationActivity.class);
                startActivityForResult(intent,3);
            }
        });

        main_timer_bt_3.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                //       Intent intent = new Intent(v.getContext(), ListViewActivity.class);
                //     startActivity(intent);
                Intent intent = new Intent(v.getContext(), AnimatorActivity.class);
                startActivityForResult(intent,3);
            }
        });

        tog_id.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                //       Intent intent = new Intent(v.getContext(), ListViewActivity.class);
                //     startActivity(intent);
             //   Intent intent = new Intent(v.getContext(), MainActivity.class);
              //  startActivityForResult(intent,3);

                if(mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mDrawerLayout.closeDrawer(Gravity.LEFT); //CLOSE Nav Drawer!
                }else{
                    mDrawerLayout.openDrawer(Gravity.LEFT); //OPEN Nav Drawer!
                }
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


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener{
        public boolean onDown(MotionEvent e) {
            UtilLog.logD("My Gesture","onDown");
            toastShort( "onDown");
            return false;
        }

        public void onShowPress(MotionEvent e){
            UtilLog.logD("My Gesture", "onShowPress");
            toastShort("onShowPress");
        }

        public void onLongPress(MotionEvent e){
            UtilLog.logD("My Gesture", "onLongPress");
            toastShort("onLongPress");
        }

        public boolean onSingleTapUp(MotionEvent e){
            UtilLog.logD("My Gesture", "onSingleTapUp");
            toastShort("onSingleTapUp");
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent e){

            toastShort("onSingleTapConfirmed");
            return true;
        }

        public boolean onScroll (MotionEvent e1, MotionEvent e2, float distanceX , float distanceY) {
            UtilLog.logD("MyGesture", "onScroll:" + (e2.getX() - e1.getX()) + " " + distanceX);
            toastShort("onScroll");
            return true;
        }

        public boolean onFling (MotionEvent e1, MotionEvent e2, float velocityX , float velocityY) {
            toastShort("onFling");
            return true;
        }


        public boolean onDoubleTap (MotionEvent e) {
            toastShort("onDoubleTap");
            return true;
        }

        public boolean onDoubleTapEvent (MotionEvent e) {
            toastShort("onDoubleTapEvent");
            return true;
        }

    }

}
