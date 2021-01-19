package com.example.taskfox3.ui.fragment;

import androidx.lifecycle.ViewModel;

import com.example.taskfox3.dto.BenchmarkItem;
import com.example.taskfox3.dto.BenchmarkModel;
import com.example.taskfox3.dto.CollectionImplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class CollectionViewModel extends ViewModel {
    private final BenchmarkModel benchmarkModel;
    private int collOreMap;
    private List<Integer> dataListBenchmark = new ArrayList<>();

    public CollectionViewModel(BenchmarkModel benchmarkModel,int collOreMap) {
        this.benchmarkModel = benchmarkModel;
        this.collOreMap=collOreMap;
    }


    //https://www.youtube.com/watch?v=TwIjjTC5g7g


    public List<BenchmarkItem> setupItems() {
        return benchmarkModel.setupItems();
        // set list of items into ui
    }

    public void onCalculationStateChangeClicked(String elements, String threads, boolean isStart) {

        if (isStart&&collOreMap==1) {
            addingInTheBeginning(elements,threads);
            addingInTheMiddle(elements,threads);
            addingInTheEnd(elements,threads);
            searchByValue(elements,threads);
            removingInTheBeginning(elements,threads);
            removingInTheMiddle(elements,threads);
            removingInTheEnd(elements,threads);
        }else if(isStart&&collOreMap==2){
           /* addingNew(elements,threads);
            searchByKey(elements,threads);
            removing(elements,threads);*/
        }

        // start or stop calculation?
        // validate in case of start, stop - other way
        // Use TreadPool
    }


    private void addingInTheBeginning(String elements, String threads) {
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark = Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            dataListBenchmark.add(0, 2);
        });
    }

    private void addingInTheMiddle(String elements, String threads) {
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark = Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            dataListBenchmark.add((Integer.parseInt(elements)) / 2, 2);
        });
    }

    private void addingInTheEnd(String elements, String threads) {
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark = Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            dataListBenchmark.add((Integer.parseInt(elements)), 3);
        });
    }

    private void searchByValue(String elements, String threads) {
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark = Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            dataListBenchmark.contains(374);
        });
    }

    private void removingInTheBeginning(String elements, String threads) {
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark = Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            dataListBenchmark.remove(0);
        });
    }

    private void removingInTheMiddle(String elements, String threads) {
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark = Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            dataListBenchmark.remove((Integer.parseInt(elements)) / 2);
        });
    }

    private void removingInTheEnd(String elements, String threads) {
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark = Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            dataListBenchmark.remove(Integer.parseInt(elements) - 1);
        });
    }

}
















