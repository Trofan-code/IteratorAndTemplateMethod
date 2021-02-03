package com.example.taskfox3.model;

import com.example.taskfox3.R;
import com.example.taskfox3.dto.BenchmarkItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CollectionImplementation implements BenchmarkModel {

    @Override
    public List<BenchmarkItem> createNewTasks() {
        final List<BenchmarkItem> items = new ArrayList<>();
        items.add(new BenchmarkItem(R.string.name_oper_1));
        items.add(new BenchmarkItem(R.string.name_oper_2));
        items.add(new BenchmarkItem(R.string.name_oper_3));
        items.add(new BenchmarkItem(R.string.name_oper_4));
        items.add(new BenchmarkItem(R.string.name_oper_5));
        items.add(new BenchmarkItem(R.string.name_oper_6));
        items.add(new BenchmarkItem(R.string.name_oper_7));
        return items;
    }

    @Override
    public long measureTime(BenchmarkItem task, int amount) {
        // create collection
        // fill it
        // measure time
        return 0;
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
