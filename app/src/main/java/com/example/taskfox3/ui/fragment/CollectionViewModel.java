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
    ThreadPoolExecutor executor;


    public CollectionViewModel(BenchmarkModel benchmarkModel) {
        this.benchmarkModel = benchmarkModel;
    }

    public void setBenchmarkView(BenchmarkView benchmarkView) {
        this.benchmarkView = benchmarkView;
    }

    public void removeMyCustomObjectListener(BenchmarkView benchmarkView) {
        this.benchmarkView = null;
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
                benchmarkView.buttonPositionStopped();

            } else if (threads.length() == 0) {
                benchmarkView.threadsError();
                benchmarkView.buttonPositionStopped();
            }
            if (elements.length() != 0 && threads.length() != 0) {
                executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));

                final List<BenchmarkItem> newCountItems = benchmarkModel.createNewTasks();
                final List<BenchmarkItem> copyItems = new ArrayList<>(newCountItems);
                if (hasListener()) {
                    benchmarkView.showProgress();
                }
                for (BenchmarkItem item : newCountItems) {
                    try {
                    executor.submit(() -> {
                        item.setMeasuredTime(benchmarkModel.measureTime(item, Integer.parseInt(elements)));
                        benchmarkView.updateItem(item, newCountItems.indexOf(item));
                        copyItems.remove(item);

                        if (copyItems.isEmpty()) {
                            benchmarkView.returnMessageCalcDone();
                        }
                        if (hasListener()) {
                            benchmarkView.hideProgress();
                            benchmarkView.buttonPositionStopped();

                            //benchmarkView.returnMessageCalcIsStopped();
                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();}
                }
            }
           if (!isStart) {
                benchmarkView.returnMessageCalcIsStopped();
                executor.shutdownNow();
            }
        }

    }
}
