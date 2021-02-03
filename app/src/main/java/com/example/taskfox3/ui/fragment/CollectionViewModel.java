package com.example.taskfox3.ui.fragment;

import androidx.lifecycle.ViewModel;

import com.example.taskfox3.dto.BenchmarkItem;
import com.example.taskfox3.model.BenchmarkModel;
import com.example.taskfox3.model.BenchmarkView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class CollectionViewModel extends ViewModel {
    private final BenchmarkModel benchmarkModel;
    private BenchmarkView benchmarkView;

    public void setBenchmarkView(BenchmarkView benchmarkView) {
        this.benchmarkView = benchmarkView;
    }

    public void removeMyCustomObjectListener(BenchmarkView benchmarkView) {
        this.benchmarkView = null;
    }


    public CollectionViewModel(BenchmarkModel benchmarkModel) {
        this.benchmarkModel = benchmarkModel;

    }

    public void getNewItemsList() {
        if (hasListener()) {
            benchmarkView.setTasks(benchmarkModel.createNewTasks());
        }
    }

    private boolean hasListener() {
        return benchmarkView != null;
    }

    public void onCalculationStateChangeClicked(String elements, String threads, boolean isStart) {
        if (isStart) {
            if (elements.length() == 0) {
                benchmarkView.operationError();
            } else if (threads.length() == 0) {
                benchmarkView.threadsError();
            }
            if (elements.length() != 0 && threads.length() != 0) {
                final List<BenchmarkItem> newCountItems = benchmarkModel.createNewTasks();
                final List<BenchmarkItem> copyItems = new ArrayList<>(newCountItems);

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
            }
        } else {

        }
    }
}
















