package com.example.taskfox3;

import android.os.Bundle;

import com.example.taskfox3.model.DataTable;
import com.google.android.material.tabs.TabLayout;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.taskfox3.ui.main.SectionsPagerAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText sizeColl;
    private EditText sizeOfTreads;
    private Switch aSwitch;
    private CollectionViewModel collectionViewModel;
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
        sizeOfTreads=findViewById(R.id.editTextTreads);
        collectionViewModel = new ViewModelProvider(this).get(CollectionViewModel.class);//Тем самым получим доступ к провайдеру,
        // который хранит все ViewModel для этого Activity.
        collectionViewModel.getDataTable().observe(this, new Observer<List<DataTable>>() {
            @Override
            public void onChanged(List<DataTable> dataTables) {

            }
        });





        Switch sw = (Switch) findViewById(R.id.switchButton);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if(!isEmpty(sizeColl)){
                    collectionViewModel.setSizeOfCollections(sizeColl.getText().toString());
                    collectionViewModel.setSizeOfThreads(sizeOfTreads.getText().toString());
                    collectionViewModel.setBtnSwitch(true);
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