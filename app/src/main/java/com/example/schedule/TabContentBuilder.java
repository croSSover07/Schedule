package com.example.schedule;


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TabHost.TabContentFactory;

public class TabContentBuilder implements TabContentFactory {

    private final Context mContext;

    public TabContentBuilder(Context context) {
        mContext = context;
    }

    public View createTabContent(String tag) {
        View v = new View(mContext);
        v.setMinimumWidth(0);
        v.setMinimumHeight(0);
        v.setBackgroundColor(Color.BLACK);
        return v;
    }
}
