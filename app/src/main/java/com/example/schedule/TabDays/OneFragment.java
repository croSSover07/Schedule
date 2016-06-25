package com.example.schedule.TabDays;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.schedule.R;
import com.example.schedule.Exemplar.classes;
import com.example.schedule.current_globall;
import com.example.schedule.Exemplar.week;

import java.util.ArrayList;

/**
 * Created by UMF on 05.04.2016.
 */
public class OneFragment extends Fragment {

//     Struct_classes[] mylessons=new Struct_classes[]
//             {
//             new Struct_classes("Безпека програм та даних","Полякова Н.П","лек","ауд.40"),
//             new Struct_classes("Безпека програм та даних","Полякова Н.П","лаб","ОЦ-3")
//              };

    ListView lv;
    public OneFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Create a new TextView and set its text to the fragment's section
        // number argument value.
        View v = inflater.inflate(R.layout.activity_one_fragment,null);
        perform(v);
        return v;
    }
    public void perform(View v) {


        lv = (ListView) v.findViewById(R.id.list_item1);
        ArrayList<String> val = new ArrayList<>();

        final week mweek= ((current_globall)getContext().getApplicationContext()).getWeek() ;
        if (mweek==null){val.add("");}
        else {
        ArrayList<classes> day= mweek.getMonday();

        //String[] values=new String[]{day.get(2).getClassroom().toString(),"Менеджмент проектів програмного забезпечення\n Новікова О.С. \nлек ауд.38","Методи та алгоритми прийняття рішень\nБезверхий А.I.\nлаб ОЦ-3"};
      //  String[] values=new String[] {day.get(0).getSubject_title().toString() +"\n"+day.get(0).getT1_last_name().toString() + " "+ day.get(0).getT1_first_name().substring(0,1)+"."+day.get(0).getT1_middle_name().substring(0,1)+"."+"\n"+day.get(0).getType().substring(0,3)+". "+day.get(0).getClassroom().toString() ,};
        Log.i("LOL",Integer.toString( day.size()));
        String[] values=new String[day.size()];
        Log.i("LOL",Integer.toString( day.size()));


                                                                                                //    "num":1,
                                                                                        //            "subject_title":"Менеджмент проектів ПЗ",
                                                                                        //            "t1_chair":"ст.викл.",
                                                                                        //            "t1_last_name":"Новікова",
                                                                                        //            "t1_first_name":"Ольга",
                                                                                        //            "t1_middle_name":"Сергіївна",
                                                                                        //            "t2_chair":null,
                                                                                        //            "t2_last_name":null,
                                                                                        //            "t2_first_name":null,
                                                                                        //            "t2_middle_name":null,
                                                                                        //            "classroom":"ауд.40",
                                                                                        //            "type":"лекція"

       // Log.i("LOL",day.get(3).getSubject_title().toString());
        int count=0;
        for(int i=0;i<day.size();i++ )
        {
            if(day.get(i).getSubject_title()==null )
            {
                if(count==0)
                {
                    values[i] = "";
                    continue;
                }
                else continue;
               // values[i]=day.get(i).getSubject_title().toString();
                //values[i].
            }

            count++;
            //сделать правильное заполнение
            values[i]=day.get(i).getSubject_title().toString() +"\n"+day.get(i).getT1_last_name().toString() + " "+ day.get(i).getT1_first_name().substring(0,1)+"."+day.get(i).getT1_middle_name().substring(0,1)+"."+"\n"+day.get(i).getType().substring(0,3)+". "+day.get(i).getClassroom().toString();
        }
        count=0;

        int i=0;
        if(values.length!=0)
        {
            while (values[i] != null && i < values.length) {
                val.add(values[i]);
                i++;
            }
        }}
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.my_list_item, val);



        //adapter.add(mylessons[1].ToString());
       // adapter.addAll(mylessons[1].ToString());
       // adapter.addAll(mylessons[1].ToString());
        lv.setAdapter(adapter);
    }
}



