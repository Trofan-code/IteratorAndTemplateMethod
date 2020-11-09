package com.example.taskfox3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.taskfox3.R;
import com.example.taskfox3.ui.main.PageViewModel;

import java.util.ArrayList;
import java.util.List;


public class BlankFragmentCollection extends Fragment {
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    List<DataTable> dataList ;

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
        initialDataTable();
        View view = inflater.inflate(R.layout.fragment_blank_collection, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_for_tab);
        recyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        progressBar = view.findViewById(R.id.progressBar);
        DataAdapter adapter = new DataAdapter(dataList);
        recyclerView.setAdapter(adapter);

        //better GridLayoutManager

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