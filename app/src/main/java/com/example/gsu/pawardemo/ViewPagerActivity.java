package com.example.gsu.pawardemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;

import com.example.gsu.pawardemo.Fragment.ContentFragment;
import com.example.gsu.pawardemo.Fragment.HistoryFragment;
import com.example.gsu.pawardemo.Fragment.LoginFragment;
import com.example.gsu.pawardemo.adapter.ViewPagerAdapter;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {

    public ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    private TableLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
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

}
