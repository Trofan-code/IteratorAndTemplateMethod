package com.example.taskfox3.dto;

import com.example.taskfox3.R;

import java.util.ArrayList;
import java.util.List;

public class MapsImplementation implements BenchmarkModel {

    public List<BenchmarkItem> setupItems() {
        List<BenchmarkItem> dataList = new ArrayList<BenchmarkItem>();
        dataList.add(new BenchmarkItem(R.string.name_oper_map_1));
        dataList.add(new BenchmarkItem(R.string.name_oper_map_2));
        dataList.add(new BenchmarkItem(R.string.name_oper_map_3));
        return dataList;
    }

}
