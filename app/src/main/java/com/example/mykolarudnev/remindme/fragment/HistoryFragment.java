package com.example.mykolarudnev.remindme.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mykolarudnev.remindme.R;
import com.example.mykolarudnev.remindme.adapter.RemindListAdapter;
import com.example.mykolarudnev.remindme.dto.RemindDto;

import java.util.ArrayList;
import java.util.List;


public class HistoryFragment extends AbstractTabFragment {

    private static final int LAYOUT= R.layout.fragment_history;


    public static HistoryFragment getInstance(Context context){

        Bundle args = new Bundle();
        HistoryFragment fragment = new HistoryFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.Tab_item_history));
        return fragment;

    }



    public void setContext(Context context) {
        this.context = context;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT,container,false);
        RecyclerView rv =(RecyclerView) view.findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter( new RemindListAdapter(createMockRemindListData()));


        return view;



    }

    private List<RemindDto> createMockRemindListData() {
       List<RemindDto> data = new ArrayList<>();
        data.add(new RemindDto("Item 1 "));
        data.add(new RemindDto("Item 2 "));
        data.add(new RemindDto("Item 3 "));
        data.add(new RemindDto("Item 4 "));
        data.add(new RemindDto("Item 5 "));
        data.add(new RemindDto("Item 6 "));

        return  data;
    }
}
