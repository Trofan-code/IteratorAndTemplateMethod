package com.example.taskfox3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.taskfox3.MyViewModel;
import com.example.taskfox3.R;

import java.util.ArrayList;
import java.util.List;


public class BlankFragmentCollection extends Fragment {
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private List<DataTable> dataList ;
    private MyViewModel model;
    private boolean isSwitched;


    public BlankFragmentCollection() {
    }
    public static BlankFragmentCollection newInstance(){
        return new BlankFragmentCollection();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.fragment_blank_collection, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_for_tab);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        progressBar = view.findViewById(R.id.progressBar);
        RecyclerViewDataAdapter adapter;
        model = new ViewModelProvider(this).get(MyViewModel.class);
        isSwitched = model.getBtnSwitch();

        if (isSwitched == false) {
            initialDataTable();
            adapter= new RecyclerViewDataAdapter(dataList);
            recyclerView.setAdapter(adapter);
        }else{
            //delat operaciju
        }

        return view;
    }

    private List <DataTable> initialDataTable(){
        dataList = new ArrayList<>();
        dataList.add(new DataTable(R.string.name_oper_1,"0",progressBar));
        dataList.add(new DataTable(R.string.name_oper_2,"0",progressBar));
        dataList.add(new DataTable(R.string.name_oper_3,"0",progressBar));
        dataList.add(new DataTable(R.string.name_oper_4,"0",progressBar));
        dataList.add(new DataTable(R.string.name_oper_5,"0",progressBar));
        dataList.add(new DataTable(R.string.name_oper_6,"0",progressBar));
        dataList.add(new DataTable(R.string.name_oper_7,"0",progressBar));
        return dataList;
    }

}