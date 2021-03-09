package com.example.taskfox3.model;

import com.example.taskfox3.R;
import com.example.taskfox3.dto.BenchmarkItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        ArrayList<Integer> dataListBenchmark = new ArrayList<>(Collections.nCopies(amount, 1));

        switch (task.getTaskName()) {
            case R.string.name_oper_1:
                return addingInTheBeginning(dataListBenchmark);

            case R.string.name_oper_2:
                return addingInTheMiddle(dataListBenchmark);

            case R.string.name_oper_3:
                return addingInTheEnd(dataListBenchmark);

            case R.string.name_oper_4:
                return searchByValue(dataListBenchmark);

            case R.string.name_oper_5:
                return removingInTheBeginning(dataListBenchmark);

            case R.string.name_oper_6:
                return removingInTheMiddle(dataListBenchmark);

            case R.string.name_oper_7:
                return removingInTheEnd(dataListBenchmark);

            default:
                throw new RuntimeException("Exeption in calculation time");
        }
    }


    private long addingInTheBeginning(ArrayList<Integer> dataListBenchmark) {
        long time = System.nanoTime();
        dataListBenchmark.add(0, 2);
        return System.nanoTime() - time;
    }

    private long addingInTheMiddle(ArrayList<Integer> dataListBenchmark) {
        long time = System.nanoTime();
        dataListBenchmark.add((dataListBenchmark.size() / 2), 2);
        return System.nanoTime() - time;
    }

    private long addingInTheEnd(ArrayList<Integer> dataListBenchmark) {
        long time = System.nanoTime();
        dataListBenchmark.add((dataListBenchmark.size() - 1), 3);
        return System.nanoTime() - time;
    }

    private long searchByValue(ArrayList<Integer> dataListBenchmark) {
        long time = System.nanoTime();
        dataListBenchmark.contains(374);
        return System.nanoTime() - time;
    }

    private long removingInTheBeginning(ArrayList<Integer> dataListBenchmark) {
        long time = System.nanoTime();
        dataListBenchmark.remove(0);
        return System.nanoTime() - time;
    }

    private long removingInTheMiddle(ArrayList<Integer> dataListBenchmark) {
        long time = System.nanoTime();
        dataListBenchmark.remove((dataListBenchmark.size() / 2));
        return System.nanoTime() - time;
    }

    private long removingInTheEnd(ArrayList<Integer> dataListBenchmark) {
        long time = System.nanoTime();
        dataListBenchmark.remove((dataListBenchmark.size() - 1));
        return System.nanoTime() - time;
    }
}
