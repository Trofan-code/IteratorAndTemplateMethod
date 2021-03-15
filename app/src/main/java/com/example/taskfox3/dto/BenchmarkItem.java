package com.example.taskfox3.dto;


public class BenchmarkItem {
    public static final int DEFAULT_TIME = -1;

    private boolean isInProgress = false;
    private boolean isTitle = false;
    private final int taskName;
    private long measuredTime;

    public BenchmarkItem(int taskName,boolean isTitle) {
        this.taskName = taskName;
        this.isTitle=isTitle;
        this.measuredTime = DEFAULT_TIME;
    }

    public boolean isInProgress() {
        return isInProgress;
    }

    public void setIsInProgress(boolean startOrNotProgressBar) {
        this.isInProgress = startOrNotProgressBar;
    }
    public boolean isTitle() {
        return isTitle;
    }

    public void setTitle(boolean title) {
        isTitle = title;
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
