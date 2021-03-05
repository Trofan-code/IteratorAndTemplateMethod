package com.example.taskfox3.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.taskfox3.R;
import com.example.taskfox3.dto.BenchmarkItem;
import com.example.taskfox3.dto.Types;
import com.example.taskfox3.model.FactoryCollectionViewModel;

import java.util.List;


public class BenchmarkFragment extends Fragment implements CompoundButton.OnCheckedChangeListener, BenchmarkView {

    public static final String TYPE = "type";
    private final BenchmarksRecyclerViewAdapter adapter = new BenchmarksRecyclerViewAdapter();
    private CollectionViewModel viewModel;
    private EditText editTextOperations;
    private EditText editTextThreads;
    private Switch swStart;

    private View layout;
    private static final String TAG = "MyApp";
    final Handler handler =  new Handler(Looper.getMainLooper());


    public static BenchmarkFragment newInstance(int type) { //prichodit 0-coll, 1-mapy
        final BenchmarkFragment benchmarkFragment = new BenchmarkFragment();
        // use arguments to store type
        final Bundle args = new Bundle();
        args.putInt(TYPE, type);
        benchmarkFragment.setArguments(args);
        return benchmarkFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        final Bundle args = this.getArguments();
        final int type = args.getInt(TYPE, Types.COLLECTIONS);
        viewModel = new ViewModelProvider(this, new FactoryCollectionViewModel(type)).get(CollectionViewModel.class);
        viewModel.setBenchmarkView(this);
        setRetainInstance(true);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_benchmark, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // progressBar = view.findViewById(R.id.progressBar);
        final RecyclerView recyclerView = view.findViewById(R.id.recycler_view_for_tab);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        editTextOperations = view.findViewById(R.id.et_elements);
        editTextThreads = view.findViewById(R.id.et_threads);
        swStart = view.findViewById(R.id.btn_start_stop);
        swStart.setOnCheckedChangeListener(this);



    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        if (adapter.isEmpty()) {
            viewModel.getNewItemsList();
        }


    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
        viewModel.removeMyCustomObjectListener(this);
    }




    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        Log.d(TAG, "onCheckedChanged");
        viewModel.onCalculationStateChangeClicked(getString(editTextOperations), getString(editTextThreads), b);

    }

    @Override
    public void buttonPositionReturnBack(){
        swStart.toggle();

        swStart.setClickable(false);
        // как вернуть обратно

    }


    private String getString(EditText editText) {
        return editText.getText().toString();
    }

    @Override
    public void operationError() {
        editTextOperations.setError(getText(R.string.error_1));
    }

    @Override
    public void threadsError() {
        editTextThreads.setError(getText(R.string.error_2));
    }

    @Override
    public void setTasks(List<BenchmarkItem> newTasks) {
        adapter.setItems(newTasks);
    }

    @Override
    public void updateItem(BenchmarkItem newItem, int position) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                adapter.setNewItem(newItem, position);
                Log.d(TAG, " updateItem  updateItem  updateItem  updateItem updateItem");


            }
        });
    }

    @Override
    public void startProgressBar(boolean b) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(b) {
                    getView().findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
                }//else if(!b) getView().findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
            }
        });
    }



    @Override
    public void returnMessageCalcDone() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(),"Calculation is over!!!!!!!!!!!!",Toast.LENGTH_SHORT).show();
            }
        });

    }


}
