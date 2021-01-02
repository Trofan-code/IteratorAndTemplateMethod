package com.example.taskfox3.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.taskfox3.R;

public class BlankFragmentForMap extends Fragment {
    private RecyclerView recyclerView;
    private CollectionViewModel model;
    private EditText editTextOperations;
    private EditText editTextThreads;
    private BenchmarksRecyclerViewAdapter adapter; //когда делаю final - ошибка
    private Switch swStart;

    public BlankFragmentForMap() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(this).get(CollectionViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycler_view_for_map);
        adapter = new BenchmarksRecyclerViewAdapter(model.initialDataTableMap());
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        swStart = view.findViewById(R.id.btn_start_stop);
        editTextOperations = view.findViewById(R.id.et_elements);
        editTextThreads = view.findViewById(R.id.et_threads);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank_map, container, false);
    }
}
