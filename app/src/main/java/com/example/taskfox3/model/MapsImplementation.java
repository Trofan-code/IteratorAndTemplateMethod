package com.example.taskfox3.model;

import com.example.taskfox3.R;
import com.example.taskfox3.dto.BenchmarkItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class  MapsImplementation implements BenchmarkModel {

    @Override
    public List<BenchmarkItem> createNewTasks() {
        final List<BenchmarkItem> dataList = new ArrayList<>();
        dataList.add(new BenchmarkItem(R.string.name_oper_map_1));
        dataList.add(new BenchmarkItem(R.string.name_oper_map_2));
        dataList.add(new BenchmarkItem(R.string.name_oper_map_3));
        return dataList;
    }

    @Override
    public long measureTime(BenchmarkItem task, int amount) {

        Map<Integer,Integer> map = createHashMap(amount);

        switch (task.getTaskName()) {
            case R.string.name_oper_map_1:
               return   addingNew(map);

            case R.string.name_oper_map_2:
              return searchByKey(map);

            case R.string.name_oper_map_3:
               return removing(map);

            default:
                throw new RuntimeException("Exeption in calculation time");
        }
       
    }

    public Map<Integer, Integer> createHashMap(int elements) {
        Map<Integer, Integer> myHashMap = new HashMap<>();
        List<Integer> keyAndValue = new ArrayList<Integer>();
        for (int i = 0; i < elements - 1; i++) {
            keyAndValue.add(i, i + 1);
        }
        List<Integer> value = new ArrayList<Integer>();
        value = Collections.nCopies(elements, 5);
        for (int i = 0; i < keyAndValue.size(); i++) {
            myHashMap.put(keyAndValue.get(i), keyAndValue.get(i));
        }
        return myHashMap;
    }

    private long addingNew(Map<Integer,Integer> map) {
        long time = System.nanoTime();
        map.put(0, 0);
        time = System.nanoTime() - time;
        return time;
    }

    private long searchByKey(Map<Integer,Integer> map) {
        long time = System.nanoTime();
        map.put(0, 0);
        time = System.nanoTime() - time;
        return time;
    }

    private long removing(Map<Integer,Integer> map) {
        long time = System.nanoTime();
        map.put(0, 0);
        time = System.nanoTime() - time;
        return time;
    }
}
