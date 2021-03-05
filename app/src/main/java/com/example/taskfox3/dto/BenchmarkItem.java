package com.example.taskfox3.dto;

import android.view.View;
import android.widget.ProgressBar;

import com.example.taskfox3.R;


public class BenchmarkItem {
    public static final int DEFAULT_TIME = -1;

    private final int taskName;
    private long measuredTime;
    private ProgressBar progressBar;

    /*public ProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(boolean b) {
        this.progressBar = progressBar;
    }*/

    public BenchmarkItem(int taskName) {
        this.taskName = taskName;
        this.measuredTime = DEFAULT_TIME;

    }

    public int getTaskName() {
        return taskName;
    }

    public long getMeasuredTime() {
        return measuredTime;
    }
    public void setMeasuredTime(long measuredTime) {
        this.measuredTime = measuredTime;
    }

}


