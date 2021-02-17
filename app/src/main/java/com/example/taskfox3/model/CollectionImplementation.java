package com.example.taskfox3.model;

import com.example.taskfox3.R;
import com.example.taskfox3.dto.BenchmarkItem;
import com.example.taskfox3.dto.Types;
import com.example.taskfox3.ui.fragment.BenchmarkFragment;

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
        ArrayList<Integer> dataListBenchmark = new ArrayList<Integer>(Collections.nCopies(amount, 1));

        switch (task.getTaskName()) {
            case R.string.name_oper_1:
                task.setMeasuredTime(addingInTheBeginning(dataListBenchmark));
            case R.string.name_oper_2:
                task.setMeasuredTime(addingInTheMiddle(dataListBenchmark));
            case R.string.name_oper_3:
                task.setMeasuredTime(addingInTheEnd(dataListBenchmark));
            case R.string.name_oper_4:
                task.setMeasuredTime(searchByValue(dataListBenchmark));
            case R.string.name_oper_5:
                task.setMeasuredTime(removingInTheBeginning(dataListBenchmark));
            case R.string.name_oper_6:
                task.setMeasuredTime(removingInTheMiddle(dataListBenchmark));
            case R.string.name_oper_7:
                task.setMeasuredTime(removingInTheEnd(dataListBenchmark));
            default:
                throw new RuntimeException("Exeption in calculation time");
        }
        // create collection
        // fill it
        // measure time
    }


    private long addingInTheBeginning(ArrayList<Integer> dataListBenchmark) {
        long time = System.nanoTime();
        dataListBenchmark.add(0, 2);
        time = System.nanoTime() - time;
        return time;
    }

    private long addingInTheMiddle(ArrayList<Integer> dataListBenchmark) {
        long time = System.nanoTime();
        dataListBenchmark.add((dataListBenchmark.size() / 2), 2);
        time = System.nanoTime() - time;
        return time;
    }

    private long addingInTheEnd(ArrayList<Integer> dataListBenchmark) {
        long time = System.nanoTime();
        dataListBenchmark.add((dataListBenchmark.size() - 1), 3);
        time = System.nanoTime() - time;
        return time;
    }

    private long searchByValue(ArrayList<Integer> dataListBenchmark) {
        long time = System.nanoTime();
        dataListBenchmark.contains(374);
        time = System.nanoTime() - time;
        return time;
    }

    private long removingInTheBeginning(ArrayList<Integer> dataListBenchmark) {
        long time = System.nanoTime();
        dataListBenchmark.remove(0);
        time = System.nanoTime() - time;
        return time;
    }

    private long removingInTheMiddle(ArrayList<Integer> dataListBenchmark) {
        long time = System.nanoTime();
        dataListBenchmark.remove((dataListBenchmark.size() / 2));
        time = System.nanoTime() - time;
        return time;
    }

    private long removingInTheEnd(ArrayList<Integer> dataListBenchmark) {
        long time = System.nanoTime();
        dataListBenchmark.remove((dataListBenchmark.size() - 1));
        time = System.nanoTime() - time;
        return time;
    }


}
