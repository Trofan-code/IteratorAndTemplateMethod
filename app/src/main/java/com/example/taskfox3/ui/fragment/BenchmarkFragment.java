package com.example.taskfox3.ui.fragment;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.taskfox3.R;
import com.example.taskfox3.dto.FactoryCollectionViewModel;

public class BenchmarkFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {
    private final BenchmarksRecyclerViewAdapter adapter = new BenchmarksRecyclerViewAdapter();
    private CollectionViewModel model;
    private EditText editTextOperations;
    private EditText editTextThreads;
    private int sizeOfOperations;
    private int sizeOfThreads;
    private Switch swStart;

    public static BenchmarkFragment newInstance(int type) {
        // use arguments to store type
        return new BenchmarkFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // access to arguments and receive a type
        model = new ViewModelProvider(this,
                new FactoryCollectionViewModel(sizeOfOperations,sizeOfThreads).get(CollectionViewModel.class));
        // get ???????????????????
        // receive data from model via listener

        if (adapter.getItemCount() == 0) {
            model.setupItems();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_benchmark, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final RecyclerView recyclerView = view.findViewById(R.id.recycler_view_for_tab);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        swStart = view.findViewById(R.id.btn_start_stop);
        editTextOperations = view.findViewById(R.id.et_elements);
        editTextThreads = view.findViewById(R.id.et_threads);
        sizeOfOperations = Integer.parseInt(editTextOperations.getText().toString());
        sizeOfThreads = Integer.parseInt(editTextThreads.getText().toString());


        swStart.setOnCheckedChangeListener(this);
        //запросить количество столбцов из viewModel
        // request amount of columns from viewModel
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        model.onCalculationStateChangeClicked(getString(editTextOperations), getString(editTextThreads), b);
    }

    private String getString(EditText editText) {
        return editText.getText().toString();
    }
}
