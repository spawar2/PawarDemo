package com.example.gsu.pawardemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;

import com.example.gsu.pawardemo.Fragment.ContentFragment;
import com.example.gsu.pawardemo.Fragment.HistoryFragment;
import com.example.gsu.pawardemo.Fragment.LoginFragment;
import com.example.gsu.pawardemo.adapter.ViewPagerAdapter;
import com.example.gsu.pawardemo.bean.Book;
import com.example.gsu.pawardemo.util.UtilLog;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {

    public ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    private TableLayout tabLayout;
    public Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        Intent intent =getIntent();
        Bundle bundle = intent.getExtras();
        String message = intent.getStringExtra("key");
        int number = bundle.getInt("Integer", 0);
        int fakeNumber = bundle.getInt("fake",0);
        Book book = (Book) bundle.getSerializable("book");

        UtilLog.logD("ViewPagerActivity, value is: ", message);
        UtilLog.logD("ViewPagerActivity, value is: ", ""+number);
        UtilLog.logD("ViewPagerActivity, fake number is: ", String.valueOf(fakeNumber));
        UtilLog.logD("ViewPagerActivity, book author is: ", book.getAuthor());
        initial();
    }



    private void initial(){

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        fragmentList.add(new LoginFragment());
        fragmentList.add(new ContentFragment());
        fragmentList.add(new HistoryFragment());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("Message", "ViewPager");
        setResult(RESULT_OK, intent);
        super.onBackPressed();

    }
}
