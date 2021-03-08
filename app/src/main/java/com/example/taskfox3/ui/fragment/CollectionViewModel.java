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
    private ThreadPoolExecutor executor;
    final List<BenchmarkItem> copyItems = new ArrayList<>();


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
                benchmarkView.buttonStopped();

            } else if (threads.length() == 0) {
                benchmarkView.threadsError();
                benchmarkView.buttonStopped();
            }
            final List<BenchmarkItem> newCountItems = benchmarkModel.createNewTasks();
            //final List<BenchmarkItem> copyItems = new ArrayList<>(newCountItems);
            if (elements.length() != 0 && threads.length() != 0) {
                executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
                if (hasListener()) {
                    benchmarkView.showProgress();
                }
                for (BenchmarkItem item : newCountItems) {
                    executor.submit(() -> {
                        //try {
                            item.setMeasuredTime(benchmarkModel.measureTime(item, Integer.parseInt(elements)));
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        /*}catch (Exception e){
                                e.printStackTrace();}*/
                        benchmarkView.updateItem(item, newCountItems.indexOf(item));
                        copyItems.remove(item);
                        if (hasListener()) {
                            benchmarkView.hideProgress();
                            benchmarkView.messageCalcDone();
                        }


                      /*  if (isStart&&copyItems.isEmpty()) {
                            benchmarkView.buttonStopped();
                        }else  {
                            benchmarkView.hideProgress();
                            benchmarkView.messageCalcIsStopped();
                            benchmarkView.buttonStopped();
                            executor.shutdownNow();
                        }*/

                            /*else if (!isStart&&!copyItems.isEmpty()) {
                            benchmarkView.hideProgress();
                            benchmarkView.messageCalcIsStopped();
                            benchmarkView.buttonStopped();
                            executor.shutdownNow();

                        }*/
                    });
                }

            }/*if (!isStart&&!copyItems.isEmpty()) {
                benchmarkView.hideProgress();
                benchmarkView.messageCalcIsStopped();
                benchmarkView.buttonStopped();
                executor.shutdownNow();

            }else {}*/

            }




    }
}
