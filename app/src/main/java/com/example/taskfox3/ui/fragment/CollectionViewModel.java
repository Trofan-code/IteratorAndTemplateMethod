package com.example.taskfox3.ui.fragment;

import androidx.lifecycle.ViewModel;

import com.example.taskfox3.dto.BenchmarkItem;
import com.example.taskfox3.dto.BenchmarkModel;
import com.example.taskfox3.dto.MyCustomObjectListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class CollectionViewModel extends ViewModel {
    private final BenchmarkModel benchmarkModel;
    private MyCustomObjectListener myCustomObjectListener;
    private List<BenchmarkItem> newCountItems = new ArrayList<>();

    public void setMyCustomObjectListener(MyCustomObjectListener myCustomObjectListener) {
        this.myCustomObjectListener = myCustomObjectListener;
    }

    public void removeMyCustomObjectListener(MyCustomObjectListener myCustomObjectListener) {
        this.myCustomObjectListener = null;
    }


    public CollectionViewModel(BenchmarkModel benchmarkModel) {
        this.benchmarkModel = benchmarkModel;

    }

    public List<BenchmarkItem> setupItems() {
        return benchmarkModel.setupItems();
        // set list of items into ui
    }

    public void onCalculationStateChangeClicked(String elements, String threads, boolean isStart) {
        benchmarkModel.putElements(elements);
        List<BenchmarkItem> newCountItems = new ArrayList<>();
        List<BenchmarkItem> copyItems = setupItems();
        int[] arr = {0};
        if (elements.length() != 0 && threads.length() != 0 && isStart) {
            for (int i = 0; i < copyItems.size(); i++) {
                ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
                executor.submit(() -> {

                    if (copyItems != null) {
                        // benchmarkModel.returnNewData().get(i);
                       // newCountItems.add(arr[0],benchmarkModel.itemMeasureTime(benchmarkModel.itemsAfterCount().get(0),0));
                        newCountItems.add(arr[0]++, benchmarkModel.itemsAfterCount().get(arr[0]++));
                        copyItems.remove(arr[0]++);
                    }

                });
            }
        } else if (elements.length() == 0 && isStart) {
            myCustomObjectListener.operationError();
        } else if (threads.length() == 0 && isStart) {
            myCustomObjectListener.threadsError();
        }
        // start or stop calculation?
        // validate in case of start, stop - other way
        // Use TreadPool
    }

    public List<BenchmarkItem> setNewItems2() {
        return benchmarkModel.itemsAfterCount();
        // set list of items into ui
    }

    public List setNewItems() {
        return newCountItems;
        // set new list of items into ui
    }


}
















