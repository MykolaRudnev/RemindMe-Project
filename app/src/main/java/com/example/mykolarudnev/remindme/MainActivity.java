package com.example.mykolarudnev.remindme;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.mykolarudnev.remindme.adapter.TabsFragmentAdapter;
import com.example.mykolarudnev.remindme.dto.RemindDto;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Николай on 03.06.2017.
 */

public class MainActivity extends AppCompatActivity {
    private static final int LAYOUT=R.layout.activity_main;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private TabsFragmentAdapter adapter;
    private ViewPager viewPager;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        initToolbar();
        initNavigationView();
        initTabs();

    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });
        toolbar.inflateMenu(R.menu.menu);
    }


    private void initTabs() {
        viewPager=(ViewPager) findViewById(R.id.viewPager);
        adapter = new TabsFragmentAdapter(getApplicationContext(), getSupportFragmentManager(), new ArrayList<RemindDto>());
        viewPager.setAdapter(adapter);

       new RemindMeTask().execute();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }


    private void initNavigationView() {

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout,toolbar,
                R.string.view_navigation_open,R.string.view_navigation_close);

        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

               drawerLayout.closeDrawers();
                switch (item.getItemId()){
                    case R.id.actionNotificationItem:
                        showNotificationTab();
                }
                return true;
            }

        });
    }

    private void showNotificationTab(){

        viewPager.setCurrentItem(Constant.TAB_TWO);

    }


    private class RemindMeTask extends AsyncTask<Void,Void,RemindDto>{

        @Override
        protected RemindDto doInBackground(Void... params) {
            RestTemplate template = new RestTemplate();
            template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            return template.getForObject(Constant.URL.GET_REMIND_ITEM,RemindDto.class);
        }

        @Override
        protected void onPostExecute(RemindDto remindDto) {
            List <RemindDto> data = new ArrayList<>();
            data.add(remindDto);

            adapter.setData(data);
        }

    }

}
