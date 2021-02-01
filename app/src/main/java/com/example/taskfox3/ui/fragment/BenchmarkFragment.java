package com.example.taskfox3.ui.fragment;

import android.os.Bundle;
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
import com.example.taskfox3.dto.MyCustomObjectListener;

import java.util.List;


public class BenchmarkFragment extends Fragment implements CompoundButton.OnCheckedChangeListener, MyCustomObjectListener {
    private BenchmarksRecyclerViewAdapter adapter;
    private CollectionViewModel viewModel;
    private EditText editTextOperations;
    private EditText editTextThreads;
    private Switch swStart;
    public static final String TYPE = "type";


    public static BenchmarkFragment newInstance(int type) {
        Bundle args = new Bundle();
        // use arguments to store type
        BenchmarkFragment benchmarkFragment = new BenchmarkFragment();
        args.putInt(TYPE, type);
        benchmarkFragment.setArguments(args);
        return benchmarkFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // access to arguments and receive a type
        // доступ к аргументам и получение типа
        Bundle args = new Bundle();
        int type = args.getInt(TYPE, 1);
        viewModel = new ViewModelProvider(this, new FactoryCollectionViewModel(type)).get(CollectionViewModel.class);
        viewModel.setMyCustomObjectListener(this);


        // receive data from model via listener
        // получаем данные из модели через слушателя
    }

    @Override
    public void onStart() {
        super.onStart();

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
        adapter = new BenchmarksRecyclerViewAdapter(viewModel.setupItems());
        recyclerView.setAdapter(adapter);


        swStart = view.findViewById(R.id.btn_start_stop);
        editTextOperations = view.findViewById(R.id.et_elements);
        editTextThreads = view.findViewById(R.id.et_threads);
        swStart = view.findViewById(R.id.btn_start_stop);
        swStart.setOnCheckedChangeListener(this::onCheckedChanged);
        // request amount of columns from viewModel
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewModel.removeMyCustomObjectListener(this);
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        viewModel.onCalculationStateChangeClicked(getString(editTextOperations), getString(editTextThreads), b);
        adapter.updateItems(viewModel.setNewItems2());

    }

    private String getString(EditText editText) {
        return editText.getText().toString();
    }

    @Override
    public void returnOperationError() {
        editTextOperations.setError(getText(R.string.error_1));
    }

    @Override
    public void returnThreadsError() {
        editTextThreads.setError(getText(R.string.error_2));

    }

}
