package com.example.taskfox3;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.taskfox3.ui.main.PageViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.example.taskfox3.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private PageViewModel pageViewModel;
    private EditText arrayLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        pageViewModel.getLengthArrayList().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String lengthArrayList) {
                // update UI
                pageViewModel.setLengthArrayList(arrayLength.getText().toString());
            }
        });
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
        arrayLength = findViewById(R.id.editTextLen);
    }
}