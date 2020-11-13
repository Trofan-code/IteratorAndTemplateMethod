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
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.taskfox3.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText sizeColl;
    private Switch aSwitch;
    private MyViewModel myViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        sizeColl = findViewById(R.id.editTextLen);

        Switch sw = (Switch) findViewById(R.id.switchButton);
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if(!isEmpty(sizeColl)){
                    myViewModel.setSizeOfCollAndMaps(sizeColl.getText().toString());
                    myViewModel.setBtnSwitch(true);
                    // The toggle is enabled
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Введи размер Коллекции и Мапа", Toast.LENGTH_SHORT);
                    toast.show();
                    String userSizeString = sizeColl.getText().toString();
                    if(TextUtils.isEmpty(userSizeString)) {
                        sizeColl.setError("The item cannot be empty"); //potom narisowat textinputlayout


                        return; }
                        // The toggle is disabled
                }
                    sizeColl.setError(null);
                }
            }

            private boolean isEmpty(EditText sizeColl) {
                return sizeColl.getText().toString().trim().length() == 0; }

        });


    }

}