package com.example.taskfox3.dto;

import java.util.List;

public class CollectionImplementation implements BenchmarkModlel {
    @Override
    public List<BenchmarkItem> setupItems() {

        return null;
    }

    @Override
    public long countTime() {

            long startTime = System.nanoTime();
            // methodToTrackTimeFor();
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            return duration;

    }
}
