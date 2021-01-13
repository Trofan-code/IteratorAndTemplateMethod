package com.example.taskfox3.ui.fragment;

import androidx.lifecycle.ViewModel;

import com.example.taskfox3.R;
import com.example.taskfox3.dto.BenchmarkItem;
import com.example.taskfox3.dto.BenchmarkModlel;
import com.example.taskfox3.dto.CollectionImplementation;
import com.example.taskfox3.dto.MapsImplementation;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;




public class CollectionViewModel extends ViewModel {
    private String sizeOfThreads;
    private String sizeOfOperations;
    private List<BenchmarkItem> dataList;
    private List<Integer> dataListBenchmark;
    private int type;
    private CollectionImplementation collectionImplementation;
    private MapsImplementation mapsImplementation;
    BenchmarkModlel benchmarkModlel;

    public String getSizeOfOperations() {
        return sizeOfOperations;
    }

    public void setSizeOfOperations(String sizeOfOperations) {
        this.sizeOfOperations = sizeOfOperations;
    }



    public String getSizeOfThreads() {
        return sizeOfThreads;
    }

    public void setSizeOfThreads(String sizeOfThreads) {
        this.sizeOfThreads = sizeOfThreads;
    }

    public CollectionViewModel(BenchmarkModlel benchmarkModlel) {
        this.benchmarkModlel = benchmarkModlel;
    }

    public CollectionViewModel(String sizeOfOperations, String sizeOfThreads) {
        this.sizeOfOperations = sizeOfOperations;
        this.sizeOfThreads = sizeOfThreads;
    }

    //https://www.youtube.com/watch?v=TwIjjTC5g7g


    public void setupItems() {

        // set list of items into ui
    }

    public void onCalculationStateChangeClicked(String elements, String threads, boolean isStart) {

        if(isStart){
            CollectionImplementation collectionImplementation = new CollectionImplementation();
            collectionImplementation.setupItems();


        }

        // start or stop calculation?

        // validate in case of start, stop - other way
        // Use TreadPool
    }

    public List<BenchmarkItem> setupItemsCollection(){
        dataList = new ArrayList<BenchmarkItem>();
        dataList.add(new BenchmarkItem(R.string.name_oper_1));
        dataList.add(new BenchmarkItem(R.string.name_oper_2));
        dataList.add(new BenchmarkItem(R.string.name_oper_3));
        dataList.add(new BenchmarkItem(R.string.name_oper_4));
        dataList.add(new BenchmarkItem(R.string.name_oper_5));
        dataList.add(new BenchmarkItem(R.string.name_oper_6));
        dataList.add(new BenchmarkItem(R.string.name_oper_7));
        return dataList;
    }
    public List<BenchmarkItem> setupItemsMaps(){
        dataList = new ArrayList<BenchmarkItem>();
        dataList.add(new BenchmarkItem(R.string.name_oper_map_1));
        dataList.add(new BenchmarkItem(R.string.name_oper_map_2));
        dataList.add(new BenchmarkItem(R.string.name_oper_map_3));

        return dataList;
    }

    public long countTimeMaps(){
        long startTime = System.nanoTime();
        // methodToTrackTimeFor();
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        return duration;
    }

    private List addingInTheBeginning(String elements, String threads){
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark =  Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            dataListBenchmark.add(0, 2);
        });
        return  dataListBenchmark;
    };

    private List addingInTheMiddle(String elements, String threads){
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark =  Collections.nCopies(Integer.parseInt(elements), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            dataListBenchmark.add((Integer.parseInt(elements))/2, 2);
        });
        return dataListBenchmark;
    };
    private List addingInTheEnd(String elements, String threads){
        dataListBenchmark = new ArrayList<Integer>();
        dataListBenchmark =  Collections.nCopies(Integer.parseInt(elements), 1);
       ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            dataListBenchmark.add((Integer.parseInt(elements)), 3);
        });
        return dataListBenchmark;
    };
//
///*addingInTheMiddle;
//     addingInTheEnd;
//     searchByValue;
//     removingInTheBeginning;
//     removingInTheMiddle;
//     removingInTheEnd;*/

//    public List<BenchmarkItem> initialDataTableCollection(){ //move to ViewModel
//        dataList = new ArrayList<BenchmarkItem>();
//        dataList.add(new BenchmarkItem(R.string.name_oper_1,"0",progressBar));
//        dataList.add(new BenchmarkItem(R.string.name_oper_2,"0",progressBar));
//        dataList.add(new BenchmarkItem(R.string.name_oper_3,"0",progressBar));
//        dataList.add(new BenchmarkItem(R.string.name_oper_4,"0",progressBar));
//        dataList.add(new BenchmarkItem(R.string.name_oper_5,"0",progressBar));
//        dataList.add(new BenchmarkItem(R.string.name_oper_6,"0",progressBar));
//        dataList.add(new BenchmarkItem(R.string.name_oper_7,"0",progressBar));
//        return dataList;
//    }
//
//    public List<BenchmarkItem> initialDataTableMap(){
//        dataList = new ArrayList<BenchmarkItem>();
//        dataList.add(new BenchmarkItem(R.string.name_oper_map_1,"0",progressBar));
//        dataList.add(new BenchmarkItem(R.string.name_oper_map_2,"0",progressBar));
//        dataList.add(new BenchmarkItem(R.string.name_oper_map_3,"0",progressBar));
//        return dataList;
//    }
//    public List<BenchmarkItem> exampleChange() {
//        dataList = new ArrayList<BenchmarkItem>();
//        dataList.add(new BenchmarkItem(R.string.name_oper_1,"333",progressBar));
//        dataList.add(new BenchmarkItem(R.string.name_oper_2,"333",progressBar));
//        dataList.add(new BenchmarkItem(R.string.name_oper_3,"333",progressBar));
//        dataList.add(new BenchmarkItem(R.string.name_oper_4,"333",progressBar));
//        dataList.add(new BenchmarkItem(R.string.name_oper_5,"333",progressBar));
//        dataList.add(new BenchmarkItem(R.string.name_oper_6,"333",progressBar));
//        dataList.add(new BenchmarkItem(R.string.name_oper_7,"333",progressBar));
//        return dataList;
//    }
/*public String getBundleString(Bundle b, String key, String def)
{
    String value = b.getString(key);
    if (value == null)
        value = def;
    return value;
}*/

}
















