package com.example.taskfox3.ui.fragment;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import static android.content.ContentValues.TAG;
import static com.example.taskfox3.dto.Types.SIZE_OF_OPERATION;

public class CollectionViewModel extends ViewModel {


    private Bundle bundleBenchmarkFragment;
    private String sizeOfElements;


    public CollectionViewModel(Bundle benchmarkFragment) {
        this.bundleBenchmarkFragment=benchmarkFragment;
    }



    public void setupItems() {

        // set list of items into ui
    }

    public void onCalculationStateChangeClicked(String elements, String threads, boolean isStart) {
        elements = getBundleString(bundleBenchmarkFragment,SIZE_OF_OPERATION," ");


        // start or stop calculation?

        // validate in case of start, stop - other way
        // Use TreadPool
    }
    public String getBundleString(Bundle b, String key, String def)
    {
        String value = b.getString(key);
        if (value == null)
            value = def;
        return value;
    }






//3. Заполнение коллекции происходит в потоке и каждый поток заполняет свой экземпляр коллекции.
    //Заполняй коллекцию через Colletiins nCopies
    //public static <T> List<T> nCopies(int n,T o)
//ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(sizeOfThreads));

//    private List addingInTheBeginning(){
//        intList = new ArrayList<Integer>();
//        intList =  Collections.nCopies(Integer.parseInt(sizeOfCollections), 1);
//        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(sizeOfThreads));
//        executor.submit(() -> {
//            intList.add(0, 2);
//        });
//        return intList;
//    };
//    private List addingInTheMiddle(){
//        intList = new ArrayList<Integer>();
//        intList =  Collections.nCopies(Integer.parseInt(sizeOfCollections), 1);
//        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(sizeOfThreads));
//        executor.submit(() -> {
//            intList.add((Integer.parseInt(sizeOfCollections))/2, 2);
//        });
//        return intList;
//    };
//    private List addingInTheEnd(){
//        intList = new ArrayList<Integer>();
//        intList =  Collections.nCopies(Integer.parseInt(sizeOfCollections), 1);
//       ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(sizeOfThreads));
//        executor.submit(() -> {
//            intList.add((Integer.parseInt(sizeOfCollections)), 3);
//        });
//        return intList;
//    };
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

}
















