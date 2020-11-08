package com.example.taskfox3.fragment;

import android.widget.ProgressBar;

import java.util.List;

public class DataTable {
    int nameOfOperation;
    String timeOfOperation;
    ProgressBar progressBar;

    public DataTable(int nameOfOperation, String timeOfOperation, ProgressBar progressBar) {
        this.nameOfOperation = nameOfOperation;
        this.timeOfOperation = timeOfOperation;
        this.progressBar = progressBar;
    }
}


