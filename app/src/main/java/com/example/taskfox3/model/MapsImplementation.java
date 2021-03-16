package com.example.taskfox3.model;

import com.example.taskfox3.R;
import com.example.taskfox3.dto.BenchmarkItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class MapsImplementation implements BenchmarkModel {

    @Override
    public List<BenchmarkItem> createNewTasks() {
        final List<BenchmarkItem> dataList = new ArrayList<>();
        dataList.add(new BenchmarkItem(R.string.name_oper_map_1, true));
        dataList.add(new BenchmarkItem(R.string.name_oper_map_1_hash_map, false));
        dataList.add(new BenchmarkItem(R.string.name_oper_map_1_tree_map, false));

        dataList.add(new BenchmarkItem(R.string.name_oper_map_2, true));
        dataList.add(new BenchmarkItem(R.string.name_oper_map_2_hash_map, false));
        dataList.add(new BenchmarkItem(R.string.name_oper_map_2_tree_map, false));

        dataList.add(new BenchmarkItem(R.string.name_oper_map_3, true));
        dataList.add(new BenchmarkItem(R.string.name_oper_map_3_tree_map, false));
        dataList.add(new BenchmarkItem(R.string.name_oper_map_3_hash_map, false));
        return dataList;
    }

    @Override
    public long measureTime(BenchmarkItem task, int amount) {

        Map<Integer, Integer> mapHash = createHashMap(amount);
        Map<Integer, Integer> mapTree = createTreeMap(amount);

        switch (task.getTaskName()) {
            case R.string.name_oper_map_1_hash_map:
                return addingNew(mapHash);

            case R.string.name_oper_map_2_hash_map:
                return searchByKey(mapHash);

            case R.string.name_oper_map_3_hash_map:
                return removing(mapHash);

            case R.string.name_oper_map_1_tree_map:
                return addingNew(mapTree);

            case R.string.name_oper_map_2_tree_map:
                return searchByKey(mapTree);

            case R.string.name_oper_map_3_tree_map:
                return removing(mapTree);

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

    public Map<Integer, Integer> createTreeMap(int elements) {
        Map<Integer, Integer> myTreeMap = new TreeMap<>();
        List<Integer> keyAndValue = new ArrayList<Integer>();
        for (int i = 0; i < elements - 1; i++) {
            keyAndValue.add(i, i + 1);
        }
        List<Integer> value = new ArrayList<Integer>();
        value = Collections.nCopies(elements, 5);
        for (int i = 0; i < keyAndValue.size(); i++) {
            myTreeMap.put(keyAndValue.get(i), keyAndValue.get(i));
        }
        return myTreeMap;
    }

    private long addingNew(Map<Integer, Integer> map) {
        long time = System.nanoTime();
        map.put(0, 0);
        return (System.nanoTime() - time)/1000;
    }

    private long searchByKey(Map<Integer, Integer> map) {
        long time = System.nanoTime();
        map.get(0);
        return (System.nanoTime() - time)/1000;

    }

    private long removing(Map<Integer, Integer> map) {
        long time = System.nanoTime();
        map.remove(0);
        return (System.nanoTime() - time)/1000;
    }


}
