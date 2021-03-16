package com.example.taskfox3.ui.fragment;

import com.example.taskfox3.dto.BenchmarkItem;

import java.util.List;

public interface BenchmarkView {

    void operationError();

    void threadsError();

    void setTasks(List<BenchmarkItem> newTasks);

    void updateItem(BenchmarkItem newItem, int position);

    void messageCalcOver();

    void messageCalcIsStopped();

    void buttonStopped();

    void showProgress();

    void hideProgress();

    void messageErrorLargeSizeOperation();


}
