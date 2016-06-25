package com.example.schedule.TabDays;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.schedule.R;

/**
 * Created by UMF on 05.04.2016.
 */
public class SixFragment extends Fragment {
    String[] values=new String[]{"India", "java", "c++","Ad.Java", "Linux", "Unix"};
    ListView lv;
    public SixFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Create a new TextView and set its text to the fragment's section
        // number argument value.
        View v = inflater.inflate(R.layout.activity_six_fragment,null);
        perform(v);
        return v;
    }
    public void perform(View v) {
        lv = (ListView) v.findViewById(R.id.list_item1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.my_list_item, values);
        lv.setAdapter(adapter);
    }
}
