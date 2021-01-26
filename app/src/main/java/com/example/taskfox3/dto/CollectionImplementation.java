package com.example.taskfox3.dto;

import com.example.taskfox3.R;
import com.example.taskfox3.ui.fragment.CollectionViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CollectionImplementation implements BenchmarkModel {
    private static long TIME = -1;
    private List<BenchmarkItem> dataList;
    private List<Integer> dataListBenchmark;
    long durationAddBeginning, durationAddMiddle, durationAddInTheEnd, durationSearchByValue;
    long durationRemovingInTheBeginning, durationRemovingInTheMiddle, durationRemovingInTheEnd;

    @Override
    public List<BenchmarkItem> returnMapOrColl(String elements, String threads) {
        dataList = new ArrayList<BenchmarkItem>();
        dataList.add(new BenchmarkItem(R.string.name_oper_1, addingInTheBeginning(elements, threads)));
        dataList.add(new BenchmarkItem(R.string.name_oper_2, addingInTheMiddle(elements, threads)));
        dataList.add(new BenchmarkItem(R.string.name_oper_3, addingInTheEnd(elements, threads)));
        dataList.add(new BenchmarkItem(R.string.name_oper_4, searchByValue(elements, threads)));
        dataList.add(new BenchmarkItem(R.string.name_oper_5, removingInTheBeginning(elements, threads)));
        dataList.add(new BenchmarkItem(R.string.name_oper_6, removingInTheMiddle(elements, threads)));
        dataList.add(new BenchmarkItem(R.string.name_oper_7, removingInTheEnd(elements, threads)));
        return dataList;
    }

    public List<BenchmarkItem> setupItems() {
        List<BenchmarkItem> dataList = new ArrayList<>();
        dataList.add(new BenchmarkItem(R.string.name_oper_1, TIME));
        dataList.add(new BenchmarkItem(R.string.name_oper_2, TIME));
        dataList.add(new BenchmarkItem(R.string.name_oper_3, TIME));
        dataList.add(new BenchmarkItem(R.string.name_oper_4, TIME));
        dataList.add(new BenchmarkItem(R.string.name_oper_5, TIME));
        dataList.add(new BenchmarkItem(R.string.name_oper_6, TIME));
        dataList.add(new BenchmarkItem(R.string.name_oper_7, TIME));
        return dataList;
    }

    private long addingInTheBeginning(String elements, String threads) {
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark = Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            long startTime = System.nanoTime();
            dataListBenchmark.add(0, 2);
            long endTime = System.nanoTime();
            durationAddBeginning = (endTime - startTime);
        });
        return durationAddBeginning;
    }

    private long addingInTheMiddle(String elements, String threads) {
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark = Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            long startTime = System.nanoTime();
            dataListBenchmark.add((Integer.parseInt(elements)) / 2, 2);
            long endTime = System.nanoTime();
            durationAddMiddle = (endTime - startTime);
        });
        return durationAddMiddle;
    }

    private long addingInTheEnd(String elements, String threads) {
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark = Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            long startTime = System.nanoTime();
            dataListBenchmark.add((Integer.parseInt(elements)), 3);
            long endTime = System.nanoTime();
            durationAddInTheEnd = (endTime - startTime);
        });
        return durationAddInTheEnd;
    }

    private long searchByValue(String elements, String threads) {
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark = Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            long startTime = System.nanoTime();
            dataListBenchmark.contains(374);
            long endTime = System.nanoTime();
            durationSearchByValue = (endTime - startTime);
        });
        return durationSearchByValue;
    }

    private long removingInTheBeginning(String elements, String threads) {
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark = Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            long startTime = System.nanoTime();
            dataListBenchmark.remove(0);
            long endTime = System.nanoTime();
            durationRemovingInTheBeginning = (endTime - startTime);
        });
        return durationRemovingInTheBeginning;
    }

    private long removingInTheMiddle(String elements, String threads) {
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark = Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            long startTime = System.nanoTime();
            dataListBenchmark.remove((Integer.parseInt(elements)) / 2);
            long endTime = System.nanoTime();
            durationRemovingInTheMiddle = (endTime - startTime);
        });
        return durationRemovingInTheMiddle;
    }

    private long removingInTheEnd(String elements, String threads) {
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark = Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            long startTime = System.nanoTime();
            dataListBenchmark.remove(Integer.parseInt(elements) - 1);
            long endTime = System.nanoTime();
            durationRemovingInTheEnd = (endTime - startTime);
        });
        return durationRemovingInTheEnd;
    }

}
