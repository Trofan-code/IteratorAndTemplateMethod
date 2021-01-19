package com.example.taskfox3.dto;

import com.example.taskfox3.R;

import java.util.ArrayList;
import java.util.List;

public class CollectionImplementation implements BenchmarkModel {
    private static long TIME = -1;

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

}
