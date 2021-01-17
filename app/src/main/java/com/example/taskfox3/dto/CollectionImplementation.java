package com.example.taskfox3.dto;

import com.example.taskfox3.R;
import com.example.taskfox3.ui.fragment.CollectionViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CollectionImplementation implements BenchmarkModlel {
    int numOfColums;
    private List<BenchmarkItem> dataList;
    private List<Integer> dataListBenchmark;
    CollectionViewModel model ;
    long durationAddBeginning, durationAddMiddle, durationAddInTheEnd, durationSearchByValue;
    long durationRemovingInTheBeginning, durationRemovingInTheMiddle, durationRemovingInTheEnd;
    @Override
    public List<BenchmarkItem> setupItems() {
        dataList = new ArrayList<BenchmarkItem>();
        dataList.add(new BenchmarkItem(R.string.name_oper_1,addingInTheBeginning(model.getSizeOfOperations(),model.getSizeOfThreads())));
        dataList.add(new BenchmarkItem(R.string.name_oper_2,addingInTheMiddle(model.getSizeOfOperations(),model.getSizeOfThreads())));
        dataList.add(new BenchmarkItem(R.string.name_oper_3,addingInTheEnd(model.getSizeOfOperations(),model.getSizeOfThreads())));
        dataList.add(new BenchmarkItem(R.string.name_oper_4,searchByValue(model.getSizeOfOperations(),model.getSizeOfThreads())));
        dataList.add(new BenchmarkItem(R.string.name_oper_5,removingInTheBeginning(model.getSizeOfOperations(),model.getSizeOfThreads())));
        dataList.add(new BenchmarkItem(R.string.name_oper_6,removingInTheMiddle(model.getSizeOfOperations(),model.getSizeOfThreads())));
        dataList.add(new BenchmarkItem(R.string.name_oper_7,removingInTheEnd(model.getSizeOfOperations(),model.getSizeOfThreads())));
        return dataList;
    }
    public int returnNumOfColums(){
        return 7;
    }

    /*@Override
    public long countTime() {
            long startTime = System.nanoTime();
            // methodToTrackTimeFor();
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            return duration;

    }*/
    private long addingInTheBeginning(String elements, String threads){
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark =  Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            long startTime = System.nanoTime();
            dataListBenchmark.add(0, 2);
            long endTime = System.nanoTime();
            durationAddBeginning = (endTime - startTime);
        });
        return durationAddBeginning;
    };
    private long addingInTheMiddle(String elements, String threads){
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark =  Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            long startTime = System.nanoTime();
            dataListBenchmark.add((Integer.parseInt(elements))/2, 2);
            long endTime = System.nanoTime();
            durationAddMiddle = (endTime - startTime);
        });
        return durationAddMiddle;
    };
    private long addingInTheEnd(String elements, String threads){
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark =  Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            long startTime = System.nanoTime();
            dataListBenchmark.add((Integer.parseInt(elements)), 3);
            long endTime = System.nanoTime();
            durationAddInTheEnd = (endTime - startTime);
        });
        return durationAddInTheEnd;
    };
    private long searchByValue(String elements, String threads){
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark =  Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            long startTime = System.nanoTime();
            dataListBenchmark.contains(374);
            long endTime = System.nanoTime();
            durationSearchByValue = (endTime - startTime);
        });
        return durationSearchByValue;
    };
    private long removingInTheBeginning(String elements, String threads){
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark =  Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            long startTime = System.nanoTime();
            dataListBenchmark.remove(0);
            long endTime = System.nanoTime();
            durationRemovingInTheBeginning = (endTime - startTime);
        });
        return durationRemovingInTheBeginning;
    };
    private long  removingInTheMiddle(String elements, String threads){
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark =  Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            long startTime = System.nanoTime();
            dataListBenchmark.remove((Integer.parseInt(elements))/2);
            long endTime = System.nanoTime();
            durationRemovingInTheMiddle = (endTime - startTime);
        });
        return durationRemovingInTheMiddle;
    };
    private long  removingInTheEnd(String elements, String threads){
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark =  Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            long startTime = System.nanoTime();
            dataListBenchmark.remove(Integer.parseInt(elements)-1);
            long endTime = System.nanoTime();
            durationRemovingInTheEnd = (endTime - startTime);
        });
        return durationRemovingInTheEnd;
    };

}
