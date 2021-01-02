package com.example.taskfox3.ui.fragment;

import androidx.lifecycle.ViewModel;

public class CollectionViewModel extends ViewModel {

    public CollectionViewModel() {
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

//    public List<DataTable> initialDataTableCollection(){ //move to ViewModel
//        dataList = new ArrayList<DataTable>();
//        dataList.add(new DataTable(R.string.name_oper_1,"0",progressBar));
//        dataList.add(new DataTable(R.string.name_oper_2,"0",progressBar));
//        dataList.add(new DataTable(R.string.name_oper_3,"0",progressBar));
//        dataList.add(new DataTable(R.string.name_oper_4,"0",progressBar));
//        dataList.add(new DataTable(R.string.name_oper_5,"0",progressBar));
//        dataList.add(new DataTable(R.string.name_oper_6,"0",progressBar));
//        dataList.add(new DataTable(R.string.name_oper_7,"0",progressBar));
//        return dataList;
//    }
//
//    public List<DataTable> initialDataTableMap(){
//        dataList = new ArrayList<DataTable>();
//        dataList.add(new DataTable(R.string.name_oper_map_1,"0",progressBar));
//        dataList.add(new DataTable(R.string.name_oper_map_2,"0",progressBar));
//        dataList.add(new DataTable(R.string.name_oper_map_3,"0",progressBar));
//        return dataList;
//    }
//    public List<DataTable> exampleChange() {
//        dataList = new ArrayList<DataTable>();
//        dataList.add(new DataTable(R.string.name_oper_1,"333",progressBar));
//        dataList.add(new DataTable(R.string.name_oper_2,"333",progressBar));
//        dataList.add(new DataTable(R.string.name_oper_3,"333",progressBar));
//        dataList.add(new DataTable(R.string.name_oper_4,"333",progressBar));
//        dataList.add(new DataTable(R.string.name_oper_5,"333",progressBar));
//        dataList.add(new DataTable(R.string.name_oper_6,"333",progressBar));
//        dataList.add(new DataTable(R.string.name_oper_7,"333",progressBar));
//        return dataList;
//    }

    public void setupItems() {
        // set list of items into ui
    }

    public void onCalculationStateChangeClicked(String elements, String threads, boolean isStart) {
        // start or stop calculation?
        // validate in case of start, stop - other way
        // Use TreadPool
    }
}
















