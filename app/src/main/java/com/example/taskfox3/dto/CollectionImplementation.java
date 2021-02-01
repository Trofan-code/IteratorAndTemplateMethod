package com.example.taskfox3.dto;

import com.example.taskfox3.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionImplementation implements BenchmarkModel {
    private static long TIME = -1;
    private String elements;
    private List<BenchmarkItem> dataList;
    private List<Integer> dataListBenchmark;
    long durationAddBeginning, durationAddMiddle, durationAddInTheEnd, durationSearchByValue;
    long durationRemovingInTheBeginning, durationRemovingInTheMiddle, durationRemovingInTheEnd;

    @Override
    public String putElements(String elements) {
        return this.elements = elements;
    }

    @Override
    public List<BenchmarkItem> returnNewData() {
        dataList = new ArrayList<BenchmarkItem>();
        dataList.add(new BenchmarkItem(R.string.name_oper_1, addingInTheBeginning()));
        dataList.add(new BenchmarkItem(R.string.name_oper_2, addingInTheMiddle()));
        dataList.add(new BenchmarkItem(R.string.name_oper_3, addingInTheEnd()));
        dataList.add(new BenchmarkItem(R.string.name_oper_4, searchByValue()));
        dataList.add(new BenchmarkItem(R.string.name_oper_5, removingInTheBeginning()));
        dataList.add(new BenchmarkItem(R.string.name_oper_6, removingInTheMiddle()));
        dataList.add(new BenchmarkItem(R.string.name_oper_7, removingInTheEnd()));
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

    private long addingInTheBeginning() {
        dataListBenchmark = new ArrayList<>();
        dataListBenchmark = Collections.nCopies(Integer.parseInt(elements), 1);
        long startTime = System.nanoTime();
        dataListBenchmark.add(0, 2); //UnsupportedOperationException
        long endTime = System.nanoTime();
        durationAddBeginning = (endTime - startTime);
        return durationAddBeginning;
    }

    private long addingInTheMiddle() {
        dataListBenchmark = new ArrayList<>();
        dataListBenchmark = Collections.nCopies(Integer.parseInt(elements), 1);
        long startTime = System.nanoTime();
        dataListBenchmark.add((Integer.parseInt(elements)) / 2, 2);
        long endTime = System.nanoTime();
        durationAddMiddle = (endTime - startTime);
        return durationAddMiddle;
    }

    private long addingInTheEnd() {
        dataListBenchmark = new ArrayList<>();
        dataListBenchmark = Collections.nCopies(Integer.parseInt(elements), 1);
        long startTime = System.nanoTime();
        dataListBenchmark.add((Integer.parseInt(elements)), 3);
        long endTime = System.nanoTime();
        durationAddInTheEnd = (endTime - startTime);
        return durationAddInTheEnd;
    }

    private long searchByValue() {
        dataListBenchmark = new ArrayList<>();
        dataListBenchmark = Collections.nCopies(Integer.parseInt(elements), 1);
        long startTime = System.nanoTime();
        dataListBenchmark.contains(374);
        long endTime = System.nanoTime();
        durationSearchByValue = (endTime - startTime);
        return durationSearchByValue;
    }

    private long removingInTheBeginning() {
        dataListBenchmark = new ArrayList<>();
        dataListBenchmark = Collections.nCopies(Integer.parseInt(elements), 1);
        long startTime = System.nanoTime();
        dataListBenchmark.remove(0);
        long endTime = System.nanoTime();
        durationRemovingInTheBeginning = (endTime - startTime);
        return durationRemovingInTheBeginning;
    }

    private long removingInTheMiddle() {
        dataListBenchmark = new ArrayList<>();
        dataListBenchmark = Collections.nCopies(Integer.parseInt(elements), 1);
        long startTime = System.nanoTime();
        dataListBenchmark.remove((Integer.parseInt(elements)) / 2);
        long endTime = System.nanoTime();
        durationRemovingInTheMiddle = (endTime - startTime);
        return durationRemovingInTheMiddle;
    }

    private long removingInTheEnd() {
        dataListBenchmark = new ArrayList<>();
        dataListBenchmark = Collections.nCopies(Integer.parseInt(elements), 1);
        long startTime = System.nanoTime();
        dataListBenchmark.remove(Integer.parseInt(elements) - 1);
        long endTime = System.nanoTime();
        durationRemovingInTheEnd = (endTime - startTime);
        return durationRemovingInTheEnd;
    }

}
