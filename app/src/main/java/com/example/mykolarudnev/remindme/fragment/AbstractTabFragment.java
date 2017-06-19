package com.example.mykolarudnev.remindme.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;


public class AbstractTabFragment extends Fragment {

    protected Context context;
    protected View view;
    protected   String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
