package com.example.taskfox3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.taskfox3.R;
import com.example.taskfox3.ui.main.PageViewModel;


public class BlankFragmentCollection extends Fragment {
    private TextView tvExample;




    public BlankFragmentCollection() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_blank_collection, container, false);
    }
}