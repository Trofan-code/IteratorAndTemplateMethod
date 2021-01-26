package com.example.taskfox3.ui.fragment;

import androidx.lifecycle.ViewModel;

import com.example.taskfox3.dto.BenchmarkItem;
import com.example.taskfox3.dto.BenchmarkModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class CollectionViewModel extends ViewModel {
    private final BenchmarkModel benchmarkModel;
    private List<Integer> dataListBenchmark = new ArrayList<>();
    private Map<Integer, Integer> operationHashMap;

    public CollectionViewModel(BenchmarkModel benchmarkModel) {
        this.benchmarkModel = benchmarkModel;

    }

    //https://www.youtube.com/watch?v=TwIjjTC5g7g


    public List<BenchmarkItem> setupItems() {
        return benchmarkModel.setupItems();
        // set list of items into ui
    }

    public void onCalculationStateChangeClicked(String elements, String threads, boolean isStart) {

        if (isStart) {
            benchmarkModel.returnMapOrColl(elements, threads);
        } else if (!isStart) {

        }

        // start or stop calculation?
        // validate in case of start, stop - other way
        // Use TreadPool
    }


}
















