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

/*    По факту остается:
- анимация появления и исчезновения прогрессбара
- строковые ресурсы с форматированием/placeholder
- многократный парсинг строки в цикле
- несколько замечаний по codestyle/оптимизации
- довести валидацию до ума
- расчет для других коллекций/словарей (мапов) -> см. задание в лмс*/


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

    public int parseNumbers(String elements){
        try {
            return Integer.parseInt(elements);

        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private boolean hasListener() {
        return benchmarkView != null;
    }

    public void onCalculationStateChangeClicked(String elements, String threads, boolean isStart) {
        final List<BenchmarkItem> newCountItems;
        final List<BenchmarkItem> copyItems;

        if (isStart) {
            if (elements.length() == 0 ) {
                benchmarkView.operationError();
                benchmarkView.buttonStopped();

            } else if (threads.length() == 0) {
                benchmarkView.threadsError();
                benchmarkView.buttonStopped();
            }
            if (elements.length() != 0 && threads.length() != 0 && parseNumbers(elements)<Integer.MAX_VALUE) {
                int elementNumber = Integer.parseInt(elements);
                int elementThreads = Integer.parseInt(threads);

                newCountItems = benchmarkModel.createNewTasks();
                copyItems = new ArrayList<>(newCountItems);
                executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(elementThreads);
                if (hasListener()) {
                    benchmarkView.showProgress();
                }
                for (BenchmarkItem item : newCountItems) {
                    executor.submit(() -> {
                        try {
                            item.setMeasuredTime(benchmarkModel.measureTime(item, elementNumber));
                        } catch (Throwable e) {
                            e.printStackTrace();
                        }
                        benchmarkView.updateItem(item, newCountItems.indexOf(item));
                        copyItems.remove(item);
                        if (copyItems.isEmpty()) {
                            if (hasListener()) {
                                benchmarkView.messageCalcOver();
                                benchmarkView.hideProgress();
                                benchmarkView.buttonStopped();
                            }
                            executor.shutdownNow();
                            executor = null;
                        }
                    });

                }

            }else {
                benchmarkView.buttonStopped();
                benchmarkView.messageErrorNumberOfOperation();
            }
        } else if (executor != null) {
            benchmarkView.hideProgress();
            benchmarkView.messageCalcIsStopped();
            benchmarkView.buttonStopped();
            executor.shutdownNow();
            executor = null;
        }
    }
}
