package com.example.taskfox3.model;

import com.example.taskfox3.dto.BenchmarkItem;

import java.util.List;

public interface BenchmarkModel {

    List<BenchmarkItem> createNewTasks();

    long measureTime(BenchmarkItem task, int amount);


}
