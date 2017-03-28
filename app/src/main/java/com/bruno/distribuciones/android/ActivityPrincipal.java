package com.bruno.distribuciones.android;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bruno.distribuciones.R;


public class ActivityPrincipal extends AppCompatActivity {


    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence titulos[]={"Por Abscisa","Por Probabilidad", "Tablas"};
    int cantTabs = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        adapter =  new ViewPagerAdapter(getSupportFragmentManager(),titulos,cantTabs);


        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);


        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.colorTabScroll);
            }
        });

        tabs.setViewPager(pager);
        getSupportActionBar().hide();


    }

}
