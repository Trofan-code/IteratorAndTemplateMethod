package com.example.taskfox3.dto;

public class BenchmarkItem {
    public static final int DEFAULT_TIME = -1;

    private final int taskName;
    private long measuredTime;

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


