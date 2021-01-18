package com.example.taskfox3.dto;

import com.example.taskfox3.R;

import java.util.ArrayList;
import java.util.List;

public class CollectionImplementation implements BenchmarkModel {

    public List<BenchmarkItem> setupItems() {
        List<BenchmarkItem> dataList = new ArrayList<>();
        dataList.add(new BenchmarkItem(R.string.name_oper_1, 0l));
        dataList.add(new BenchmarkItem(R.string.name_oper_2, 0l));
        dataList.add(new BenchmarkItem(R.string.name_oper_3, 0l));
        dataList.add(new BenchmarkItem(R.string.name_oper_4, 0l));
        dataList.add(new BenchmarkItem(R.string.name_oper_5, 0l));
        dataList.add(new BenchmarkItem(R.string.name_oper_6, 0l));
        dataList.add(new BenchmarkItem(R.string.name_oper_7, 0l));
        return dataList;
    }

}
