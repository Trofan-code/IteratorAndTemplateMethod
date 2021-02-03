package com.example.taskfox3.dto;

import com.example.taskfox3.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CollectionImplementation implements BenchmarkModel {
    private static long TIME = -1;
    private String elements;
    //Сделай метод: item measureTime(item, amount)
    long durationAddBeginning, durationAddMiddle, durationAddInTheEnd, durationSearchByValue;
    long durationRemovingInTheBeginning, durationRemovingInTheMiddle, durationRemovingInTheEnd;

    @Override
    public String putElements(String elements) {
        return this.elements = elements;
    }



    @Override
    public List<BenchmarkItem> itemsAfterCount() {
        List<BenchmarkItem> dataList = new ArrayList<BenchmarkItem>();
        dataList.add(new BenchmarkItem(R.string.name_oper_1,timer(addingInTheBeginning(),TimeUnit.SECONDS)));
        dataList.add(new BenchmarkItem(R.string.name_oper_2, timer(addingInTheMiddle(),TimeUnit.SECONDS)));
        dataList.add(new BenchmarkItem(R.string.name_oper_3, addingInTheEnd()));
        dataList.add(new BenchmarkItem(R.string.name_oper_4, searchByValue()));
        dataList.add(new BenchmarkItem(R.string.name_oper_5, removingInTheBeginning()));
        dataList.add(new BenchmarkItem(R.string.name_oper_6, removingInTheMiddle()));
        dataList.add(new BenchmarkItem(R.string.name_oper_7, removingInTheEnd()));
        return dataList;
    }
    private ArrayList<Long> arrayList(){
        ArrayList<Long> longTimeArrayList = new ArrayList<>();
        longTimeArrayList.add(0,itemMeasureTime(new ArrayList<Integer>(Collections.nCopies(Integer.parseInt(elements), 1)),));
        return longTimeArrayList;

    }
    public List<BenchmarkItem> exampl() {
        List<BenchmarkItem> dataList = new ArrayList<BenchmarkItem>();
        dataList.add(new BenchmarkItem(R.string.name_oper_1,timer(addingInTheBeginning(),TimeUnit.NANOSECONDS)));
        dataList.add(new BenchmarkItem(R.string.name_oper_2, timer(addingInTheMiddle(),TimeUnit.NANOSECONDS)));
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

    @Override
    public long itemMeasureTime(ArrayList<Integer> dataListBenchmark, int amount) {
        long startTime = System.nanoTime();
        itemsAfterCount().get(amount);
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }

    private long timer(Runnable method, TimeUnit timeUnit) {
        long time = System.nanoTime();
        method.run();
        time = System.nanoTime() - time;
        return TimeUnit.NANOSECONDS.convert(time, timeUnit);
    }



    private void addingInTheBeginning() {
        ArrayList<Integer> dataListBenchmark =  new ArrayList<Integer>(Collections.nCopies(Integer.parseInt(elements), 1));
        dataListBenchmark.add(0, 2);

    }

    private Runnable addingInTheMiddle() {
        ArrayList<Integer> dataListBenchmark =  new ArrayList<Integer>(Collections.nCopies(Integer.parseInt(elements), 1));
        dataListBenchmark.add((Integer.parseInt(elements)) / 2, 2);
        return addingInTheMiddle();

    }

    private long addingInTheEnd() {
        ArrayList<Integer> dataListBenchmark =  new ArrayList<Integer>(Collections.nCopies(Integer.parseInt(elements), 1));
        long startTime = System.nanoTime();
        dataListBenchmark.add((Integer.parseInt(elements)), 3);
        long endTime = System.nanoTime();
        durationAddInTheEnd = (endTime - startTime);
        return (durationAddInTheEnd/ 1000) % 60;
    }

    private long searchByValue() {
        ArrayList<Integer> dataListBenchmark =  new ArrayList<Integer>(Collections.nCopies(Integer.parseInt(elements), 1));
        long startTime = System.nanoTime();
        dataListBenchmark.contains(374);
        long endTime = System.nanoTime();
        durationSearchByValue = (endTime - startTime);
        return durationSearchByValue;
    }

    private long removingInTheBeginning() {
        ArrayList<Integer> dataListBenchmark =  new ArrayList<Integer>(Collections.nCopies(Integer.parseInt(elements), 1));
        long startTime = System.nanoTime();
        dataListBenchmark.remove(0);
        long endTime = System.nanoTime();
        durationRemovingInTheBeginning = (endTime - startTime);
        return durationRemovingInTheBeginning;
    }

    private long removingInTheMiddle() {
        ArrayList<Integer> dataListBenchmark =  new ArrayList<Integer>(Collections.nCopies(Integer.parseInt(elements), 1));
        long startTime = System.nanoTime();
        dataListBenchmark.remove((Integer.parseInt(elements)) / 2);
        long endTime = System.nanoTime();
        durationRemovingInTheMiddle = (endTime - startTime);
        return durationRemovingInTheMiddle;
    }

    private long removingInTheEnd() {
        ArrayList<Integer> dataListBenchmark =  new ArrayList<Integer>(Collections.nCopies(Integer.parseInt(elements), 1));
        long startTime = System.nanoTime();
        dataListBenchmark.remove(Integer.parseInt(elements) - 1);
        long endTime = System.nanoTime();
        durationRemovingInTheEnd = (endTime - startTime);
        return durationRemovingInTheEnd;
    }

}
