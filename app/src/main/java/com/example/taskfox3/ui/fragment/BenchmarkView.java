package com.example.taskfox3.ui.fragment;

import com.example.taskfox3.dto.BenchmarkItem;

import java.util.List;

public interface BenchmarkView {

    void operationError();

    void threadsError();

    void setTasks(List<BenchmarkItem> newTasks);

    void updateItem(BenchmarkItem newItem, int position);

    void startProgressBar(boolean b);

    void returnMessageCalcDone();

    public void returnMessageCalcIsStopped();

    void buttonPositionReturnBack();

    public void showProgress();

    public void hideProgress();
}
