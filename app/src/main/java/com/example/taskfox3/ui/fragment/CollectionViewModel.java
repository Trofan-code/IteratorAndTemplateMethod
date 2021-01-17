package com.example.taskfox3.ui.fragment;

import androidx.lifecycle.ViewModel;

import com.example.taskfox3.R;
import com.example.taskfox3.dto.BenchmarkItem;
import com.example.taskfox3.dto.BenchmarkModlel;
import com.example.taskfox3.dto.CollectionImplementation;
import com.example.taskfox3.dto.MapsImplementation;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;




public class CollectionViewModel extends ViewModel {
    private String sizeOfThreads;
    private String sizeOfOperations;
    private List<BenchmarkItem> dataList;
    private List<Integer> dataListBenchmark;
    private int numOfColums;
    private CollectionImplementation collectionImplementation;
    private MapsImplementation mapsImplementation;
    BenchmarkModlel benchmarkModlel;

    public String getSizeOfOperations() {
        return sizeOfOperations;
    }
    public void setSizeOfOperations(String sizeOfOperations) {
        this.sizeOfOperations = sizeOfOperations;
    }

    public String getSizeOfThreads() {
        return sizeOfThreads;
    }

    public void setSizeOfThreads(String sizeOfThreads) {
        this.sizeOfThreads = sizeOfThreads;
    }

    public CollectionViewModel(BenchmarkModlel benchmarkModlel) {
        this.benchmarkModlel = benchmarkModlel;
    }

    public CollectionViewModel(String sizeOfOperations, String sizeOfThreads) {
        this.sizeOfOperations = sizeOfOperations;
        this.sizeOfThreads = sizeOfThreads;
    }


    //https://www.youtube.com/watch?v=TwIjjTC5g7g


    public void setupItems() {
        benchmarkModlel.setupItems();

        // set list of items into ui
    }

    public void onCalculationStateChangeClicked(String elements, String threads, boolean isStart) {

        if(isStart){
            CollectionImplementation collectionImplementation = new CollectionImplementation();
            collectionImplementation.setupItems();


        }

        // start or stop calculation?

        // validate in case of start, stop - other way
        // Use TreadPool
    }

    public List<BenchmarkItem> setupItemsCollection(){
        dataList = new ArrayList<BenchmarkItem>();
        dataList.add(new BenchmarkItem(R.string.name_oper_1));
        dataList.add(new BenchmarkItem(R.string.name_oper_2));
        dataList.add(new BenchmarkItem(R.string.name_oper_3));
        dataList.add(new BenchmarkItem(R.string.name_oper_4));
        dataList.add(new BenchmarkItem(R.string.name_oper_5));
        dataList.add(new BenchmarkItem(R.string.name_oper_6));
        dataList.add(new BenchmarkItem(R.string.name_oper_7));
        return dataList;
    }
    public List<BenchmarkItem> setupItemsMaps(){
        dataList = new ArrayList<BenchmarkItem>();
        dataList.add(new BenchmarkItem(R.string.name_oper_map_1));
        dataList.add(new BenchmarkItem(R.string.name_oper_map_2));
        dataList.add(new BenchmarkItem(R.string.name_oper_map_3));

        return dataList;
    }


}
















