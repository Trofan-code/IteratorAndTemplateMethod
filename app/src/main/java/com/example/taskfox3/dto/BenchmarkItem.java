package com.example.taskfox3.dto;

import android.widget.ProgressBar;

import com.example.taskfox3.R;

import java.util.ArrayList;
import java.util.List;


public class BenchmarkItem {


    private int nameOfOperation;
    private long timeOfOperation;
    private ProgressBar progressBar;
    List<BenchmarkItem> dataList = new ArrayList<>();

    //all fields can be private
    // and final (timeOfOperation - non final)

    public BenchmarkItem(int nameOfOperation) {
        this.nameOfOperation = nameOfOperation;
    }

    public BenchmarkItem(int nameOfOperation, long timeOfOperation) {
        this.nameOfOperation = nameOfOperation;
        this.timeOfOperation = timeOfOperation;
        //this.progressBar = progressBar;
    }


    public BenchmarkItem(List<BenchmarkItem> dataList) {
        this.dataList = dataList;
    }

    public BenchmarkItem() {
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

}


