package com.example.taskfox3.ui.fragment;

import androidx.lifecycle.ViewModel;

import com.example.taskfox3.dto.BenchmarkItem;
import com.example.taskfox3.dto.BenchmarkModel;
import com.example.taskfox3.dto.MyCustomObjectListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class CollectionViewModel extends ViewModel {
    private final BenchmarkModel benchmarkModel;
    private MyCustomObjectListener myCustomObjectListener;

    public void setMyCustomObjectListener(MyCustomObjectListener myCustomObjectListener) {
        this.myCustomObjectListener = myCustomObjectListener;
    }


    public CollectionViewModel(BenchmarkModel benchmarkModel) {
        this.benchmarkModel = benchmarkModel;

    }

    //https://www.youtube.com/watch?v=TwIjjTC5g7g


    public List<BenchmarkItem> setupItems() {
        return benchmarkModel.setupItems();
        // set list of items into ui
    }

    public void onCalculationStateChangeClicked(String elements, String threads, boolean isStart) {

        if (isStart&&elements==null) {
            benchmarkModel.returnMapOrColl(elements, threads);
        } else if (!isStart) {

        }
//        if (getString(editTextOperations).length() == 0) {
//            editTextOperations.setError("Num of operation is required!");
//        } else if (getString(editTextThreads).length() == 0) {
//            editTextThreads.setError("Num of threads is required!");
//        } else {
//            viewModel.onCalculationStateChangeClicked(getString(editTextOperations), getString(editTextThreads), b);
//        }

        // start or stop calculation?
        // validate in case of start, stop - other way
        // Use TreadPool
    }


}
















