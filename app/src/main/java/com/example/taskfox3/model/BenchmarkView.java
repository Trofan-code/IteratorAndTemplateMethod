package com.example.taskfox3.model;

import com.example.taskfox3.dto.BenchmarkItem;

import java.util.List;

public interface BenchmarkView {

    void operationError();

    void threadsError();

    void setTasks(List<BenchmarkItem> newTasks);
}
