package com.example.taskfox3.ui.fragment;

import androidx.lifecycle.ViewModel;

import com.example.taskfox3.dto.BenchmarkItem;
import com.example.taskfox3.dto.BenchmarkModel;
import com.example.taskfox3.dto.CollectionImplementation;

import java.util.List;


public class CollectionViewModel extends ViewModel {
    private String sizeOfThreads;
    private String sizeOfOperations;
    BenchmarkModel benchmarkModel;
    private List<BenchmarkItem> setupItemsImpl;

    public List<BenchmarkItem> getSetupItemsImpl() {
        return setupItemsImpl;
    }

    public CollectionViewModel() {
    }

    public CollectionViewModel(List<BenchmarkItem> setupItemsImpl) {
        this.setupItemsImpl = setupItemsImpl;
    }

    public CollectionViewModel(String sizeOfOperations, String sizeOfThreads) {
        this.sizeOfOperations = sizeOfOperations;
        this.sizeOfThreads = sizeOfThreads;
    }
    //https://www.youtube.com/watch?v=TwIjjTC5g7g


    public List<BenchmarkItem> setupItems() {
        return setupItemsImpl;

        // set list of items into ui
    }

    public void onCalculationStateChangeClicked(String elements, String threads, boolean isStart) {

        if (isStart) {
            CollectionImplementation collectionImplementation = new CollectionImplementation();
            collectionImplementation.setupItems();

        }

        // start or stop calculation?
        // validate in case of start, stop - other way
        // Use TreadPool
    }
}
















