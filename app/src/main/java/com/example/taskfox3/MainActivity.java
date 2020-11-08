package com.example.taskfox3;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.taskfox3.fragment.DataAdapter;
import com.example.taskfox3.fragment.DataTable;
import com.example.taskfox3.ui.main.PageViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.example.taskfox3.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PageViewModel pageViewModel;
    private EditText arrayLength;
    private RecyclerView recyclerView;
    private List<DataTable> dataList;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initialDataTable();

     /*   Switch sw = (Switch) findViewById(R.id.switchButton);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                } else {
                    // The toggle is disabled
                }
            }
        });*/
    }

    private void init(){
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        progressBar = findViewById(R.id.progressBar);
        arrayLength = findViewById(R.id.editTextLen);
        recyclerView = findViewById(R.id.recycler_view_for_tab);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // poczytać o tym
        DataAdapter adapter = new DataAdapter(dataList);
        recyclerView.setAdapter(adapter);
    }
    private void initialDataTable(){
        dataList = new ArrayList<>();
        dataList.add(new DataTable(R.string.name_oper_1,"0",progressBar));
        dataList.add(new DataTable(R.string.name_oper_2,"0",progressBar));
        dataList.add(new DataTable(R.string.name_oper_3,"0",progressBar));
        dataList.add(new DataTable(R.string.name_oper_4,"0",progressBar));
        dataList.add(new DataTable(R.string.name_oper_5,"0",progressBar));
        dataList.add(new DataTable(R.string.name_oper_6,"0",progressBar));
        dataList.add(new DataTable(R.string.name_oper_7,"0",progressBar));
    }
}