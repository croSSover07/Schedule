package com.example.schedule;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

import com.example.schedule.Exemplar.Facultie;
import com.example.schedule.Exemplar.Group;
import com.example.schedule.Exemplar.Specialty;
import com.example.schedule.Exemplar.week;
import com.example.schedule.interfaces.get_faculties;
import com.example.schedule.interfaces.get_groups;
import com.example.schedule.interfaces.get_schedule;
import com.example.schedule.interfaces.get_specialties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends FragmentActivity implements OnTabChangeListener, OnPageChangeListener {

    private TabViewPageAdapter mAdapter;
    private ViewPager mViewPager;
    private TabHost mTabHost;
    private HorizontalScrollView mhorizontalScroll;




    int currentnumberday;



    private final String URL = "http://zschedule.gorlachov.com";
    private Gson gson = new GsonBuilder().create();
    private Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(URL)
            .build();

    private get_schedule intf_get_schedules = retrofit.create(get_schedule.class);
    private get_groups intf_get_groups = retrofit.create(get_groups.class);
    private get_faculties intf_get_facultie = retrofit.create(get_faculties.class);
    private get_specialties intf_get_specialties = retrofit.create(get_specialties.class);


    private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> adapter2;
    private ArrayAdapter<String> adapter3;


    private ArrayList<String> val1 = new ArrayList<>();
    private ArrayList<String> val2 = new ArrayList<>();
    private ArrayList<String> val3 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Spinner spinner_fac = (Spinner) findViewById(R.id.spinner_faculty);
        final Spinner spinner_spec=(Spinner) findViewById(R.id.spinner_specilty);
        final Spinner spinner_group=(Spinner) findViewById(R.id.spinner_group);



        final current_globall mcurrent_Globall =(current_globall)getApplicationContext();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //region getFaculties
        Call<Facultie[]> call4=intf_get_facultie.getFaculties();

        try {
            ArrayList<Facultie> myArr=new ArrayList<>();
            Response<Facultie[]> response = call4.execute();
            for(Facultie p:response.body() )
            {
                myArr.add(p);
            }
            mcurrent_Globall.setAll_facultie(   myArr );
            // final week mweek= ((current_globall)getApplicationContext()).getWeek() ;
            Log.i("LOL", "  111111");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //endregion

        //region getSpecialties
        Call<Specialty[]> call5=intf_get_specialties.getSpecialties();

        try {
            ArrayList<Specialty> myArr=new ArrayList<>();
            Response<Specialty[]> response = call5.execute();
            for(Specialty p:response.body() )
            {
                myArr.add(p);
            }
            mcurrent_Globall.setAll_specialties(   myArr );
            // final week mweek= ((current_globall)getApplicationContext()).getWeek() ;
            Log.i("LOL", "  111111");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //endregion

        //region getGroups
        Call<Group[]> call3=intf_get_groups.getGroups();

        try {
            ArrayList<Group> myArr=new ArrayList<>();
            Response<Group[]> response = call3.execute();
            for(Group p:response.body() )
            {
                myArr.add(p);
            }
             mcurrent_Globall.setAll_groups(   myArr );
           // final week mweek= ((current_globall)getApplicationContext()).getWeek() ;
            Log.i("LOL", "  111111");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //endregion










        //region select_ALL_spinner


        for(Facultie p:mcurrent_Globall.getAll_facultie())
        {
            val1.add(p.getTitle());
        }

        adapter = new ArrayAdapter<String>(this, R.layout.my_list_item_spinner, val1);
      //  adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner_fac.setAdapter(adapter);
        spinner_fac.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                val2.clear();
                int k=0;
                for(Facultie p:mcurrent_Globall.getAll_facultie())
                {
                    if( p.getTitle().equals(spinner_fac.getSelectedItem()) ){k=p.getId();}
                    Log.i("LOL",Integer.toString( k));
                }
                mcurrent_Globall.setFac_id(  k);


                for(Specialty p:mcurrent_Globall.getAll_specialties())
                {
                    if(p.getFaculty()==mcurrent_Globall.getFac_id()){
                    val2.add(p.getTitle() );}
                    Log.i("LOL","");
                }
                adapter2 = new ArrayAdapter<String>(getApplicationContext(), R.layout.my_list_item_spinner, val2);
               // adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                spinner_spec.setAdapter(adapter2);

                spinner_spec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        val3.clear();
                        int k=0;
                        for(Specialty p: mcurrent_Globall.getAll_specialties())
                        {
                            if(p.getTitle().equals( spinner_spec.getSelectedItem()))
                            {
                                k=p.getId();mcurrent_Globall.setSpec_id(k);
                            }
                        }

                        for(Group p: mcurrent_Globall.getAll_groups())
                        {
                            if(p.getSpecialty()==mcurrent_Globall.getSpec_id())
                            {
                                val3.add(p.getTitle());
                            }
                        }
                        adapter3 = new ArrayAdapter<String>(getApplicationContext(), R.layout.my_list_item_spinner, val3);
                    //    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_group.setAdapter(adapter3);
                        spinner_group.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                for (Group p:mcurrent_Globall.getAll_groups())
                                {
                                    if(p.getTitle().equals(spinner_group.getSelectedItem())) {mcurrent_Globall.setGroup_id(p.getId());
                                        getschedule();break;
                                    }
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        //endregion



        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mhorizontalScroll = (HorizontalScrollView) findViewById(R.id.mhorizontalScroll);

        // Tab Initialization
        initialiseTabHost();
        mAdapter = new TabViewPageAdapter(getSupportFragmentManager());
        // Fragments and ViewPager Initialization


        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(MainActivity.this);
        //region get_current_day
        Calendar calendar = Calendar.getInstance();
        currentnumberday = calendar.get(Calendar.DAY_OF_WEEK);
        // Log.i("LOL","curr: "+ Integer.toString( currentnumberday));
        int now_or_next_day=0;
        if(calendar.get(Calendar.HOUR_OF_DAY)>17){now_or_next_day=1;}

         Log.i("LOL","hour: "+ Integer.toString( calendar.get(Calendar.HOUR_OF_DAY)));
        switch (currentnumberday+now_or_next_day) {
            case   Calendar.SATURDAY:
            case   Calendar.SUNDAY:
            case   Calendar.MONDAY:  mTabHost.setCurrentTabByTag("tab1");break;
            case   Calendar.TUESDAY:mTabHost.setCurrentTabByTag("tab2");break;
            case   Calendar.WEDNESDAY:mTabHost.setCurrentTabByTag("tab3");break;
            case   Calendar.THURSDAY:mTabHost.setCurrentTabByTag("tab4");break;
            case   Calendar.FRIDAY:mTabHost.setCurrentTabByTag("tab5");break;
        }
        //endregion



    }


    private void getschedule()
    {
        final current_globall mcurrent_Globall =(current_globall)getApplicationContext();
        //region getSchedule
        // Map<String, String> mapjson = new HashMap<String, String>();
        //  mapjson.put("group","СП-12-1д");
        int group_id=mcurrent_Globall.getGroup_id();
        Call<week> call2=intf_get_schedules.getSchedule( group_id);

        try {
            Response<week> response = call2.execute();
            mcurrent_Globall.setWeek(response.body());
            final week mweek= ((current_globall)getApplicationContext()).getWeek() ;
            Log.i("LOL", "  111111");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //endregion
    }
    // Method to add a TabHost
    private static void AddTab(MainActivity activity, TabHost tabHost, TabHost.TabSpec tabSpec) {
        tabSpec.setContent(new TabContentBuilder(activity));
        tabHost.addTab(tabSpec);
    }

    // Manages the Tab changes, synchronizing it with Pages
    public void onTabChanged(String tag) {
        int pos = this.mTabHost.getCurrentTab();
        this.mViewPager.setCurrentItem(pos);
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
    }

    // Manages the Page changes, synchronizing it with Tabs
    @Override
    public void onPageScrolled(int position, float arg1, int arg2) {
        int pos = this.mViewPager.getCurrentItem();
        this.mTabHost.setCurrentTab(pos);
//HORIZENTAL SCROLL VIEW MOVE USING scrollTo() Method
        mhorizontalScroll.scrollTo(100*position, 0);
        mhorizontalScroll.refreshDrawableState();
    }

    @Override
    public void onPageSelected(int arg0) {
    }


    // Tabs Creation
    private void initialiseTabHost() {
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup();

        // TODO Put here your Tabs
        MainActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("tab1").setIndicator("ПН"));
        MainActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("tab2").setIndicator("ВТ"));
        MainActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("tab3").setIndicator("СР"));
        MainActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("tab4").setIndicator("ЧТ"));
        MainActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("tab5").setIndicator("ПТ"));

        //MainActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("tab6").setIndicator("СБ"));

        //DEFINE WIDTH OF EACH TAB
        mTabHost.getTabWidget().getChildAt(0).getLayoutParams().width = 100;
        mTabHost.getTabWidget().getChildAt(1).getLayoutParams().width = 100;
        mTabHost.getTabWidget().getChildAt(2).getLayoutParams().width = 100;
        mTabHost.getTabWidget().getChildAt(3).getLayoutParams().width = 100;
        mTabHost.getTabWidget().getChildAt(4).getLayoutParams().width = 100;

      //  mTabHost.getTabWidget().getChildAt(0).setBackgroundResource(R.color.pink2);

        // Change background
        for(int i=0; i < 5; i++) {
            mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.color.pink2);
//mTabHost.getTabWidget().getChildAt(i).se
        }
        // Change background
//        for(int i=0; i < mTabHost.getChildCount(); i++)
  //          mTabHost.getChildAt(i).setBackgroundColor(Color.BLACK);

        // mTabHost.getTabWidget().getChildAt(2).getLayoutParams().width = 200;
        mTabHost.setOnTabChangedListener(this);





    }

}
