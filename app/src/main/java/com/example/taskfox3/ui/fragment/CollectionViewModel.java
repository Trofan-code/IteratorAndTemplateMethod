package com.example.taskfox3.ui.fragment;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.taskfox3.dto.BenchmarkItem;
import com.example.taskfox3.model.BenchmarkModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class CollectionViewModel extends ViewModel {
    private final BenchmarkModel benchmarkModel;
    private BenchmarkView benchmarkView;
    private static final String TAG = "MyApp";

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
                ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
                for (BenchmarkItem item : newCountItems) {
                    try {
                        executor.submit(() -> {
                            Log.d(TAG, "JA w potokie");
                            item.setMeasuredTime(benchmarkModel.measureTime(item, Integer.parseInt(elements)));
                            Log.d(TAG, "setMeasuredTime");
                            if (!copyItems.isEmpty()) {
                                Log.d(TAG, "Vnutri if isEmpty copyItems");
                                benchmarkView.updateItem(item, newCountItems.indexOf(item));
                                copyItems.remove(item);
                            }
                        });//koniec potoka
                    } catch (Throwable exception) {
                        throw new RuntimeException("Lambda exeption");
                    }
                    Log.d(TAG, "Posle potokow");
                }

            }
        } else {
        } // koniec ifa ot isStart
    }
}
















