package com.example.taskfox3.ui.fragment;

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
                benchmarkView.buttonPositionReturnBack();

            } else if (threads.length() == 0) {
                benchmarkView.threadsError();
                benchmarkView.buttonPositionReturnBack();
            }
            if (elements.length() != 0 && threads.length() != 0) {
                final List<BenchmarkItem> newCountItems = benchmarkModel.createNewTasks();
                final List<BenchmarkItem> copyItems = new ArrayList<>(newCountItems);
                ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));

                if (hasListener()) {
                    benchmarkView.showProgress();
                }
                for (BenchmarkItem item : newCountItems) {
                    executor.submit(() -> {
                        item.setMeasuredTime(benchmarkModel.measureTime(item, Integer.parseInt(elements)));

                        benchmarkView.updateItem(item, newCountItems.indexOf(item));
                        copyItems.remove(item);

                        if (copyItems.isEmpty()) {
                            benchmarkView.returnMessageCalcDone();
                            if (hasListener()) {
                                benchmarkView.hideProgress();
                            }
                        }
                    });
                }
            }
        }
    }
}
