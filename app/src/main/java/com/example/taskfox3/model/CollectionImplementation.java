package com.example.taskfox3.model;

import com.example.taskfox3.R;
import com.example.taskfox3.dto.BenchmarkItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionImplementation implements BenchmarkModel {

    @Override
    public List<BenchmarkItem> createNewTasks() {
        final List<BenchmarkItem> items = new ArrayList<>();
        items.add(new BenchmarkItem(R.string.name_oper_1, true));
        items.add(new BenchmarkItem(R.string.name_oper_1_array, false));
        items.add(new BenchmarkItem(R.string.name_oper_1_linked, false));
        items.add(new BenchmarkItem(R.string.name_oper_1_copyOn, false));
        items.add(new BenchmarkItem(R.string.name_oper_2, true));
        items.add(new BenchmarkItem(R.string.name_oper_2_array, false));
        items.add(new BenchmarkItem(R.string.name_oper_2_linked, false));
        items.add(new BenchmarkItem(R.string.name_oper_2_copyOn, false));
        items.add(new BenchmarkItem(R.string.name_oper_3, true));
        items.add(new BenchmarkItem(R.string.name_oper_3_array, false));
        items.add(new BenchmarkItem(R.string.name_oper_3_linked, false));
        items.add(new BenchmarkItem(R.string.name_oper_3_copyOn, false));
        items.add(new BenchmarkItem(R.string.name_oper_4, true));
        items.add(new BenchmarkItem(R.string.name_oper_4_array, false));
        items.add(new BenchmarkItem(R.string.name_oper_4_linked, false));
        items.add(new BenchmarkItem(R.string.name_oper_4_copyOn, false));
        items.add(new BenchmarkItem(R.string.name_oper_5, true));
        items.add(new BenchmarkItem(R.string.name_oper_5_array, false));
        items.add(new BenchmarkItem(R.string.name_oper_5_linked, false));
        items.add(new BenchmarkItem(R.string.name_oper_5_copyOn, false));
        items.add(new BenchmarkItem(R.string.name_oper_6, true));
        items.add(new BenchmarkItem(R.string.name_oper_6_array, false));
        items.add(new BenchmarkItem(R.string.name_oper_6_linked, false));
        items.add(new BenchmarkItem(R.string.name_oper_6_copyOn, false));
        items.add(new BenchmarkItem(R.string.name_oper_7, true));
        items.add(new BenchmarkItem(R.string.name_oper_7_array, false));
        items.add(new BenchmarkItem(R.string.name_oper_7_linked, false));
        items.add(new BenchmarkItem(R.string.name_oper_7_copyOn, false));
        return items;
    }


    @Override
    public long measureTime(BenchmarkItem task, int amount) {
        ArrayList<Integer> dataArrayListBenchmark = new ArrayList<>(Collections.nCopies(amount, 1));
        LinkedList<Integer> dataLinkedListBenchmark = new LinkedList<>(Collections.nCopies(amount, 1));
        CopyOnWriteArrayList<Integer> dataCopyOnWriteArrayListBenchmark = new CopyOnWriteArrayList<>(Collections.nCopies(amount, 1));

        switch (task.getTaskName()) {

            case R.string.name_oper_1_array:

                return addingInTheBeginning(dataArrayListBenchmark);

            case R.string.name_oper_1_linked:

                return addingInTheBeginning(dataLinkedListBenchmark);

            case R.string.name_oper_1_copyOn:

                return addingInTheBeginning(dataCopyOnWriteArrayListBenchmark);

            case R.string.name_oper_2_array:

                return addingInTheMiddle(dataArrayListBenchmark);

            case R.string.name_oper_2_linked:

                return addingInTheBeginning(dataLinkedListBenchmark);

            case R.string.name_oper_2_copyOn:

                return addingInTheBeginning(dataCopyOnWriteArrayListBenchmark);

            case R.string.name_oper_3_array:

                return addingInTheEnd(dataArrayListBenchmark);

            case R.string.name_oper_3_linked:

                return addingInTheBeginning(dataLinkedListBenchmark);

            case R.string.name_oper_3_copyOn:

                return addingInTheBeginning(dataCopyOnWriteArrayListBenchmark);

            case R.string.name_oper_4_array:
                return searchByValue(dataArrayListBenchmark);

            case R.string.name_oper_4_linked:

                return addingInTheBeginning(dataLinkedListBenchmark);

            case R.string.name_oper_4_copyOn:

                return addingInTheBeginning(dataCopyOnWriteArrayListBenchmark);

            case R.string.name_oper_5_array:

                return removingInTheBeginning(dataArrayListBenchmark);

            case R.string.name_oper_5_linked:

                return addingInTheBeginning(dataLinkedListBenchmark);

            case R.string.name_oper_5_copyOn:

                return addingInTheBeginning(dataCopyOnWriteArrayListBenchmark);

            case R.string.name_oper_6_array:

                return removingInTheMiddle(dataArrayListBenchmark);

            case R.string.name_oper_6_linked:

                return addingInTheBeginning(dataLinkedListBenchmark);

            case R.string.name_oper_6_copyOn:

                return addingInTheBeginning(dataCopyOnWriteArrayListBenchmark);

            case R.string.name_oper_7_array:

                return removingInTheEnd(dataArrayListBenchmark);

            case R.string.name_oper_7_linked:

                return addingInTheBeginning(dataLinkedListBenchmark);

            case R.string.name_oper_7_copyOn:

                return addingInTheBeginning(dataCopyOnWriteArrayListBenchmark);


            default:
                throw new RuntimeException("Exception in calculation time");
        }
    }


    private long addingInTheBeginning(List<Integer> dataListBenchmark) {
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
