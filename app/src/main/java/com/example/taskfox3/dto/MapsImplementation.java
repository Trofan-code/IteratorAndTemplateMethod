package com.example.taskfox3.dto;

import com.example.taskfox3.R;
import com.example.taskfox3.ui.fragment.CollectionViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MapsImplementation implements BenchmarkModel {
    private List<BenchmarkItem> dataList;
    int numOfColums;
    private Map<Integer, Integer> operationHashMap;
    private CollectionViewModel model;
    long durationAddingNew, durationSearchByKey, durationRemoving;

    @Override
    public List<BenchmarkItem> returnMapOrColl(String elements, String threads) {
        dataList = new ArrayList<BenchmarkItem>();
        dataList.add(new BenchmarkItem(R.string.name_oper_1, addingNew(elements, threads)));
        dataList.add(new BenchmarkItem(R.string.name_oper_2, searchByKey(elements, threads)));
        dataList.add(new BenchmarkItem(R.string.name_oper_3, removing(elements, threads)));
        return dataList;

    }

    public List<BenchmarkItem> setupItems() {
        List<BenchmarkItem> dataList = new ArrayList<BenchmarkItem>();
        dataList.add(new BenchmarkItem(R.string.name_oper_map_1));
        dataList.add(new BenchmarkItem(R.string.name_oper_map_2));
        dataList.add(new BenchmarkItem(R.string.name_oper_map_3));
        return dataList;
    }

    public Map<Integer, Integer> returnHashMap(String elements) {
        Map<Integer, Integer> myHashMap = new HashMap<>();
        List<Integer> keyAndValue = new ArrayList<Integer>();
        for (int i = 0; i < Integer.parseInt(elements) - 1; i++) {
            keyAndValue.add(i, i + 1);
        }
        List<Integer> value = new ArrayList<Integer>();
        value = Collections.nCopies(Integer.parseInt(elements), 5);
        for (int i = 0; i < keyAndValue.size(); i++) {
            myHashMap.put(keyAndValue.get(i), keyAndValue.get(i));
        }
        return myHashMap;
    }


    private long addingNew(String elements, String threads) {
        operationHashMap = returnHashMap(elements);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            long startTime = System.nanoTime();
            operationHashMap.put(0, 0);
            long endTime = System.nanoTime();
            durationAddingNew = (endTime - startTime);
        });
        return durationAddingNew;
    }

    private long searchByKey(String elements, String threads) {
        operationHashMap = returnHashMap(elements);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            long startTime = System.nanoTime();
            operationHashMap.put(0, 0);
            long endTime = System.nanoTime();
            durationSearchByKey = (endTime - startTime);
        });
        return durationSearchByKey;
    }

    private long removing(String elements, String threads) {
        operationHashMap = returnHashMap(elements);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            long startTime = System.nanoTime();
            operationHashMap.put(0, 0);
            long endTime = System.nanoTime();
            durationRemoving = (endTime - startTime);
        });
        return durationRemoving;
    }

}
