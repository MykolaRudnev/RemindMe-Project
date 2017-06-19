package com.example.mykolarudnev.remindme.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mykolarudnev.remindme.R;


public class HistoryFragment extends AbstractTabFragment {

    private static final int LAYOUT= R.layout.fragment_example;


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
        return view;



    }
}
