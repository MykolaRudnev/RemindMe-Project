package com.example.mykolarudnev.remindme.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mykolarudnev.remindme.dto.RemindDto;
import com.example.mykolarudnev.remindme.fragment.AbstractTabFragment;
import com.example.mykolarudnev.remindme.fragment.BirthdaysFragment;
import com.example.mykolarudnev.remindme.fragment.HistoryFragment;
import com.example.mykolarudnev.remindme.fragment.IdeasFragment;
import com.example.mykolarudnev.remindme.fragment.TodoFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Николай on 15.06.2017.
 */

public class TabsFragmentAdapter extends FragmentPagerAdapter {
    private Map<Integer,AbstractTabFragment> tabs;
    private Context context;
    private List<RemindDto> data;
    private HistoryFragment historyFragment;



    public TabsFragmentAdapter(Context context, FragmentManager fm,List<RemindDto> data) {
        super(fm);
        this.data = data;
       this.context = context;
        initTabaMap(context);
    }
    @Override
    public CharSequence getPageTitle(int position) {

        return tabs.get(position).getTitle();
    }
    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }
    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabaMap(Context context) {
        tabs = new HashMap<>();
        historyFragment =HistoryFragment.getInstance(context,data);
        tabs.put(0, historyFragment);
        tabs.put(1, IdeasFragment.getInstance(context));
        tabs.put(2, TodoFragment.getInstance(context));
        tabs.put(3, BirthdaysFragment.getInstance(context));
    }
    public void setData(List<RemindDto> data) {
        this.data = data;
        historyFragment.refreshData(data);
    }
}
