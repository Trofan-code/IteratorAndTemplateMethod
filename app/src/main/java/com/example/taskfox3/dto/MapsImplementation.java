package com.example.taskfox3.dto;

import com.example.taskfox3.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapsImplementation implements BenchmarkModel {
    private List<BenchmarkItem> dataList;
    private String elements;
    private Map<Integer, Integer> operationHashMap;
    long durationAddingNew, durationSearchByKey, durationRemoving;

    @Override
    public String putElements(String elements) {
        return this.elements = elements;
    }

    @Override
    public List<BenchmarkItem> returnNewData() {
        dataList = new ArrayList<BenchmarkItem>();
        dataList.add(new BenchmarkItem(R.string.name_oper_1, addingNew()));
        dataList.add(new BenchmarkItem(R.string.name_oper_2, searchByKey()));
        dataList.add(new BenchmarkItem(R.string.name_oper_3, removing()));
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


    private long addingNew() {
        operationHashMap = returnHashMap(elements);
        long startTime = System.nanoTime();
        operationHashMap.put(0, 0);
        long endTime = System.nanoTime();
        durationAddingNew = (endTime - startTime);
        return durationAddingNew;
    }

    private long searchByKey() {
        operationHashMap = returnHashMap(elements);
        long startTime = System.nanoTime();
        operationHashMap.put(0, 0);
        long endTime = System.nanoTime();
        durationSearchByKey = (endTime - startTime);
        return durationSearchByKey;
    }

    private long removing() {
        operationHashMap = returnHashMap(elements);
        long startTime = System.nanoTime();
        operationHashMap.put(0, 0);
        long endTime = System.nanoTime();
        durationRemoving = (endTime - startTime);
        return durationRemoving;
    }

}
