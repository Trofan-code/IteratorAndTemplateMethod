package com.example.taskfox3.dto;

import android.widget.ProgressBar;

import com.example.taskfox3.R;

import java.util.ArrayList;
import java.util.List;


public class DataTable {
    int nameOfOperation;
    String timeOfOperation;
    ProgressBar progressBar;
    public DataTable() {
    }
    public DataTable(int nameOfOperation, String timeOfOperation, ProgressBar progressBar) {
        this.nameOfOperation = nameOfOperation;
        this.timeOfOperation = timeOfOperation;
        this.progressBar = progressBar;
    }
     List<DataTable> dataList = new ArrayList<>();

    public DataTable(List<DataTable> dataList) {
        this.dataList = dataList;
    }
    public int getNameOfOperation() {
        return nameOfOperation;
    }
    public String getTimeOfOperation() {
        return timeOfOperation;
    }
    public ProgressBar getProgressBar() {
        return progressBar;
    }
    private void setStandartValues() {
        dataList.add(new DataTable(R.string.name_oper_1, "0", progressBar));
        dataList.add(new DataTable(R.string.name_oper_2, "0", progressBar));
        dataList.add(new DataTable(R.string.name_oper_3, "0", progressBar));
        dataList.add(new DataTable(R.string.name_oper_4, "0", progressBar));
        dataList.add(new DataTable(R.string.name_oper_5, "0", progressBar));
        dataList.add(new DataTable(R.string.name_oper_6, "0", progressBar));
        dataList.add(new DataTable(R.string.name_oper_7, "0", progressBar));
    }
}


