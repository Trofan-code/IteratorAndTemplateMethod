package com.example.taskfox3.dto;

import android.widget.ProgressBar;

import com.example.taskfox3.R;

import java.util.ArrayList;
import java.util.List;


public class BenchmarkItem {
    public BenchmarkItem(int nameOfOperation) {
        this.nameOfOperation = nameOfOperation;
    }

    private int nameOfOperation;
    private long timeOfOperation;
    private ProgressBar progressBar;
    //all fields can be private
    // and final (timeOfOperation - non final)
    public BenchmarkItem() {
    }
    public BenchmarkItem(int nameOfOperation, long timeOfOperation, ProgressBar progressBar) {
        this.nameOfOperation = nameOfOperation;
        this.timeOfOperation = timeOfOperation;
        this.progressBar = progressBar;
    }
     List<BenchmarkItem> dataList = new ArrayList<>();

    public BenchmarkItem(List<BenchmarkItem> dataList) {
        this.dataList = dataList;
    }
    public int getNameOfOperation() {
        return nameOfOperation;
    }
    public long getTimeOfOperation() {
        return timeOfOperation;
    }
    public ProgressBar getProgressBar() {
        return progressBar;
    }
    private void setStandartValues() {


        dataList.add(new BenchmarkItem(R.string.name_oper_1, 0l, progressBar));
        dataList.add(new BenchmarkItem(R.string.name_oper_2, 0l, progressBar));
        dataList.add(new BenchmarkItem(R.string.name_oper_3, 0l, progressBar));
        dataList.add(new BenchmarkItem(R.string.name_oper_4, 0l, progressBar));
        dataList.add(new BenchmarkItem(R.string.name_oper_5, 0l, progressBar));
        dataList.add(new BenchmarkItem(R.string.name_oper_6, 0l, progressBar));
        dataList.add(new BenchmarkItem(R.string.name_oper_7, 0l, progressBar));
    }
}


