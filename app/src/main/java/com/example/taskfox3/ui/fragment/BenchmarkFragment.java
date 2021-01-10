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

import com.example.taskfox3.dto.BenchmarkItem;
import com.example.taskfox3.dto.FactoryCollectionViewModel;
import com.example.taskfox3.dto.Types;

import java.util.Collection;


public class BenchmarkFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {
    private final BenchmarksRecyclerViewAdapter adapter = new BenchmarksRecyclerViewAdapter();
    private CollectionViewModel model;
    private  EditText editTextOperations;
    private  EditText editTextThreads;
    private Switch swStart;
    private static Bundle args;


    public static BenchmarkFragment newInstance(int type) {

        // use arguments to store type
        BenchmarkFragment benchmarkFragment = new BenchmarkFragment();
        args = new Bundle();
        args.putInt("type",type);
        benchmarkFragment.setArguments(args);
        return benchmarkFragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // access to arguments and receive a type
        // доступ к аргументам и получение типа
           model = new ViewModelProvider(this, new FactoryCollectionViewModel(args)).get(CollectionViewModel.class);

        // receive data from model via listener
        // получаем данные из модели через слушателя

        if (adapter.getItemCount() == 0) {
            model.setupItemsCollection();

        }
       /* else if(adapter.getItemCount() == 1){
            model.setupItemsMaps();
        }*/
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
